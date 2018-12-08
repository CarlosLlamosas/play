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

	public Result save(String json) {
		JsonNode jj = Json.toJson(json);
		Cliente cli = Json.fromJson(jj, Cliente.class);
		cli.save();

		return ok(cli.CliNom + " Fue Agregado");
	}

	public Result delete(Integer id) {
		Cliente cli = Cliente.find.byId(id);
		if (cli == null) {
			return notFound("Cliente No existe");
		}
		cli.delete();
		return ok(cli.CliNom + " Fue Eliminado");
	}

	public Result update(String json) {

		JsonNode jj = Json.toJson(json);
		Cliente cli = Json.fromJson(jj, Cliente.class);
		Cliente oldCli = Cliente.find.byId(cli.CliId);

		if (oldCli != null) {
			oldCli=cli;
			oldCli.update();
			
			return ok(cli.CliNom + " Fue Modificado");
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
