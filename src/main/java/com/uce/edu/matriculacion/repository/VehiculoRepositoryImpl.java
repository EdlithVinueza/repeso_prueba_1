package com.uce.edu.matriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.matriculacion.repository.modelo.Vehiculo;
@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {
	
	private static List<Vehiculo> base = new ArrayList<Vehiculo>();

	@Override
	public Vehiculo seleccionar(String placa) {
		// TODO Auto-generated method stub
		for (Vehiculo vehiculo : base) {
			if (vehiculo.getPlaca().equals(placa));
			Vehiculo tmp = new Vehiculo();
			tmp.setMarca(vehiculo.getMarca());
			tmp.setPlaca(vehiculo.getPlaca());
			tmp.setPrecio(vehiculo.getPrecio());
			tmp.setTipoS(vehiculo.getTipoS());
			return tmp;
		}
		return null;
	}
	
	public Vehiculo selecionarEliminar(String placa) {
		for (Vehiculo vehiculo : base) {
			if (vehiculo.getPlaca().equals(placa));
			return vehiculo;
		}
		return null;
	}

	@Override
	public void insertar(Vehiculo vehiculo) {
		base.add(vehiculo);

	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.eliminar(vehiculo.getPlaca());
		this.insertar(vehiculo);

	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo tmp = this.seleccionar(placa);
		base.remove(tmp);

	}

}
