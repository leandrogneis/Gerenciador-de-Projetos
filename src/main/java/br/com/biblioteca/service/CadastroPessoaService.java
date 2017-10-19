package br.com.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.biblioteca.filter.PessoaFilter;
import br.com.biblioteca.models.Pessoa;
import br.com.biblioteca.repository.Pessoas;
@Service
public class CadastroPessoaService {

	@Autowired
	private Pessoas pessoas;
	
	public void salvar(Pessoa pessoa) {
		try {
			pessoas.save(pessoa);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}

	public void excluir(Long codigo) {
		pessoas.delete(codigo);
	}

	public List<Pessoa> filtrar(PessoaFilter filtro) {
		String nome = filtro.getNome() == null ? "%" : filtro.getNome();
		return pessoas.findByNomeContaining(nome);
	}
	
}