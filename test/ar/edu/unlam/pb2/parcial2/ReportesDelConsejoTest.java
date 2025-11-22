package ar.edu.unlam.pb2.parcial2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ReportesDelConsejoTest {

	@Test
	public void queSeListanTodasLasCriaturasDeTodosLosMaestros() {
		MaestroElemental m1 = new MaestroElemental("Harry", 20, Afinidad.AIRE);
		MaestroElemental m2 = new MaestroElemental("Ron", 18, Afinidad.AGUA);

		m1.agregarCriatura(new CriaturaDomesticada("Dobby", 50, Afinidad.AIRE));
		m2.agregarCriatura(new CriaturaSalvaje("Snape", 100, Afinidad.AGUA));

		List<MaestroElemental> maestros = Arrays.asList(m1, m2);

		List<Criatura> criaturas = Consejo.listarTodasLasCriaturas(maestros);

		assertEquals(2, criaturas.size());
	}

	@Test
	public void queSePuedaObtenerLaCriaturaConMayorEnergia() {
		MaestroElemental m = new MaestroElemental("Roman", 20, Afinidad.FUEGO);
		m.agregarCriatura(new CriaturaDomesticada("Sirius", 90, Afinidad.FUEGO));
		m.agregarCriatura(new CriaturaAncestral("Diego", 150, Afinidad.FUEGO));

		Criatura mayorEnergia = Consejo.obtenerCriaturaConMayorEnergia(List.of(m));

		assertEquals("Diego", mayorEnergia.getNombre());
	}

	@Test
	public void queDetermineElMaestroConMasCriaturasTransformadas() {
		MaestroElemental m1 = new MaestroElemental("Nestor", 15, Afinidad.AIRE);
		MaestroElemental m2 = new MaestroElemental("Raul", 15, Afinidad.AGUA);

		Criatura c1 = new CriaturaDomesticada("Carlos", 50, Afinidad.AIRE);
		Criatura c2 = new CriaturaDomesticada("Hodor", 40, Afinidad.AGUA);

		Criatura t1 = new AscensoDelViento(c1);
		Criatura t2 = new BendicionDelRio(c2);

		m1.agregarCriatura(t1);

		m2.agregarCriatura(t2);
		m2.agregarCriatura(new LlamaInterna(c1));

		MaestroElemental ganador = Consejo.obtenerMaestroConMasCriaturasTransformadas(List.of(m1, m2));

		assertEquals("Raul", ganador.getNombre());
	}

	@Test
	public void queSePuedaObtenerUnMapaConCantidadDeCriaturasPorAfinidad() {

		MaestroElemental m1 = new MaestroElemental("Harry", 20, Afinidad.FUEGO);
		MaestroElemental m2 = new MaestroElemental("Aqua", 15, Afinidad.AGUA);

		m1.agregarCriatura(new CriaturaDomesticada("Fenix", 100, Afinidad.FUEGO));
		m1.agregarCriatura(new CriaturaDomesticada("Llama", 90, Afinidad.FUEGO));

		m2.agregarCriatura(new CriaturaSalvaje("Neptuno", 110, Afinidad.AGUA));
		m2.agregarCriatura(new CriaturaAncestral("Tierrazo", 150, Afinidad.TIERRA));

		List<MaestroElemental> maestros = List.of(m1, m2);

		Map<Afinidad, Integer> resultado = Consejo.obtenerConteoCriaturasPorAfinidad(maestros);

		assertEquals(Integer.valueOf(2), resultado.get(Afinidad.FUEGO));
		assertEquals(Integer.valueOf(1), resultado.get(Afinidad.AGUA));
		assertEquals(Integer.valueOf(1), resultado.get(Afinidad.TIERRA));
	}

}
