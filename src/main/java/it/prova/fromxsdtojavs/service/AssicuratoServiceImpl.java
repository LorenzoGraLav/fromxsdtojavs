package it.prova.fromxsdtojavs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.prova.fromxsdtojavs.model.AssicuratoModel;
import it.prova.fromxsdtojavs.repository.AssicuratoRepository;

public class AssicuratoServiceImpl implements AssicuratoService{
	
	@Autowired
	private AssicuratoRepository repository;


	@Override
	public List<AssicuratoModel> listAllAssicurati() {
		return (List<AssicuratoModel>) repository.findAll();
	}

	@Override
	public AssicuratoModel caricaSingoloAssicurato(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public AssicuratoModel aggiorna(AssicuratoModel assicuratoInstance) {
		return repository.save(assicuratoInstance);
	}

	@Override
	public AssicuratoModel inserisciNuovo(AssicuratoModel assicuratoInstance) {
		return repository.save(assicuratoInstance);

	}

	@Override
	public void rimuovi(Long idToRemove) {
		repository.deleteById(idToRemove);
	}

}
