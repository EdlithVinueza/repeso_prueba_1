package com.uce.edu.matriculacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.matriculacion.repository.IPropietarioRepository;
import com.uce.edu.matriculacion.repository.modelo.Propietario;
@Service
public class PropietarioServiceImpl implements IPropietarioService {
	
	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Override
	public Propietario buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.iPropietarioRepository.seleccionar(cedula);
	}

	@Override
	public void guardar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.insertar(propietario);

	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.actualizar(propietario);

	}

	@Override
	public void borrar(String cedula) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.eliminar(cedula);

	}

}
