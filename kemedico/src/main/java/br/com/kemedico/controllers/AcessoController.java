package br.com.kemedico.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.kemedico.daos.ClinicaDAO;
import br.com.kemedico.daos.EspecializacaoDAO;
import br.com.kemedico.daos.PacienteDAO;
import br.com.kemedico.daos.PlanoSaudeDAO;
import br.com.kemedico.model.Clinica;
import br.com.kemedico.model.Especializacao;
import br.com.kemedico.model.Paciente;
import br.com.kemedico.model.PlanoSaude;
import br.com.kemedico.model.Usuario;

@Controller
public class AcessoController {
	@Autowired
	PacienteDAO pacientedao;
	@Autowired
	EspecializacaoDAO espdao;	
	@Autowired
	PlanoSaudeDAO psdao;
	@Autowired
	ClinicaDAO cldao;
	

	@RequestMapping(value = "/login", name = "login", method = RequestMethod.GET)
	public String entrarForm() {
		return "loginForm";
	}

	@RequestMapping(value = "/login", name = "loginbd", method = RequestMethod.POST)
	public String login(Usuario usuario) {
		System.out.println(usuario.toString());
		return "index";
	}

	@RequestMapping(value = "/cadastro", name = "cadastro", method = RequestMethod.GET)
	public String paginaCadastro() {
		return "cadastro";
	}

	// Cadastro de Pacientes
	@RequestMapping(value = "/cadastro/paciente", name = "cad_pac_bd", method = RequestMethod.POST)
	public ModelAndView cadastrar(Paciente paciente, String senhaP, String senhaRepetir, String dataNasc,
			String numeroCPF) {
		System.out.println(dataNasc);
		dataNasc = dataNasc.replace(",", "");
		paciente.setDataNascimento(LocalDate.parse(dataNasc));
		paciente.setSenha(senhaP);
		paciente.setNumeroCpf(numeroCPF);
		System.out.println(paciente.toString());
		pacientedao.salva(paciente);
		ModelAndView andView = new ModelAndView("index");
		return andView;
	}

	@RequestMapping(value = "/cadastro/paciente", name = "cad_pac", method = RequestMethod.GET)
	public String cadastroPaciente() {
		return "cadastro-p";
	}

	

	@RequestMapping(value = "/cadastro/especialidade", name = "cad_esp", method = RequestMethod.GET)
	public String cadastroEspecialidade() {
		return "cadesp";
	}

	@RequestMapping(value = "/cadastro/especialidade", name = "cad_esp_bd", method = RequestMethod.POST)
	public String cadastroEspecialidadeBd(Especializacao esp) {
		espdao.salva(esp);
		return "cadastro";
	}

	@RequestMapping(value = "/listar/", method = RequestMethod.GET)
	public String listas() {

		return "listas";
	}
	
	@RequestMapping(value = "/listar/clinicas", method = RequestMethod.GET)
	public String listaClinicas() {
		System.out.println(cldao.lista().toString());
		return "index";
	}
	@RequestMapping(value = "/cadastro/planosaude", method = RequestMethod.GET, name = "cad_ps")
	public String cadastroPlanoSaude() {
		return "cadastro-ps";
	}
	@RequestMapping(value = "/cadastro/planosaude", method = RequestMethod.POST, name = "cad_ps_bd")
	public String cadastroPlanoSaudeBd(PlanoSaude ps) {
		ps.toString();
		psdao.salva(ps);
		return "index";
	}
	@RequestMapping(value = "/cadastro/clinica",method = RequestMethod.GET,name = "cad_cli")
	public String cadastroClinica(@ModelAttribute("clinica")Clinica clinica,@ModelAttribute("planosSaude")ArrayList<PlanoSaude> planos) {
		planos.addAll(psdao.lista());
		return "cadastro-c";
	}
	@RequestMapping(value = "/cadastro/clinica",method = RequestMethod.POST,name = "cad_cli_bd")
	public String cadastroClinicaBd(@ModelAttribute("clinica")Clinica cli) {
		System.out.println(cli.toString());
		cldao.salva(cli);	
		return "index";
	}
	@RequestMapping(value = "/premium/beneficios",name = "benef", method = RequestMethod.GET)
	public String mostrarBeneficios() {
		return "premium";
	}
	
	
}
