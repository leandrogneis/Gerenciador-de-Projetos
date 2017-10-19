package br.com.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.models.Pessoa;

public interface Pessoas extends JpaRepository<Pessoa, Long>{

	public List<Pessoa> findByNomeContaining(String nome);
}
