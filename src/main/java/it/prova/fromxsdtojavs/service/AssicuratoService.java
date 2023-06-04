package it.prova.fromxsdtojavs.service;

import java.util.List;

import it.prova.fromxsdtojavs.model.AssicuratoModel;

public interface AssicuratoService {

	public List<AssicuratoModel> listAllAssicurati();

	public AssicuratoModel caricaSingoloAssicurato(Long id);

	public AssicuratoModel aggiorna(AssicuratoModel assicuratoInstance);

	public AssicuratoModel inserisciNuovo(AssicuratoModel assicuratoInstance);

	public void rimuovi(Long idToRemove);
	
}
