package models;

import io.ebean.Finder;
import io.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario extends Model {

	@Id
	public Integer Usrid;
	public String UsrAlias;
	public String UsrNom;
	public String UsrPass;
	
	
	public Usuario() {
		super();
	}


	public Usuario(Integer usrid, String usrAlias, String usrNom, String usrPass) {
		super();
		Usrid = usrid;
		UsrAlias = usrAlias;
		UsrNom = usrNom;
		UsrPass = usrPass;
	}


	public static Finder<Integer, Usuario> find = new Finder<Integer, Usuario>(Usuario.class);
}
