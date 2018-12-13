package models;

import io.ebean.Finder;
import io.ebean.Model;
//import java.util.Date;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cliente extends Model {

	


	@Id
	public Integer CliId;
	public String CliCI;
	public String CliNom;
	public String CliApe;
	public String CliDir;
	public String CliTel;
	public Integer CliTipCliId;
	public Integer CliCantHijos;
	public Date CliFechNac;
	public String Observacion;

	
	public Cliente(Integer cliId, String cliCI, String cliNom, String cliApe, String cliDir, String cliTel,
			Integer cliTipCliId, Integer cliCantHijos, Date cliFechNac, String observacion) {
		super();
		CliId = cliId;
		CliCI = cliCI;
		CliNom = cliNom;
		CliApe = cliApe;
		CliDir = cliDir;
		CliTel = cliTel;
		CliTipCliId = cliTipCliId;
		CliCantHijos = cliCantHijos;
		CliFechNac = cliFechNac;
		Observacion = observacion;
	}

	public Cliente(){
		
	}

	public static Finder<Integer, Cliente> find = new Finder<Integer, Cliente>(Cliente.class);

}
