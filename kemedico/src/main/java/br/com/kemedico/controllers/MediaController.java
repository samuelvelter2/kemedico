package br.com.kemedico.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.kemedico.daos.ProfSaudeDAO;
import br.com.kemedico.model.ProfissionalSaude;
@Controller
public class MediaController {
	@Autowired
	ProfSaudeDAO saudeDAO;
	@RequestMapping(value  = "/media/imagem/profsaude/{id}", produces = {"image/*"},method = RequestMethod.GET, name = "foto_prof")
	public @ResponseBody byte[] getImagem(@PathVariable(value = "id") String id) {
		if (id.toString() == "0") {
			throw new RuntimeException("o id precisa ser informado");
		}
		System.out.println(id.toString());
		ObjectId idprof = new ObjectId(id);
		ProfissionalSaude prof = saudeDAO.getById(idprof);
		System.out.println(prof.getFotoPerfil().toString());
		return prof.getFotoPerfil().getFoto();
	}
}
