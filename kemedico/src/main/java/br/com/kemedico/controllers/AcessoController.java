package br.com.kemedico.controllers;

import java.security.Principal;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.kemedico.daos.ClinicaDAO;
import br.com.kemedico.daos.EspecializacaoDAO;
import br.com.kemedico.daos.LocalidadeDAO;
import br.com.kemedico.daos.PacienteDAO;
import br.com.kemedico.daos.PagamentoDAO;
import br.com.kemedico.daos.PlanoSaudeDAO;
import br.com.kemedico.daos.ProfSaudeDAO;
import br.com.kemedico.daos.RoleDAO;
import br.com.kemedico.daos.TipoUsuarioDAO;
import br.com.kemedico.daos.UsuarioDAO;
import br.com.kemedico.enums.Tipo;
import br.com.kemedico.model.Clinica;
import br.com.kemedico.model.Especializacao;
import br.com.kemedico.model.Paciente;
import br.com.kemedico.model.PlanoSaude;
import br.com.kemedico.model.ProfissionalSaude;
import br.com.kemedico.model.Usuario;
import br.com.kemedico.utils.Mensagem;
import br.com.kemedico.utils.Pesquisa;

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
	@Autowired
	UsuarioDAO usdao;
	@Autowired
	LocalidadeDAO ldao;
	@Autowired
	RoleDAO rldao;
	@Autowired
	ProfSaudeDAO pfdao;
	@Autowired
	PagamentoDAO mpdao;
	@Autowired
	TipoUsuarioDAO tpdao;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@RequestMapping(value = "/", name = "home")
	public ModelAndView index(Pesquisa pesquisa) {
		ModelAndView view = new ModelAndView("index");
		view.addObject("planos", psdao.lista());
		view.addObject("cidades", ldao.getAllCidades());
		view.addObject("especialidades", espdao.getAll());
		view.addObject("mensagem", new Mensagem("teste", Tipo.SUCESSO));
		return view;
	}

	@RequestMapping(value = "/login", name = "login", method = RequestMethod.GET)
	public String entrarForm() {
		return "loginForm";
	}

	@RequestMapping(value = "/cadastro", name = "cadastro")
	public ModelAndView paginaCadastro() {
		return new ModelAndView("cadastro");
	}

	// Cadastro de Pacientes

	@RequestMapping(value = "/minhaconta/", name = "my")
	public ModelAndView minhaConta(Principal p) {
		ModelAndView view = new ModelAndView();

		Usuario user = (Usuario) usdao.loadUserByUsername(p.getName());
		user.toString();
		if (user != null) {
			String dataNasc = null;
			if (user.getDataNascimento() != null) {
			 dataNasc = user.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			}
			if (user.getTipoUsuario().getDesc_tipo().equals("Paciente")) {
				Paciente pac = pacientedao.getById(user.getId());
				view.addObject("pac", pac);
				view.setViewName("edita-p");
				view.addObject("dataNasc", dataNasc);
				return view;
			}
			if (user.getTipoUsuario().getDesc_tipo().equals("Clinica")) {
				Clinica cli = cldao.getById(user.getId());
				view.addObject("cli", cli);
				view.addObject("planos", psdao.lista());
				view.addObject("especialidades", espdao.getAll());
				view.addObject("meios", mpdao.getAll());
				view.addObject("dataNasc", dataNasc);
				view.addObject("cifroes",mpdao.getCifroes());
				System.out.println(cli.toString());
				view.setViewName("edita-c");
				return view;
			}
			if (user.getTipoUsuario().getDesc_tipo().equals("ProfSaude")) {
				ProfissionalSaude prof = pfdao.getById(user.getId());
				view.addObject("profsaude", prof);
				System.out.println(prof.toString());
				view.addObject("planos", psdao.lista());
				view.addObject("especialidades", espdao.getAll());
				view.addObject("meios", mpdao.getAll());
				view.addObject("dataNasc", dataNasc);
				view.addObject("cifroes", mpdao.getCifroes());
				view.setViewName("edita-e");
				return view;
			}
		}
		return view;
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

	@RequestMapping(value = "/premium/beneficios", name = "benef", method = RequestMethod.GET)
	public String mostrarBeneficios() {
		return "premium";
	}

}
