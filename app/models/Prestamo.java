package models;

import io.ebean.Finder;
import io.ebean.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prestamo extends Model{
	
	@Id
	public Integer PresId;
	public String PresNro;
	public Date PresFec;
	public Cliente PresCli;
	public Integer TotalSolicitado;
	public Integer TotalPrestamo;
	public Entidad PresEnt;
	public Integer CantCuotas;
	
	public static Finder<Integer, Prestamo> find = new Finder<Integer, Prestamo>(Prestamo.class);

	public Prestamo(Integer presId, String presNro, Date presFec, Cliente presCli, Integer totalSolicitado,
			Integer totalPrestamo, Entidad presEnt, Integer cantCuotas) {
		super();
		PresId = presId;
		PresNro = presNro;
		PresFec = presFec;
		PresCli = presCli;
		TotalSolicitado = totalSolicitado;
		TotalPrestamo = totalPrestamo;
		PresEnt = presEnt;
		CantCuotas = cantCuotas;
	}

	
}
