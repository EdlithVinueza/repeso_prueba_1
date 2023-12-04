package com.uce.edu.matriculacion.service;

import com.uce.edu.matriculacion.repository.modelo.Propietario;

public interface IPropietarioService {
	
	public Propietario buscar(String cedula);
	public void guardar (Propietario propietario);
	public void actualizar (Propietario propietario);
	public void borrar (String cedula);

}
