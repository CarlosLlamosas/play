package controllers;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.Cliente;
import models.Entidad;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class EntidadController extends Controller {

	public Result lista() {
		List<Entidad> ent = Entidad.find.all();
		JsonNode jj = Json.toJson(ent);

		return ok(jj);
	}

	public Result save() {
		JsonNode jj = request().body().asJson();
		Entidad ent = Json.fromJson(jj, Entidad.class);
		ent.save();

		return ok(ent.entNom + " Fue Agregado");
}
	

	public Result delete(Integer id) {
		Entidad ent = Entidad.find.byId(id);
		if (ent == null) {
			return notFound("Entidad No existe");
		}
		ent.delete();
		return ok(ent.entNom + " Fue Eliminado");
	}

	public Result update() {

		JsonNode jj = request().body().asJson();
		Entidad ent = Json.fromJson(jj, Entidad.class);
		Entidad oldent = Entidad.find.byId(ent.entId);

		if (oldent != null) {
			oldent= ent;
			oldent.update();
			
			return ok(ent.entNom + " Fue Modificado");
		}
		return null;
	}

	public Result edit(Integer id) {
		// System.out.println(id);

		Cliente cli = Cliente.find.byId(id);
		if (cli == null) {
			return notFound("Cliente no Existe");
		}

		JsonNode jj = Json.toJson(cli);

		return ok(jj);
	}

	public Result show(Integer id) {
		Cliente cli = Cliente.find.byId(id);
		if (cli == null) {
			return notFound("Cliente no existe");
		}
		JsonNode jj = Json.toJson(cli);
		return ok(jj);
	}
}
