package br.com.biblioteca.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.biblioteca.filter.ProjetoFilter;
import br.com.biblioteca.models.Projeto;
import br.com.biblioteca.service.CadastroProjetosService;

@Controller
@RequestMapping("/projetos")
@Transactional
public class ProjetosController {
	
	@Autowired
	private CadastroProjetosService cadastroProjetosService;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("projetos/novo");
		mv.addObject(new Projeto());
		return mv;
	}
	
	@RequestMapping("/")
	public String lista(){
		return "projetos/lista";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Projeto pessoa, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return "novo";
		}

		try {
			cadastroProjetosService.salvar(pessoa);
			attributes.addFlashAttribute("mensagem", "Projeto salva com sucesso!");
			return "redirect:/projetos/lista";
		} catch (IllegalArgumentException e) {
			errors.rejectValue("dataVencimento", null, e.getMessage());
			return "novo";
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView pesquisar(@ModelAttribute("filtro") ProjetoFilter filtro) {
		List<Projeto> todosProjetos = cadastroProjetosService.filtrar(filtro);

		ModelAndView mv = new ModelAndView("projetos/lista");
		mv.addObject("projetos", todosProjetos);
		return mv;
	}

	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Projeto projeto) {
		ModelAndView mv = new ModelAndView("novo");
		mv.addObject(projeto);
		return mv;
	}

	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		cadastroProjetosService.excluir(codigo);

		attributes.addFlashAttribute("mensagem", "Projeto excluída com sucesso!");
		return "redirect:/projetos";
	}

}
