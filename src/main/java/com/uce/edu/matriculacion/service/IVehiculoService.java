package com.uce.edu.matriculacion.service;

import com.uce.edu.matriculacion.repository.modelo.Vehiculo;

public interface IVehiculoService {
	public Vehiculo buscar(String placa);
	public void guardar (Vehiculo vehiculo);
	public void actualizar (Vehiculo vehiculo);
	public void borrar (String placa);

}
