package com.uce.edu.matriculacion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.matriculacion.repository.IMatriculaRepository;
import com.uce.edu.matriculacion.repository.IPropietarioRepository;
import com.uce.edu.matriculacion.repository.IVehiculoRepository;
import com.uce.edu.matriculacion.repository.modelo.Matricula;
import com.uce.edu.matriculacion.repository.modelo.Propietario;
import com.uce.edu.matriculacion.repository.modelo.Vehiculo;
@Service
public class MatriculaServiceImpl implements IMatriculaService {
	
	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	

	@Override
	public Matricula buscar(String cedula, String placa) {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionar(cedula, placa);
	}

	@Override
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.insertar(matricula);

	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.actualizar(matricula);

	}

	@Override
	public void borrar(String cedula, String placa) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.eliminar(cedula, placa);

	}

	@Override
	public void generarMatricula(Propietario propietario, Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		if (this.buscar(propietario.getCedula(), vehiculo.getPlaca())==null) {
			
			BigDecimal valorFina= null;
			//Calculo del valor de Matricula
			if(vehiculo.getTipoS().toLowerCase().equals("pesado")) {
				BigDecimal valorPesado = new BigDecimal(0.15);
				System.out.println("Valor Pesado: "+ valorPesado);
				valorFina= vehiculo.getPrecio().multiply(valorPesado);
				System.out.println("valor Final:"+valorFina);
			}
			else if (vehiculo.getTipoS().toLowerCase().equals("liviano")){
				BigDecimal valorLiviano = new BigDecimal(0.10);
				System.out.println("Valor liviano: "+ valorLiviano);
				valorFina= vehiculo.getPrecio().multiply(valorLiviano);
				System.out.println("valor Final:"+valorFina);
			}
			else {
				System.out.println("No entra en ningun tipo de Vehiculo");
			}
			
			BigDecimal valorMaximo = new BigDecimal(2000);
			
			if (valorFina.compareTo(valorMaximo)==1) {
				BigDecimal descuento = valorFina.multiply(new BigDecimal(0.07));
				System.out.println("Descuento: "+ descuento);
				valorFina = valorFina.subtract(descuento);
			}
			
			//Crear Matricula
			Matricula tmp = new Matricula();
			tmp.setFechaMatricula(LocalDateTime.now());
			tmp.setPropietario(propietario);
			tmp.setValorMatricula(valorFina);
			tmp.setVehiculo(vehiculo);
			
			this.guardar(tmp);
			System.out.println("Se guardo: "+ tmp);
			
			
		}
		else {
			System.out.println("Este Vehiculo ya esta registrado en el sistema ");
		}
		

	}

}
