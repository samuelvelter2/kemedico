package br.com.kemedico.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.DataLengthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.kemedico.daos.LocalidadeDAO;
import br.com.kemedico.daos.PacienteDAO;
import br.com.kemedico.daos.RoleDAO;
import br.com.kemedico.daos.TipoUsuarioDAO;
import br.com.kemedico.enums.Tipo;
import br.com.kemedico.model.Paciente;
import br.com.kemedico.model.Role;
import br.com.kemedico.utils.Mensagem;

@Controller
public class PacienteController {

	@Autowired
	PacienteDAO pacientedao;
	@Autowired
	TipoUsuarioDAO tpdao;
	@Autowired
	RoleDAO rldao;
	@Autowired
	LocalidadeDAO ldao;
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@RequestMapping(value = "/cadastro/paciente", name = "cad_pac_bd", method = RequestMethod.POST)
	public ModelAndView cadastrar(@ModelAttribute("paciente") Paciente paciente, String senhaP, String senhaRepetir,
			String dataNasc, String numeroCPF) {
		System.out.println(dataNasc);
		System.out.println("senha:" + senhaP + "Repetir:" + senhaRepetir);
		dataNasc = dataNasc.replace(",", "");
		if (!senhaP.contentEquals(senhaRepetir)) {
			throw new DataLengthException("As senhas devem conicidir!");
		}
		senhaP = senhaRepetir.replace(",", "");
		String senha = passwordEncoder.encode(senhaP);
		paciente.setDataNascimento(LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		paciente.setSenha(senha);
		paciente.setNumeroCpf(numeroCPF);
		paciente.setTipoUsuario(tpdao.getByDesc("Paciente"));

		List<Role> roles = new ArrayList<Role>();
		roles.add(rldao.getRole("ROLE_USER"));
		paciente.setRoles(roles);
		System.out.println(paciente.toString());
		pacientedao.salva(paciente);
		ModelAndView andView = new ModelAndView("redirect:/");
		String mensagem = "Cadastro realizado com sucesso";
		andView.addObject("mensagem", new Mensagem(mensagem, Tipo.SUCESSO));
		return andView;
	}

	@RequestMapping(value = "/cadastro/paciente", name = "cad_pac", method = RequestMethod.GET)
	public ModelAndView cadastroPaciente(@ModelAttribute("paciente") Paciente paciente) {
		ModelAndView view = new ModelAndView("cadastro-p");
		view.addObject("estados", ldao.getAllUF());
		return view;
	}
	@RequestMapping(value = "/minhaconta/paciente/atualizar",name = "pac_updt")
	public ModelAndView atualizaPaciente(@ModelAttribute("pac")Paciente pac) {
		ModelAndView view =  new ModelAndView();
		return view;
	}

}
