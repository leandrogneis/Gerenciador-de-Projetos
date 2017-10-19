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

import br.com.biblioteca.filter.PessoaFilter;
import br.com.biblioteca.models.Pessoa;
import br.com.biblioteca.service.CadastroPessoaService;

@Controller
@RequestMapping("/pessoas")
@Transactional
public class PessoasController {
		
		private static final String CADASTRO_VIEW = "pessoas/novo";
		
		@Autowired
		private CadastroPessoaService cadastroPessoaService;

		@RequestMapping("/novo")
		public ModelAndView novo() {
			ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
			mv.addObject(new Pessoa());
			return mv;
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public String salvar(@Validated Pessoa pessoa, Errors errors, RedirectAttributes attributes) {
			if (errors.hasErrors()) {
				return CADASTRO_VIEW;
			}
			
			try {
				cadastroPessoaService.salvar(pessoa);
				attributes.addFlashAttribute("mensagem", "Pessoa salva com sucesso!");
				return "redirect:/pessoas/novo";
			} catch (IllegalArgumentException e) {
				errors.rejectValue("dataVencimento", null, e.getMessage());
				return CADASTRO_VIEW;
			}
		}
		
		@RequestMapping(value="/",method=RequestMethod.GET)
		public ModelAndView pesquisar(@ModelAttribute("filtro") PessoaFilter filtro) {
			List<Pessoa> todasPessoas = cadastroPessoaService.filtrar(filtro);
			
			ModelAndView mv = new ModelAndView("pessoas/lista");
			mv.addObject("pessoas", todasPessoas);
			return mv;
		}
		
		@RequestMapping("{codigo}")
		public ModelAndView edicao(@PathVariable("codigo") Pessoa pessoa) {
			ModelAndView mv = new ModelAndView(CADASTRO_VIEW); 
			mv.addObject(pessoa);
			return mv;
		}
		
		@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
		public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
			cadastroPessoaService.excluir(codigo);
			
			attributes.addFlashAttribute("mensagem", "Pessoa excluída com sucesso!");
			return "redirect:/pessoas";
		}
		
	}