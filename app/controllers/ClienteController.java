package controllers;

import models.Cliente;
import play.libs.Json;
import play.mvc.*;
import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;


public class ClienteController extends Controller {

	 public Result lista() {
		List<Cliente> cli = Cliente.find.all();
		JsonNode jj = Json.toJson(cli);

		return ok(jj);
	}

	public Result save() {
		JsonNode jj = Json.toJson(request().body());
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
