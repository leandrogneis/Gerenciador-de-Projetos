package br.com.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.biblioteca.filter.ProjetoFilter;
import br.com.biblioteca.models.Projeto;
import br.com.biblioteca.repository.Projetos;

@Service
public class CadastroProjetosService {

	@Autowired
	private Projetos projetos;
	
	public void salvar(Projeto projeto) {
		try {
			projetos.save(projeto);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}

	public void excluir(Long codigo) {
		projetos.delete(codigo);
	}

	public List<Projeto> filtrar(ProjetoFilter filtro) {
		String nome = filtro.getNome() == null ? "%" : filtro.getNome();
		return projetos.findByNomeContaining(nome);
	}
	
}