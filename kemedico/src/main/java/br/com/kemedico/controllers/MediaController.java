package br.com.kemedico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.kemedico.daos.FotoDAO;
@Controller
public class MediaController {
	@Autowired
	FotoDAO fdao;
	@RequestMapping(value  = "/media/imagem/{id}", produces = {"image/*"},method = RequestMethod.GET, name = "foto")
	public @ResponseBody byte[] getImagem(@PathVariable(value = "id") long id) {		
		System.out.println(id);
		
		return fdao.getById(id).getFoto();
	}
}
