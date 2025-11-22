package ar.edu.unlam.pb2.parcial2;

import static org.junit.Assert.*;

import org.junit.Test;

public class InteraccionesTest {

	private Interaccion interaccion = new ManejadorDeInteracciones();

	@Test
	public void queCriaturasConAfinidadIgualGanenEnergia() {
		Criatura criaturaUno = new CriaturaDomesticada("Luna", 50, Afinidad.AGUA);
		Criatura criaturaDos = new CriaturaDomesticada("Sol", 60, Afinidad.AGUA);
		interaccion.aplicar(criaturaUno, criaturaDos);

		assertEquals(Integer.valueOf(60), criaturaUno.getEnergia());
		assertEquals(Integer.valueOf(70), criaturaDos.getEnergia());
	}

	@Test
	public void queCriaturasConAfinidadOpuestaSeVuelvanInestables() {
		Criatura criaturaUno = new CriaturaSalvaje("Blanka", 50, Afinidad.AGUA);
		Criatura criaturaDos = new CriaturaSalvaje("Nerja", 60, Afinidad.FUEGO);
		interaccion.aplicar(criaturaUno, criaturaDos);

		assertTrue(criaturaUno.esInestable());
		assertTrue(criaturaDos.esInestable());
	}

	@Test
	public void queCriaturaAncestralDomineLaInteraccion() {
		Criatura criaturaUno = new CriaturaAncestral("Ancestro", 120, Afinidad.TIERRA);
		Criatura criaturaDos = new CriaturaDomesticada("Comun", 40, Afinidad.TIERRA);

		interaccion.aplicar(criaturaUno, criaturaDos);

		assertEquals(Integer.valueOf(140), criaturaUno.getEnergia());
		assertEquals(Integer.valueOf(25), criaturaDos.getEnergia());
	}
}
