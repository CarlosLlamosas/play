package controllers;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.Cuota;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class CuotaController extends Controller{
	public Result lista() {
		List<Cuota> cuo = Cuota.find.all();
		JsonNode jj = Json.toJson(cuo);
		return ok(jj);
	}

	public Result save() {
		JsonNode jj = request().body().asJson();
		Cuota cuo = Json.fromJson(jj, Cuota.class);
		cuo.save();

		return ok(cuo.CuoNroCuo + " Fue Agregado");
	}

	public Result delete(Integer id) {
		Cuota cuo = Cuota.find.byId(id);
		if (cuo == null) {
			return notFound("Cliente No existe");
		}
		cuo.delete();
		return ok(cuo.CuoNroCuo + " Fue Eliminado");
	}

	public Result update() {

		JsonNode jj = request().body().asJson();
		Cuota cuo = Json.fromJson(jj, Cuota.class);
		Cuota oldcuo = Cuota.find.byId(cuo.CuoId);

		if (oldcuo != null) {
			oldcuo=cuo;
			oldcuo.update();
			
			return ok(oldcuo.CuoNroCuo + " Fue Modificado");
		}
		return null;
	}

	public Result edit(Integer id) {
		// System.out.println(id);

		Cuota cuo = Cuota.find.byId(id);
		if (cuo == null) {
			return notFound("Cuota no Existe");
		}

		JsonNode jj = Json.toJson(cuo);

		return ok(jj);
	}

	public Result show(Integer id) {
		Cuota cuo = Cuota.find.byId(id);
		if (cuo == null) {
			return notFound("Cuota no existe");
		}
		JsonNode jj = Json.toJson(cuo);
		return ok(jj);
	}
}
