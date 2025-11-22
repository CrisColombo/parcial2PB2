package ar.edu.unlam.pb2.parcial2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransformacionesTest {

	@Test
	public void queBendicionDelRioDupliqueLaEnergia() {

		Criatura normal = new CriaturaDomesticada("Agua", 30, Afinidad.AGUA);
		Criatura transformada = new BendicionDelRio(normal);

		transformada.entrenar();

		assertEquals(Integer.valueOf(60), normal.getEnergia());
	}

	@Test
	public void queBendicionDelRioNoSupereEl80DeEenergia() {
		Criatura normal = new CriaturaDomesticada("Acuatica", 100, Afinidad.AGUA);
		Criatura transformada = new BendicionDelRio(normal);
		transformada.entrenar();
		assertEquals(Integer.valueOf(180), normal.getEnergia());
	}
	
	@Test
	public void queLlamaInternaAumente30SiEsFuego() {
	    Criatura normal = new CriaturaDomesticada("Pepo", 20, Afinidad.FUEGO);
	    Criatura transformada = new LlamaInterna(normal);
	    transformada.entrenar();
	    assertEquals(Integer.valueOf(50), normal.getEnergia());
	}
	
	@Test
	public void queLlamaInternaSeVuelvaInestableSiNoEsFuego() {

		Criatura normal = new CriaturaAncestral("Pipo", 100, Afinidad.AGUA);
		Criatura transformada = new LlamaInterna(normal);

		transformada.entrenar();

		assertTrue(normal.esInestable());
	}
	
	@Test
	public void queVinculoTerrestreNoTengaEnergiasMenorA50() {

	    Criatura normal = new CriaturaDomesticada("Pepi", 40, Afinidad.TIERRA);
	    Criatura transformada = new VinculoTerrestre(normal);

	    transformada.entrenar(); 

	    assertEquals(Integer.valueOf(50), normal.getEnergia());
	}
	
	@Test
	public void queAscensoDelVientoCambieAfinidadTemporalmenteAAire() {

	    Criatura normal = new CriaturaDomesticada("Voladora", 20, Afinidad.FUEGO);
	    Criatura transformada = new AscensoDelViento(normal);

	    transformada.entrenar();

	    assertEquals(Afinidad.FUEGO, normal.getAfinidad());
	}
}
