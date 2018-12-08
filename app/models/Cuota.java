package models;

import io.ebean.Finder;
import io.ebean.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cuota extends Model{
	
	@Id
	public Integer CuoId;
	public Integer CuoEnt;
	public Integer CuoNroComp;
	public Integer CuoCli;
	public Date CuoFec;
	public Date CuoFecVen;
	public Integer CuoNroCuo;
	public Integer CuoCanCuo;
	public Integer CuoImp;
	public Integer CuoPres;
	
	public static Finder<Integer, Cuota> find = new Finder<Integer, Cuota>(Cuota.class);

	public Cuota() {
		super();
	}
	
	public Cuota(Integer cuoId, Integer cuoEnt, Integer cuoNroComp, Integer cuoCli, Date cuoFec, Date cuoFecVen,
			Integer cuoNroCuo, Integer cuoCanCuo, Integer cuoImp, Integer cuoPres) {
		super();
		CuoId = cuoId;
		CuoEnt = cuoEnt;
		CuoNroComp = cuoNroComp;
		CuoCli = cuoCli;
		CuoFec = cuoFec;
		CuoFecVen = cuoFecVen;
		CuoNroCuo = cuoNroCuo;
		CuoCanCuo = cuoCanCuo;
		CuoImp = cuoImp;
		CuoPres = cuoPres;
	}


}
