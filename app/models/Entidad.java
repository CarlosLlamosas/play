package models;

import io.ebean.Finder;
import io.ebean.Model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Entidad extends Model {
	
	@Id
    public Integer entId;
	public String entNom;
	public String entRuc;
	public String entDir;
	public String entTel;
	public String entCont;
	public Integer cant_empleados;
	public Date fecha_creacion;
	public String lema;
	
	
	public Entidad(Integer entId, String entNom, String entRuc, String entDir, String entTel, String entCont,
			Integer cant_empleados, Date fecha_creacion, String lema) {
		super();
		this.entId = entId;
		this.entNom = entNom;
		this.entRuc = entRuc;
		this.entDir = entDir;
		this.entTel = entTel;
		this.entCont = entCont;
		this.cant_empleados = cant_empleados;
		this.fecha_creacion = fecha_creacion;
		this.lema = lema;
	}

  

	public Entidad(){
    	
    }
    
  public static Finder<Integer,Entidad> find = new Finder<Integer, Entidad>(Entidad.class);

}