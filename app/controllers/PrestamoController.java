package controllers;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.Prestamo;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class PrestamoController extends Controller{
	public Result lista() {
		List<Prestamo> pre = Prestamo.find.all();
		JsonNode jj = Json.toJson(pre);
		return ok(jj);
	}

	public Result save() {
		JsonNode jj = request().body().asJson();
		Prestamo pre = Json.fromJson(jj, Prestamo.class);
		pre.save();

		return ok(pre.PresNro + " Fue Agregado");
	}

	public Result delete(Integer id) {
		Prestamo pre = Prestamo.find.byId(id);
		if (pre == null) {
			return notFound("Prestamo No existe");
		}
		pre.delete();
		return ok(pre.PresNro + " Fue Eliminado");
	}

	public Result update() {

		JsonNode jj = request().body().asJson();
		Prestamo pre = Json.fromJson(jj, Prestamo.class);
		Prestamo oldpre = Prestamo.find.byId(pre.PresId);

		if (oldpre != null) {
			oldpre=pre;
			oldpre.update();
			
			return ok(pre.PresNro + " Fue Modificado");
		}
		return null;
	}

	public Result edit(Integer id) {
		// System.out.println(id);

		Prestamo pre = Prestamo.find.byId(id);
		if (pre == null) {
			return notFound("Prestamo no Existe");
		}

		JsonNode jj = Json.toJson(pre);

		return ok(jj);
	}

	public Result show(Integer id) {
		Prestamo pre = Prestamo.find.byId(id);
		if (pre == null) {
			return notFound("Prestamo no existe");
		}
		JsonNode jj = Json.toJson(pre);
		return ok(jj);
	}
}
