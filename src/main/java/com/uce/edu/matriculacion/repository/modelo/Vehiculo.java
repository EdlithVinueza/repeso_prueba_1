package com.uce.edu.matriculacion.repository.modelo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Vehiculo {
	private String marca;
	private String placa;
	private String tipoS;
	private BigDecimal precio;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoS() {
		return tipoS;
	}

	public void setTipoS(String tipoS) {
		this.tipoS = tipoS;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", placa=" + placa + ", tipoS=" + tipoS + ", precio=" + precio + "]";
	}

}
