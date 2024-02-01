package com.TarefaProjeto.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TarefaProjeto.Repository.TarefaRepository;
import com.TarefaProjeto.Entities.TarefasEntities;
@Service
public class TarefaService {

	private final TarefaRepository tarefaRepository;

	@Autowired
	public TarefaService(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}
	public List<TarefasEntities> buscaTodosTarefa(){
		return tarefaRepository.findAll();
	}
	public TarefasEntities buscaTarefaId(Long id) {
		Optional <TarefasEntities> Tarefa = tarefaRepository.findById(id);
		return Tarefa.orElse(null);
	}
	public TarefasEntities salvaTarefa(TarefasEntities Tarefa) {
		return tarefaRepository.save(Tarefa);
	}
	public TarefasEntities alterarTarefa(Long id, TarefasEntities alterarC) {
		Optional <TarefasEntities> existeTarefa = tarefaRepository.findById(id);
		if(existeTarefa.isPresent()) {
			alterarC.setId(id);
			return tarefaRepository.save(alterarC);
		}
		return null;
	}
	public boolean apagarTarefa(Long id) {
		Optional <TarefasEntities> existeTarefa = tarefaRepository.findById(id);
		if (existeTarefa.isPresent()) {
			tarefaRepository.deleteById(id);
			return true;
		}
		return false;
		}
	
	}
