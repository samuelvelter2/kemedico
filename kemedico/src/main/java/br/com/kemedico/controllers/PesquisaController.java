package br.com.kemedico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.kemedico.daos.ClinicaDAO;
import br.com.kemedico.daos.EspecializacaoDAO;
import br.com.kemedico.daos.LocalidadeDAO;
import br.com.kemedico.daos.PagamentoDAO;
import br.com.kemedico.daos.PlanoSaudeDAO;
import br.com.kemedico.daos.ProfSaudeDAO;
import br.com.kemedico.model.Bairro;
import br.com.kemedico.model.Clinica;
import br.com.kemedico.model.Especializacao;
import br.com.kemedico.model.MeioPagamento;
import br.com.kemedico.model.Paciente;
import br.com.kemedico.model.PlanoSaude;
import br.com.kemedico.model.ProfissionalSaude;
import br.com.kemedico.model.Usuario;
import br.com.kemedico.utils.Pesquisa;
import br.com.kemedico.utils.Resultado;

@Controller
public class PesquisaController {
	@Autowired
	ProfSaudeDAO pfdao;
	@Autowired
	LocalidadeDAO ldao;
	@Autowired
	EspecializacaoDAO espdao;
	@Autowired
	PlanoSaudeDAO psdao;
	@Autowired
	ClinicaDAO cdao;
	@Autowired
	PagamentoDAO pdao;

	@RequestMapping(value = "/pesquisa/", name = "pesquisar", method = RequestMethod.GET)
	public ModelAndView pesquisaClinicas(@ModelAttribute("paciente") Paciente paciente,
			@ModelAttribute("usuario") Usuario usuario, @ModelAttribute("profsaude") ProfissionalSaude saude,
			@ModelAttribute("clinica") Clinica clinica, @ModelAttribute("pesquisa") Pesquisa pesquisa) {
		ModelAndView view = new ModelAndView();

		if (pesquisa.getTipoPesquisa().equals("med")) {
			Resultado<ProfissionalSaude> resultado = pfdao.getFiltrados(pesquisa.getPlanos(), pesquisa.getCidade(),
					pesquisa.getBairros(), pesquisa.getMeios(), pesquisa.getEspecialidade(), pesquisa.getOrder(), 20,
					0);
			System.out.println(pesquisa.getBairros());
			pesquisa.setBairros(ldao.getBairrosByIds(pesquisa.getBairros()));
			pesquisa.setMeios(pdao.getAllByIds(pesquisa.getMeios()));
			pesquisa.setPlanos(psdao.getAllByIds(pesquisa.getPlanos()));
			pesquisa.setCidade(ldao.getCidadeById(pesquisa.getCidade().getIdCidade()));
			pesquisa.setEspecialidade(espdao.getById(pesquisa.getEspecialidade().getIdEsp()));
			view.addObject("planos", psdao.lista());
			view.addObject("pesquisa", pesquisa);
			view.addObject("bairros", ldao.getBairrosByCidade(pesquisa.getCidade()));
			view.addObject("resultado", resultado);
			view.addObject("meios", pdao.getAll());
			view.setViewName("pesquisa-e");
			return view;
		}
		if (pesquisa.getTipoPesquisa().equals("cli")) {
			Resultado<Clinica> resultado = cdao.getFiltrados(pesquisa.getPlanos(), pesquisa.getCidade(),
					pesquisa.getBairros(), pesquisa.getMeios(), pesquisa.getEspecialidade(),pesquisa.getOrder(), 20, 0);
			pesquisa.setBairros(ldao.getBairrosByIds(pesquisa.getBairros()));
			pesquisa.setMeios(pdao.getAllByIds(pesquisa.getMeios()));
			pesquisa.setPlanos(psdao.getAllByIds(pesquisa.getPlanos()));
			pesquisa.setCidade(ldao.getCidadeById(pesquisa.getCidade().getIdCidade()));
			pesquisa.setEspecialidade(espdao.getById(pesquisa.getEspecialidade().getIdEsp()));
			view.addObject("planos", psdao.lista());
			view.addObject("meios", pdao.getAll());
			view.addObject("bairros", ldao.getBairrosByCidade(pesquisa.getCidade()));
			view.addObject("pesquisa", pesquisa);
			view.addObject("resultado", resultado);
			System.out.println(resultado.getResultados());
			view.setViewName("pesquisa-c");
			return view;
		}
		return view;

	}

	@RequestMapping(value = "/pesquisa/profsaude/{pg}", name = "pesquisa_prof", method = RequestMethod.POST)
	public ModelAndView pesquisaMedicos(Model model, @PathVariable(name = "pg", required = false) int page,
			@ModelAttribute("pesquisa") Pesquisa pesquisa) {
		System.out.println("medico 2");
		ModelAndView view = new ModelAndView("pesquisa-e");
		return view;

	}

	@RequestMapping(value = "/pesquisa/clinica/", name = "pesquisa_cli", method = RequestMethod.POST)
	public ModelAndView pesquisaClinicas() {
		return new ModelAndView();
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public void handle(Exception e) {
		e.printStackTrace();
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
		binder.registerCustomEditor(List.class, "meios", meiosCollector);
	}
	@InitBinder
	protected void initBinder4(WebDataBinder binder) throws Exception {
		CustomCollectionEditor bairrosCollector = new CustomCollectionEditor(List.class) {
			@Override
			protected Object convertElement(Object element) {
				if (element instanceof String) {
					Long id = Long.parseLong(element.toString());

					Bairro b = new Bairro();
					b.setIdBairro(id);
					return b;
				}
				throw new RuntimeException("Spring says: Não sei o que fazer com esse elemento: " + element);
			}

		};
		binder.registerCustomEditor(List.class, "bairros", bairrosCollector);
	}
	

}
