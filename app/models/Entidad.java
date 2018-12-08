package models;

import io.ebean.Finder;
import io.ebean.Model;
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
	
	

    public Entidad(Integer entId, String entNom, String entRuc, String entDir, String entTel, String entCont) {
		super();
		this.entId = entId;
		this.entNom = entNom;
		this.entRuc = entRuc;
		this.entDir = entDir;
		this.entTel = entTel;
		this.entCont = entCont;
	}

	public Entidad(){
    	
    }
    
  public static Finder<Integer,Entidad> find = new Finder<Integer, Entidad>(Entidad.class);

}