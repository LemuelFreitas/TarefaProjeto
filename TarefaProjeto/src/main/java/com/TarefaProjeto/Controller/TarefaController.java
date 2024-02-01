package com.TarefaProjeto.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TarefaProjeto.Service.TarefaService;
import com.TarefaProjeto.Entities.TarefasEntities;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	private final TarefaService tarefaService;

	@Autowired
	public TarefaController(TarefaService tarefaservice) {
		this.tarefaService = tarefaservice;
	}

	@GetMapping("/{id}")
	public ResponseEntity<TarefasEntities> buscaTarefaControlId(@PathVariable Long id) {
		TarefasEntities tarefa = tarefaService.buscaTarefaId(id);
		if (tarefa != null) {
			return ResponseEntity.ok(tarefa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<TarefasEntities>> buscaTodosTarefaControl() {
		List<TarefasEntities> Tarefa = tarefaService.buscaTodosTarefa();
		return ResponseEntity.ok(Tarefa);
	}

	@PostMapping
	public ResponseEntity<TarefasEntities> salvaTarefaControl(@RequestBody TarefasEntities tarefa) {
		TarefasEntities salvaTarefa = tarefaService.salvaTarefa(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTarefa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TarefasEntities> alteraTarefaControl(@PathVariable Long id, @RequestBody @Valid TarefasEntities Tarefa) {
		TarefasEntities alteraTarefa = tarefaService.alterarTarefa(id, Tarefa);
		if (alteraTarefa != null) {
			return ResponseEntity.ok(Tarefa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<TarefasEntities> apagaTarefaControl(@PathVariable Long id) {
		boolean apagar = tarefaService.apagarTarefa(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}