package controllers;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.Usuario;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class UsuarioController extends Controller{
	public Result lista() {
		List<Usuario> usu = Usuario.find.all();
		JsonNode jj = Json.toJson(usu);
		return ok(jj);
	}

	public Result save() {
		JsonNode jj = request().body().asJson();
		Usuario usu = Json.fromJson(jj, Usuario.class);
		usu.save();

		return ok(usu.UsrAlias + " Fue Agregado");
	}

	public Result delete(Integer id) {
		Usuario usu = Usuario.find.byId(id);
		if (usu == null) {
			return notFound("Usuario No existe");
		}
		usu.delete();
		return ok(usu.UsrAlias + " Fue Eliminado");
	}

	public Result update() {

		JsonNode jj = request().body().asJson();
		Usuario usu = Json.fromJson(jj, Usuario.class);
		Usuario oldusu = Usuario.find.byId(usu.Usrid);

		if (oldusu != null) {
			oldusu=usu;
			oldusu.update();
			
			return ok(oldusu.UsrAlias + " Fue Modificado");
		}
		return null;
	}

	public Result edit(Integer id) {
		// System.out.println(id);

		Usuario usu = Usuario.find.byId(id);
		if (usu == null) {
			return notFound("Usuario no Existe");
		}

		JsonNode jj = Json.toJson(usu);

		return ok(jj);
	}

	public Result show(Integer id) {
		Usuario usu = Usuario.find.byId(id);
		if (usu == null) {
			return notFound("Cliente no existe");
		}
		JsonNode jj = Json.toJson(usu);
		return ok(jj);
	}
}
