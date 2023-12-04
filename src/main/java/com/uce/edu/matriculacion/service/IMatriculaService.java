package com.uce.edu.matriculacion.service;

import com.uce.edu.matriculacion.repository.modelo.Matricula;
import com.uce.edu.matriculacion.repository.modelo.Propietario;
import com.uce.edu.matriculacion.repository.modelo.Vehiculo;

public interface IMatriculaService {
	
	public Matricula buscar(String cedula, String placa);
	public void guardar (Matricula matricula);
	public void actualizar (Matricula matricula);
	public void borrar (String cedula, String placa);
	public void generarMatricula(Propietario propietario, Vehiculo vehiculo);
	

}
