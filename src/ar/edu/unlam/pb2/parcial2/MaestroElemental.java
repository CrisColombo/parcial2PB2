package ar.edu.unlam.pb2.parcial2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaestroElemental {

	private String nombre;
	private Integer nivelDeMaestria;
	private Afinidad afinidadElemental;
	private Map<String, Criatura> criaturas;

	public MaestroElemental(String nombre, int nivelDeMaestria, Afinidad afinidadElemental) {
		this.nombre = nombre;
		this.nivelDeMaestria = nivelDeMaestria;
		this.afinidadElemental = afinidadElemental;
		this.criaturas = new HashMap<>();
	}

	public void agregarCriatura(Criatura criatura) {
		criaturas.put(criatura.getNombre(), criatura);

	}

	public Criatura getCriatura(String nombreCriatura) {
		return criaturas.get(nombreCriatura);
	}

	public void entrenar(String nombreCriatura) throws FaltaDeMaestriaException {
		Criatura criatura = criaturas.get(nombreCriatura);

		if (criatura == null) {
			return;
		}

		if (this.nivelDeMaestria < 10) {
			throw new FaltaDeMaestriaException("La maestría es insuficiente.");
		}
		criatura.entrenar();
	}

	public void pacificar(String nombreCriatura) {
		Criatura criatura = criaturas.get(nombreCriatura);
		if (criatura != null) {
			criatura.pacificar();
		}
	}

	public List<Criatura> obtenerTodasLasCriaturas() {
		return new ArrayList<>(criaturas.values());
	}

	public Object getNombre() {
		return nombre;
	}
}
