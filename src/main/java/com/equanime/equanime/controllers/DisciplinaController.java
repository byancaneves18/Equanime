package com.equanime.equanime.controllers;


import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.equanime.equanime.models.Disciplina;
import com.equanime.equanime.models.Usuario;
import com.equanime.equanime.repository.DisciplinaRepository;
import com.equanime.equanime.repository.UsuarioRepository;

@RestController
public class DisciplinaController {
	
	@Autowired
	DisciplinaRepository repository;
	UsuarioRepository userRepository;
	//Usuario userLocal = new Usuario();
	
	@RequestMapping("/cadastrarDisciplina")
	
	public String form() {
		return "usuario/formUsuario";
	}
	
	@RequestMapping(value="/disciplina/teste" ,method = RequestMethod.GET)
	@ResponseBody
	public String process() {
		return "Teste";
	}
	
	@RequestMapping(value="/disciplina/listar", method = RequestMethod.GET)
	@ResponseBody
	public  ArrayList listar() {
		ArrayList lista;
		lista = (ArrayList) repository.findAll(); 
		
		return lista;
	}
	
	@RequestMapping(value="/disciplina/salvar" ,method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestBody Disciplina disciplina) {
		try {
			repository.save(disciplina);			
		}catch (Exception e) {
			return e.getMessage();			
		}
		return "Funcionou";
	}
	
	@RequestMapping(value="/disciplina/juntar" ,method = RequestMethod.POST)
	@ResponseBody
	public String montarDisciplinaProfessor(@RequestBody String value) throws ParseException {
		
		JSONParser parser = new JSONParser(); 
		JSONObject json = (JSONObject) parser.parse(value);
		JSONObject jUser = (JSONObject) json.get("user");
		JSONObject jDis = (JSONObject) json.get("disciplina");
		Integer id_usuario, id_disciplina, periodo;
		periodo = Integer.parseInt(json.get("periodo").toString());
		
		Usuario user = new Usuario();
		user.setId(Integer.parseInt(jUser.get("id").toString()));
		id_usuario = user.getId();
		
		Disciplina disc = new Disciplina();
		disc.setId(Integer.parseInt(jDis.get("id").toString()));
		id_disciplina = disc.getId();
		
		System.out.println(id_disciplina);
		System.out.println(id_usuario);
		System.out.println(periodo);
		
		try {
			repository.criarProfessorDisciplina(id_disciplina, id_usuario, periodo);
			return "Certo";
		}catch (Exception e) {
			return e.getMessage();						
		}
	}
}