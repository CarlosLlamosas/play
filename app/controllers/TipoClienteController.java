package controllers;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.Cliente;
import models.TipoCliente;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class TipoClienteController extends Controller{
	
	public Result lista() {
			List<TipoCliente> tcli = TipoCliente.find.all();
			JsonNode jj = Json.toJson(tcli);
			return ok(jj);
		}
	
	public Result show(Integer id) {
		TipoCliente tcli = TipoCliente.find.byId(id);
		if (tcli == null) {
			return notFound("Tipo de Cliente no existe");
		}
		JsonNode jj = Json.toJson(tcli);
		return ok(jj);
	}

		public Result save() {
			JsonNode jj = request().body().asJson();
			TipoCliente tcli = Json.fromJson(jj, TipoCliente.class);
			tcli.save();

			return ok(tcli.Descripcion + " Fue Agregado");
		}

		public Result delete(Integer id) {
			TipoCliente tcli = TipoCliente.find.byId(id);
			if (tcli == null) {
				return notFound("Cliente No existe");
			}
			tcli.delete();
			return ok(tcli.Descripcion + " Fue Eliminado");
		}

		public Result update() {

			JsonNode jj = request().body().asJson();
			TipoCliente tcli = Json.fromJson(jj, TipoCliente.class);
			TipoCliente oldCli = TipoCliente.find.byId(tcli.TipCliId);

			if (oldCli != null) {
				oldCli=tcli;
				oldCli.update();
				
				return ok(oldCli.Descripcion + " Fue Modificado");
			}
			return null;
		}
}
