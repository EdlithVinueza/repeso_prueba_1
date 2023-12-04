package com.uce.edu.matriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.matriculacion.repository.modelo.Matricula;

@Repository 
public class MatriculaRepositoryImpl implements IMatriculaRepository{
	
	private static List<Matricula> base = new ArrayList<Matricula>();

	@Override
	public Matricula seleccionar(String cedula, String placa) {
		// TODO Auto-generated method stub
		for (Matricula matricula : base) {
			if (matricula.getPropietario().getCedula().equals(cedula) && matricula.getVehiculo().getPlaca().equals(placa)) {
				Matricula tmp = new Matricula();
				tmp.setFechaMatricula(matricula.getFechaMatricula());
				tmp.setPropietario(matricula.getPropietario());
				tmp.setValorMatricula(matricula.getValorMatricula());
				tmp.setVehiculo(matricula.getVehiculo());
				return tmp;
			}
		}
		return null;
	}
	
	public Matricula seleccionarEliMatricula(String cedula, String placa) {
		// TODO Auto-generated method stub
		for (Matricula matricula : base) {
			if (matricula.getPropietario().getCedula().equals(cedula) && matricula.getVehiculo().getPlaca().equals(placa)) {
	
				return matricula;
			}
		}
		return null;
	}

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		base.add(matricula);
		
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.eliminar(matricula.getPropietario().getCedula(), matricula.getVehiculo().getPlaca());
		this.insertar(matricula);
		
	}

	@Override
	public void eliminar(String cedula, String placa) {
		// TODO Auto-generated method stub
		Matricula tmp = this.seleccionar(cedula, placa);
		base.remove(tmp);
		
	}

}
