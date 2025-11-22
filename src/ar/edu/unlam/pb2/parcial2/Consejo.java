package ar.edu.unlam.pb2.parcial2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Consejo {

	public static List<Criatura> listarTodasLasCriaturas(List<MaestroElemental> maestros) {
		List<Criatura> resultado = new ArrayList<>();

		for (MaestroElemental maestro : maestros) {
			resultado.addAll(maestro.obtenerTodasLasCriaturas());
		}
		return resultado;
	}

	public static Criatura obtenerCriaturaConMayorEnergia(List<MaestroElemental> maestros) {

		List<Criatura> todasLasCriaturas = listarTodasLasCriaturas(maestros);

		Criatura criaturaConMayorEnergia = null;
		int maxEnergia = 0;

		for (Criatura c : todasLasCriaturas) {
			if (c.getEnergia() > maxEnergia) {
				maxEnergia = c.getEnergia();
				criaturaConMayorEnergia = c;
			}
		}
		return criaturaConMayorEnergia;
	}

	public static MaestroElemental obtenerMaestroConMasCriaturasTransformadas(List<MaestroElemental> maestros) {
		MaestroElemental ganador = null;
		int maxTransformadas = 0;
		for (MaestroElemental maestro : maestros) {
			int contador = 0;
			for (Criatura c : maestro.obtenerTodasLasCriaturas()) {
				if (c instanceof Transformacion) {
					contador++;
				}
			}
			if (contador > maxTransformadas) {
				maxTransformadas = contador;
				ganador = maestro;
			}
		}
		return ganador;
	}

	public static Map<Afinidad, Integer> obtenerConteoCriaturasPorAfinidad(List<MaestroElemental> maestros) {
		Map<Afinidad, Integer> conteo = new HashMap<>();

		for (MaestroElemental maestro : maestros) {
			for (Criatura criatura : maestro.obtenerTodasLasCriaturas()) {
				Afinidad a = criatura.getAfinidad();
				conteo.put(a, conteo.getOrDefault(a, 0) + 1);
			}
		}
		return conteo;
	}
}