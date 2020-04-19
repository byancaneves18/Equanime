package com.equanime.equanime.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="disciplina_professor")
public class DisciplinaProfessor implements Serializable {

	//private static final long serialVersionUID = -3009157732242241606L;
	//Integer id_usuariofk;
	//Integer id_disciplinafk;
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name= "nome")
	private String nome;	
	
	@Column(name= "periodo")
	private Integer periodo;
	
	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

}
