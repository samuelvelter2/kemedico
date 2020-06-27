package br.com.kemedico.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.kemedico.daos.AvaliacaoDAO;
import br.com.kemedico.daos.ClinicaDAO;
import br.com.kemedico.daos.PacienteDAO;
import br.com.kemedico.daos.ProfSaudeDAO;
import br.com.kemedico.daos.UsuarioDAO;
import br.com.kemedico.enums.Tipo;
import br.com.kemedico.model.Avaliacao;
import br.com.kemedico.model.Clinica;
import br.com.kemedico.model.ProfissionalSaude;
import br.com.kemedico.model.Usuario;
import br.com.kemedico.utils.AvaliacaoMedia;
import br.com.kemedico.utils.Mensagem;

@Controller
public class AvaliacaoController {
	@Autowired
	AvaliacaoDAO avdao;
	@Autowired
	UsuarioDAO udao;
	@Autowired
	PacienteDAO pdao;
	@Autowired
	ProfSaudeDAO profdao;
	@Autowired
	ClinicaDAO cldao;
	@RequestMapping(value = "/avalia/profsaude/", method = RequestMethod.POST,name = "av_prof")
	public ModelAndView avaliaProfSaude(Avaliacao av,Principal p) {
		ModelAndView view = new ModelAndView();
		Usuario u = (Usuario) udao.loadUserByUsername(p.getName());
		av.setPaciente(pdao.getById(u.getId()));
		avdao.salva(av);		
		ProfissionalSaude prof = profdao.getById(av.getProfSaude().getId());
		prof.setMediaAvaliada(AvaliacaoMedia.getMediaAvaliada(avdao.getAllByAvaliatedProfissionalSaude(prof)));
		profdao.update(prof);
		view.setViewName("forward:/profsaude/"+prof.getId());
		view.addObject("mensagem", new Mensagem("avaliação salva com sucesso!", Tipo.SUCESSO));		
		return view;		
	}
	@RequestMapping(value = "/avalia/clinica/", method = RequestMethod.POST,name = "av_cli")
	public ModelAndView avaliaClinica(Avaliacao av,Principal p) {
		ModelAndView view = new ModelAndView();
		Usuario u = (Usuario) udao.loadUserByUsername(p.getName());
		av.setPaciente(pdao.getById(u.getId()));
		avdao.salva(av);
		Clinica cli = cldao.getById(av.getClinica().getId());
		cli.setMediaAvaliada(AvaliacaoMedia.getMediaAvaliada(avdao.getAllByAvaliatedClinica(cli)));
		cldao.update(cli);
		view.setViewName("forward:/clinica/"+cli.getId());
		view.addObject("mensagem", new Mensagem("avaliação salva com sucesso!", Tipo.SUCESSO));		
		return view;
	}
	

}
