package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
@Entity
public class TipoCliente extends Model{

	@Id
	public Integer TipCliId;
	public String Descripcion;
	public Integer CantMaxCuota;
	public String Observacion;
	public Integer Codigo;
	public Date Fecha_Carga;
	
	public static Finder<Integer, TipoCliente> find = new Finder<Integer, TipoCliente>(TipoCliente.class);

	public TipoCliente(Integer tipCliId, String descripcion, Integer cantMaxCuota, String observacion, Integer codigo, Date fecha_carga) {
		super();
		TipCliId = tipCliId;
		Descripcion = descripcion;
		CantMaxCuota = cantMaxCuota;
		Observacion= observacion;
		Codigo= codigo;
		Fecha_Carga= fecha_carga;
		
	}

	public TipoCliente() {
		super();
	}
	
	
}
