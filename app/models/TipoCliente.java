package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoCliente extends Model{

	@Id
	public Integer TipCliId;
	public String Descripcion;
	public Integer CantMaxCuota;
	
	public static Finder<Integer, TipoCliente> find = new Finder<Integer, TipoCliente>(TipoCliente.class);

	public TipoCliente(Integer tipCliId, String descripcion, Integer cantMaxCuota) {
		super();
		TipCliId = tipCliId;
		Descripcion = descripcion;
		CantMaxCuota = cantMaxCuota;
	}
	
	
}
