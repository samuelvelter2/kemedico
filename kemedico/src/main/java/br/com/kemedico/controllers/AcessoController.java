package br.com.kemedico.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.kemedico.daos.EspecializacaoDAO;
import br.com.kemedico.daos.PacienteDAO;
import br.com.kemedico.model.Especializacao;
import br.com.kemedico.model.Paciente;
import br.com.kemedico.model.ProfissionalSaude;
import br.com.kemedico.model.Usuario;

@Controller
public class AcessoController {
	@Autowired
	PacienteDAO pacientedao;
	@Autowired
	EspecializacaoDAO espdao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String entrarForm() {
		return "loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Usuario usuario) {
		System.out.println(usuario.toString());
		return "index";
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String paginaCadastro() {
		return "cadastro";
	}

	// Cadastro de Pacientes
	@RequestMapping(value = "/cadastro/paciente", name = "cad_pac", method = RequestMethod.POST)
	public ModelAndView cadastrar(Paciente paciente, String senhaP, String senhaRepetir, String dataNasc,
			String numeroCPF) {
		System.out.println(dataNasc);
		paciente.setDataNascimento(LocalDate.parse(dataNasc));
		if (!senhaP.equals(senhaRepetir)) {
			return new ModelAndView("erro");
		}
		paciente.setSenha(senhaP);
		paciente.setCpf(numeroCPF);
		System.out.println(paciente.toString());
		pacientedao.salva(paciente);
		ModelAndView andView = new ModelAndView("index");
		return andView;
	}

	@RequestMapping(value = "/cadastro/paciente", name = "cad_pac_bd", method = RequestMethod.GET)
	public String cadastroPaciente() {
		return "cadastro-p";
	}

	// Cadastro Profissonal da Saude
	@RequestMapping(value = "/cadastro/profsaude", name = "cad_prof", method = RequestMethod.GET)
	public String cadastroProfSaude(@ModelAttribute("especialidades") ArrayList<Especializacao> esp) {
		esp.addAll(espdao.getEspecializacoes());
		return "cadastro-e";
	}

	@RequestMapping(value = "/cadastro/profsaude", name = "cad_prof_bd", method = RequestMethod.POST)
	public String cadastroProfSaudebd(ProfissionalSaude pf, String especialidade) {
		System.out.println(pf.toString() + especialidade);
		return "index";
	}

}
