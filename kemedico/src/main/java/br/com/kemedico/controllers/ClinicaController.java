package br.com.kemedico.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.kemedico.daos.AvaliacaoDAO;
import br.com.kemedico.daos.ClinicaDAO;
import br.com.kemedico.daos.EspecializacaoDAO;
import br.com.kemedico.daos.FotoDAO;
import br.com.kemedico.daos.LocalidadeDAO;
import br.com.kemedico.daos.PagamentoDAO;
import br.com.kemedico.daos.PlanoSaudeDAO;
import br.com.kemedico.daos.RoleDAO;
import br.com.kemedico.daos.TipoUsuarioDAO;
import br.com.kemedico.enums.Tipo;
import br.com.kemedico.model.Clinica;
import br.com.kemedico.model.Especializacao;
import br.com.kemedico.model.Foto;
import br.com.kemedico.model.MeioPagamento;
import br.com.kemedico.model.PlanoSaude;
import br.com.kemedico.model.Role;
import br.com.kemedico.utils.Mensagem;

@Controller
public class ClinicaController {
	@Autowired
	PagamentoDAO mpdao;
	@Autowired
	TipoUsuarioDAO tpdao;
	@Autowired
	LocalidadeDAO ldao;
	@Autowired
	RoleDAO rldao;
	@Autowired
	EspecializacaoDAO espdao;
	@Autowired
	PlanoSaudeDAO psdao;
	@Autowired
	ClinicaDAO cldao;
	@Autowired
	FotoDAO fdao;
	@Autowired
	AvaliacaoDAO avdao;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@RequestMapping(value = "/cadastro/clinica", method = RequestMethod.GET, name = "cad_cli")
	public ModelAndView cadastroClinica(@ModelAttribute("clinica") Clinica clinica) {
		ModelAndView view = new ModelAndView("cadastro-c");
		view.addObject("planos", psdao.lista());
		view.addObject("meios", mpdao.getAll());
		view.addObject("especialidades", espdao.getAll());
		view.addObject("cifroes", mpdao.getCifroes());
		return view;
	}

	@RequestMapping(value = "/minhaconta/clinica/atualiza", name = "update_cli")
	public ModelAndView editaClinica(@ModelAttribute("clinica") Clinica cli, MultipartFile fotoPerfilP, String bairro1,
			String cidade1, String uf1) throws IOException {
		ModelAndView view = new ModelAndView("forward:/minhaconta/");
		uf1 = uf1.replace(",", "");
		System.out.println(uf1);
		cidade1 = cidade1.replace(",", "");
		bairro1 = bairro1.replace(",", "");
		Clinica cl = cldao.getById(cli.getId());
		System.out.println(cl.toString());
		cli.setCidade(ldao.createIfNotExistCidade(cidade1, uf1));
		cli.setBairro(ldao.createIfNotExistBairro(bairro1, cidade1, uf1));		
		if (fotoPerfilP != null) {
			Foto foto = cli.getFotoPerfil();
			if (foto == null) {
				foto = new Foto();
				foto.setFoto(fotoPerfilP.getBytes());
				fdao.salva(foto);
			}
			cli.setFotoPerfil(foto);
			
		}
		cli.getAtualizado(cl);
		cldao.update(cli);
		view.addObject("mensagem", new Mensagem("Clinica Atualizada com sucesso", Tipo.SUCESSO));
		return view;
	}

	@RequestMapping(value = "/cadastro/clinica", method = RequestMethod.POST, name = "cad_cli_bd")
	public ModelAndView cadastroClinicaBd(@ModelAttribute("clinica") Clinica cli, String senhaP, String senhaRepetir,
			String bairro1, String cidade1, String uf1, MultipartFile fotoPerfilP) throws IOException {
		System.out.println(cli.toString());
		ModelAndView view = new ModelAndView();
		uf1 = uf1.replace(",", "");
		cidade1 = cidade1.replace(",", "");
		bairro1 = bairro1.replace(",", "");
		System.out.println(fotoPerfilP);
		if (fotoPerfilP != null) {

			Foto foto = new Foto();
			foto.setFoto(fotoPerfilP.getBytes());
			fdao.salva(foto);
			cli.setFotoPerfil(foto);
		}

		if (!senhaP.equals(senhaRepetir)) {
			view.setViewName("cadastro-c");
			view.addObject("planos", psdao.lista());
			view.addObject("meios", mpdao.getAll());
			view.addObject("especialidades", espdao.getAll());
			view.addObject("mensagem", new Mensagem("As senhas devem coincidir!", Tipo.ERRO));
			return view;
		}
		senhaP = senhaRepetir.replace(",", "");
		cli.setTipoUsuario(tpdao.getByDesc("Clinica"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(rldao.getRole("ROLE_CLINICA"));
		cli.setRoles(roles);
		cli.setCidade(ldao.createIfNotExistCidade(cidade1, uf1));
		cli.setBairro(ldao.createIfNotExistBairro(bairro1, cidade1, uf1));
		String senha = passwordEncoder.encode(senhaP);
		cli.setSenha(senha);
		cldao.salva(cli);
		view.setViewName("redirect:/");
		view.addObject("mensagem", new Mensagem("Clinica cadastrada com sucesso", Tipo.SUCESSO));
		return view;

	}

	@RequestMapping(value = "/listar/clinicas", method = RequestMethod.GET)
	public String listaClinicas() {
		System.out.println(cldao.lista().toString());
		return "index";
	}
	@RequestMapping(value ="/clinica/{id}",name = "clinica")
	public ModelAndView clinica(@PathVariable("id")Long id) {
		ModelAndView view = new ModelAndView("clinica");		
		view.addObject("clinica", cldao.getById(id));
		view.addObject("avaliacoes", avdao.getAllByAvaliatedClinica(cldao.getById(id)));
		return view;
		
	}

	@InitBinder
	protected void initBinder1(WebDataBinder binder) throws Exception {
		CustomCollectionEditor planosCollector = new CustomCollectionEditor(List.class) {
			@Override
			protected Object convertElement(Object element) {
				if (element instanceof String) {
					Long id = Long.parseLong(element.toString());

					Especializacao esp = new Especializacao();
					esp.setIdEsp(id);
					return esp;
				}
				throw new RuntimeException("Spring says: Não sei o que fazer com esse elemento: " + element);
			}

		};
		binder.registerCustomEditor(List.class, "especialidades", planosCollector);
	}

	@InitBinder
	protected void initBinder2(WebDataBinder binder) throws Exception {
		CustomCollectionEditor planosCollector = new CustomCollectionEditor(List.class) {
			@Override
			protected Object convertElement(Object element) {
				if (element instanceof String) {
					Long id = Long.parseLong(element.toString());

					PlanoSaude ps = new PlanoSaude();
					ps.setId(id);
					return ps;
				}
				throw new RuntimeException("Spring says: Não sei o que fazer com esse elemento: " + element);
			}

		};
		binder.registerCustomEditor(List.class, "planos", planosCollector);
	}

	@InitBinder
	protected void initBinder3(WebDataBinder binder) throws Exception {
		CustomCollectionEditor meiosCollector = new CustomCollectionEditor(List.class) {
			@Override
			protected Object convertElement(Object element) {
				if (element instanceof String) {
					Long id = Long.parseLong(element.toString());

					MeioPagamento mp = new MeioPagamento();
					mp.setIdMeio(id);
					return mp;
				}
				throw new RuntimeException("Spring says: Não sei o que fazer com esse elemento: " + element);
			}

		};
		binder.registerCustomEditor(List.class, "meiosPagamento", meiosCollector);
	}
}
