package br.com.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.models.Projeto;

public interface Projetos extends JpaRepository<Projeto, Long>{

	public List<Projeto> findByNomeContaining(String nome);
}
