package com.uce.edu.matriculacion.repository;

import com.uce.edu.matriculacion.repository.modelo.Matricula;


public interface IMatriculaRepository {
	
	//CRUD --> Selecionar, insertar, actualizar, eliminar 
 
	public Matricula seleccionar(String cedula, String placa);
	public void insertar (Matricula matricula);
	public void actualizar (Matricula matricula);
	public void eliminar (String cedula, String placa);
	
	

}
