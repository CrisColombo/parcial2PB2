package ar.edu.unlam.pb2.parcial2;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaestroElementalTest {

	@Test
	public void queElMaestroPuedaTenerUnaCriatura() {
	    MaestroElemental maestro = new MaestroElemental("Harry", 20, Afinidad.FUEGO);
	    Criatura criatura = new CriaturaDomesticada("Dobby", 80, Afinidad.FUEGO);

	    maestro.agregarCriatura(criatura);

	    assertNotNull(maestro.getCriatura("Dobby"));
	}

	@Test(expected = FaltaDeMaestriaException.class)
	public void queMaestroConPocaMaestriaNoPuedaEntrenarUnaCriatura() throws FaltaDeMaestriaException {
	    MaestroElemental maestro = new MaestroElemental("Hermione", 3, Afinidad.AGUA);
	    Criatura criatura = new CriaturaDomesticada("Blue", 100, Afinidad.AGUA);

	    maestro.agregarCriatura(criatura);
	    maestro.entrenar("Blue"); 
	}
	
	@Test
	public void queMaestroConSuficienteMaestriaPuedaEntrenarUnaCriatura() throws FaltaDeMaestriaException {
    MaestroElemental maestro = new MaestroElemental("Harry", 15, Afinidad.FUEGO);
    Criatura criatura = new CriaturaDomesticada("Dobby", 100, Afinidad.FUEGO);

    maestro.agregarCriatura(criatura);
    maestro.entrenar("Dobby");

    assertEquals(Integer.valueOf(105), criatura.getEnergia());
}
	
	@Test
	public void queMaestroPuedaPacificarACriaturaInestable() {
	    MaestroElemental maestro = new MaestroElemental("Harry", 20, Afinidad.FUEGO);
	    Criatura criatura = new CriaturaSalvaje("Blanka", 100, Afinidad.FUEGO);

	    criatura.setInestable(true);
	    maestro.agregarCriatura(criatura);

	    maestro.pacificar("Blanka");

	    assertFalse(criatura.esInestable());
	}




}