package br.com.kemedico.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.kemedico.daos.EspecializacaoDAO;
import br.com.kemedico.daos.FotoDAO;
import br.com.kemedico.daos.ProfSaudeDAO;
import br.com.kemedico.model.Especializacao;
import br.com.kemedico.model.Foto;
import br.com.kemedico.model.PlanoSaude;
import br.com.kemedico.model.ProfissionalSaude;

@Controller
public class ProfSaudeController {
	@Autowired
	ProfSaudeDAO profdao;
	@Autowired
	EspecializacaoDAO espdao;
	@Autowired
	FotoDAO fd;
	// Cadastro Profissonal da Saude
		@RequestMapping(value = "/cadastro/profsaude", name = "cad_prof", method = RequestMethod.GET)
		public String cadastroProfSaude(@ModelAttribute("especialidades") ArrayList<Especializacao> esp,
				@ModelAttribute("profsaude") ProfissionalSaude pf) {
			esp.addAll(espdao.getEspecializacoes());
			return "cadastro-e";
		}

		@RequestMapping(value = "/cadastro/profsaude", name = "cad_prof_bd", method = RequestMethod.POST)
		public String cadastroProfSaudebd(@ModelAttribute("prof_saude")ProfissionalSaude pf,MultipartFile fotoPerfilp) throws IOException {		
			System.out.println(pf.toString());
			Foto foto = Foto.getFoto(fotoPerfilp.getBytes());
			fd.salva(foto);
			pf.setFotoPerfil(foto);
			profdao.salva(pf);
			return "index";
		}
		@RequestMapping(value = "/listar/profsaude", method = RequestMethod.GET)
		public ModelAndView listaProfSaude() {
			ModelAndView model  = new ModelAndView("listaprofsau");
			model.addObject("profsau", profdao.lista());
			model.addObject("mensagem","olá,voce que está lendo");
			return model;
		}
		@RequestMapping(value = "/profsaude/{id}",name = "prof_saude")
		public ModelAndView profSaude(@PathVariable("id") String id) {
			ObjectId id_prof = new ObjectId(id);		
			ModelAndView modelAndView = new ModelAndView("profsaude");
			modelAndView.addObject("profsau",profdao.getById(id_prof));
			return modelAndView;
		}
		@InitBinder
	    protected void initBinder(WebDataBinder binder) throws Exception {
			CustomCollectionEditor planosCollector = new CustomCollectionEditor(List.class) {
	            @Override
	            protected Object convertElement(Object element) {
	                if (element instanceof String) {
	                   ObjectId id = new ObjectId(element.toString());

	                   PlanoSaude ps = new PlanoSaude();
	                    ps.setId(id);
	                    return ps;
	                }
	                throw new RuntimeException("Spring says: Não sei o que fazer com esse elemento: " + element);            }
	            
	        };
	        binder.registerCustomEditor(List.class, "planos", planosCollector);
		}
}
