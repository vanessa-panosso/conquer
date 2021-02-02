package br.com.conquer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.conquer.domain.Despesa;
import br.com.conquer.repository.DespesaRepository;

/**
 * 
 * @author Vanessa Panosso
 * 
 */
@Service
public class DespesaService {

	@Autowired
	private DespesaRepository repository;
	
	public Despesa save(final Despesa expense) {
		return repository.save(expense);
	}
	
	public Despesa findById(final Integer id) {
		return repository.getOne(id);
	}
	
	public List<Despesa> findAll() {
		return repository.findAll();
	}
}
