package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.matriculacion.repository.modelo.Propietario;
import com.uce.edu.matriculacion.repository.modelo.Vehiculo;
import com.uce.edu.matriculacion.service.IMatriculaService;
import com.uce.edu.matriculacion.service.IPropietarioService;
import com.uce.edu.matriculacion.service.IVehiculoService;


@SpringBootApplication
public class RepesoPrueba1Application implements CommandLineRunner{
	
	@Autowired
	private IMatriculaService iMatriculaService;
	@Autowired
	private IPropietarioService iPropietarioService;
	@Autowired
	private IVehiculoService iVehiculoService;

	public static void main(String[] args) {
		SpringApplication.run(RepesoPrueba1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Vehiculo vehiculo = new Vehiculo();
		
		vehiculo.setMarca("Marca 1");
		vehiculo.setPlaca("ABC-123");
		vehiculo.setPrecio(new BigDecimal(2000));
		vehiculo.setTipoS("liviano");
		System.out.println(vehiculo);
		this.iVehiculoService.guardar(vehiculo);
		
		System.out.println("Nuevos Atributos ");
		vehiculo.setMarca("Marca 2");
		vehiculo.setPrecio(new BigDecimal(1500));
		System.out.println(vehiculo);
		this.iVehiculoService.actualizar(vehiculo);
		
		
		Propietario propietario = new Propietario();
		propietario.setApellido("Perez");
		propietario.setCedula("1750697898");
		propietario.setFechaNacimiento(LocalDateTime.of(1999, 05, 12, 3, 5));
		propietario.setNombre("UwU");
		
		this.iPropietarioService.guardar(propietario);
		
		this.iMatriculaService.generarMatricula(propietario, vehiculo);
		this.iMatriculaService.generarMatricula(propietario, vehiculo);
		
	}
	

}
