package br.com.kemedico.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.DataLengthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.kemedico.daos.AvaliacaoDAO;
import br.com.kemedico.daos.EspecializacaoDAO;
import br.com.kemedico.daos.FotoDAO;
import br.com.kemedico.daos.LocalidadeDAO;
import br.com.kemedico.daos.PagamentoDAO;
import br.com.kemedico.daos.PlanoSaudeDAO;
import br.com.kemedico.daos.ProfSaudeDAO;
import br.com.kemedico.daos.RoleDAO;
import br.com.kemedico.daos.TipoUsuarioDAO;
import br.com.kemedico.enums.Tipo;
import br.com.kemedico.model.Foto;
import br.com.kemedico.model.MeioPagamento;
import br.com.kemedico.model.PlanoSaude;
import br.com.kemedico.model.ProfissionalSaude;
import br.com.kemedico.model.Role;
import br.com.kemedico.utils.Mensagem;

@Controller
public class ProfSaudeController {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	ProfSaudeDAO profdao;
	@Autowired
	EspecializacaoDAO espdao;
	@Autowired
	FotoDAO fd;
	@Autowired
	LocalidadeDAO ldao;
	@Autowired
	PlanoSaudeDAO psdao;
	@Autowired
	PagamentoDAO mpdao;
	@Autowired
	TipoUsuarioDAO tpdao;
	@Autowired
	RoleDAO rldao;
	@Autowired
	AvaliacaoDAO avdao;

	// Cadastro Profissonal da Saude
	@RequestMapping(value = "/cadastro/profsaude", name = "cad_prof", method = RequestMethod.GET)
	public ModelAndView cadastroProfSaude(@ModelAttribute("profsaude") ProfissionalSaude pf) {
		ModelAndView view = new ModelAndView("cadastro-e");
		view.addObject("especialidades", espdao.getAll());
		view.addObject("planos", psdao.lista());
		view.addObject("meios",mpdao.getAll());
		view.addObject("cifroes", mpdao.getCifroes());
		return view;
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public void handle(Exception e) {
	    e.printStackTrace();
	}

	@RequestMapping(value = "/cadastro/profsaude", name = "cad_prof_bd", method = RequestMethod.POST)
	public ModelAndView cadastroProfSaudebd1(@ModelAttribute("profsaude") ProfissionalSaude pf,
			MultipartFile fotoPerfilp, String senhaP, String senhaRepetir, String dataNasc, String bairro1,
			String cidade1, String uf1) throws IOException {
		if (!senhaP.contentEquals(senhaRepetir)) {
			throw new DataLengthException("As senhas devem conicidir!");
		}
		uf1 = uf1.replace(",", "");
		cidade1 = cidade1.replace(",", "");
		bairro1 = bairro1.replace(",", "");
		senhaP = senhaRepetir.replace(",", "");
		dataNasc = dataNasc.replace(",", "");		
		System.out.println(pf.toString());
		Foto foto = Foto.getFoto(fotoPerfilp.getBytes());
		fd.salva(foto);
		List<Role> roles = new ArrayList<Role>();
		roles.add(rldao.getRole("ROLE_PROFSAU"));
		pf.setRoles(roles);
		pf.setTipoUsuario(tpdao.getByDesc("ProfSaude"));
		pf.setSenha(passwordEncoder.encode(senhaP));
		pf.setCidade(ldao.createIfNotExistCidade(cidade1, uf1));
		pf.setBairro(ldao.createIfNotExistBairro(bairro1, cidade1, uf1));
		pf.setFotoPerfil(foto);
		pf.setDataNascimento(LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		profdao.salva(pf);
		ModelAndView view = new ModelAndView("redirect:/");
		view.addObject("mensagem", new Mensagem(
				"Especialista Cadastrado com Sucesso!",
				Tipo.SUCESSO));
		return view;

	}
	@RequestMapping(value = "/minhaconta/profsaude/atualiza" , name = "update_prof")
	public ModelAndView editaProf(@ModelAttribute("prof_saude")ProfissionalSaude prof,MultipartFile fotoPerfilP, String dataNasc,String bairro1,
			String cidade1, String uf1) throws IOException {
		ModelAndView view = new ModelAndView("forward:/minhaconta/");
		uf1 = uf1.replace(",", "");
		cidade1 = cidade1.replace(",", "");
		bairro1 = bairro1.replace(",", "");
		prof.setCidade(ldao.createIfNotExistCidade(cidade1, uf1));
		prof.setBairro(ldao.createIfNotExistBairro(bairro1, cidade1, uf1));
		ProfissionalSaude pf = profdao.getById(prof.getId());
		prof.setSenha(pf.getSenha());
		prof.setTipoUsuario(pf.getTipoUsuario());
		prof.setRoles(pf.getRoles());
		if (fotoPerfilP == null) {
			prof.setFotoPerfil(pf.getFotoPerfil());
		}else {
			Foto foto = pf.getFotoPerfil();
			foto.setFoto(fotoPerfilP.getBytes());
			fd.update(foto);
			prof.setFotoPerfil(foto);
		}
		profdao.update(prof);
		view.addObject("mensagem", new Mensagem("Especialista atualizado com sucesso!", Tipo.SUCESSO));
		
		return view;
	}
	@RequestMapping(value = "/listar/profsaude", method = RequestMethod.GET)
	public ModelAndView listaProfSaude() {
		ModelAndView model = new ModelAndView("listaprofsau");
		model.addObject("profsau", profdao.lista());
		model.addObject("mensagem", "olá,voce que está lendo");
		return model;
	}

	@RequestMapping(value = "/profsaude/{id}", name = "prof_saude")
	public ModelAndView profSaude(@PathVariable("id") long id) {
		
		ModelAndView modelAndView = new ModelAndView("profsaude");
		modelAndView.addObject("profsau", profdao.getById(id));
		modelAndView.addObject("avaliacoes", avdao.getAllByAvaliatedProfissionalSaude(profdao.getById(id)));
		System.out.println(avdao.getAllByAvaliatedProfissionalSaude(profdao.getById(id)));
		return modelAndView;
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
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
		binder.registerCustomEditor(List.class, "planosParticular", planosCollector);
	}
	@InitBinder
	protected void initBinder2(WebDataBinder binder) throws Exception {
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
