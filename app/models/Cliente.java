package models;

import io.ebean.Finder;
import io.ebean.Model;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cliente extends Model {

	public Cliente(Integer cliId, String cliCi, String cliNom, String cliApe, String cliDir, String cliTel, Integer cliTipCliId) {
		super();
		CliId = cliId;
		CliCI = cliCi;
		CliNom = cliNom;
		CliApe = cliApe;
		CliDir = cliDir;
		CliTel = cliTel;
		CliTipCliId = cliTipCliId;
	}


	@Id
	public Integer CliId;
	public String CliCI;
	public String CliNom;
	public String CliApe;
	public String CliDir;
	public String CliTel;
	public Integer CliTipCliId;
	
	public Cliente(){
		
	}

	public static Finder<Integer, Cliente> find = new Finder<Integer, Cliente>(Cliente.class);

}
