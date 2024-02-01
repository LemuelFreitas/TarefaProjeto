package com.TarefaProjeto.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Tarefa")
public class TarefasEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull

	private String nome;
	
	@NotNull

	private String dataFinalExecucao;
	
	@NotNull

	private String descricaoTarefa;
	
	@NotNull

	private String statusTarefa;
	
}