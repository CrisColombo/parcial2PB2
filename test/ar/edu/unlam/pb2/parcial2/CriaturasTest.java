package ar.edu.unlam.pb2.parcial2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CriaturasTest {
	 @Test
	    public void queUnaCriaturaSalvajeEntrenaSinSuperarLimite() {
	        CriaturaSalvaje criatura = new CriaturaSalvaje("Blanka", 150, Afinidad.FUEGO);
	        criatura.entrenar();
	        assertEquals(Integer.valueOf(170), criatura.getEnergia());
	    }

	    @Test (expected = EnergiaExcedidaException.class)
	    public void queUnaCriaturaSalvajeNoPuedeSuperar200() {
	    	CriaturaSalvaje criatura = new CriaturaSalvaje("Blanka", 190, Afinidad.FUEGO);
	        criatura.entrenar();
	    }

	    @Test
	    public void queCriaturaSalvajeSePacificaYReduceEnergia() {
	    	CriaturaSalvaje criatura = new CriaturaSalvaje("Blanka", 100, Afinidad.FUEGO);
	        criatura.setInestable(true);
	        criatura.pacificar();
	        assertFalse(criatura.esInestable());
	        assertEquals(Integer.valueOf(80), criatura.getEnergia());
	    }

	    //domesticada aumenta su energ de forma estable y nunca se vuelven inestables 
	    
	    @Test
	    public void queUnaCriaturaDomesticadaEntrenaYAumentaSuEnergiaDeFormaEstable() {
	        CriaturaDomesticada criatura = new CriaturaDomesticada("Luna", 100, Afinidad.AGUA);
	        criatura.entrenar();
	        assertFalse(criatura.esInestable());
	        assertEquals(Integer.valueOf(105), criatura.getEnergia());
	    }
	    
	    @Test
	    public void queUnaCriaturaDomesticadaNoPuedaSerInestable() {
	    	CriaturaDomesticada criatura = new CriaturaDomesticada("Luna", 100, Afinidad.AGUA);
	        criatura.setInestable(true);
	        assertFalse(criatura.esInestable());
	    }

	    @Test
	    public void queUnaCriaturaDomesticadaSePacifica() {
	    	CriaturaDomesticada criatura = new CriaturaDomesticada("Luna", 100, Afinidad.AGUA);
	        criatura.setInestable(true);
	        criatura.pacificar();
	        assertFalse(criatura.esInestable());
	    }
	    
	    //ancestral no puede bajar su energia de 100 

	    @Test
	    public void queUnaCriaturaAncestralNoPuedaBajarSuEenergiaDe100() {
	    	CriaturaAncestral criatura = new CriaturaAncestral("Goku", 100, Afinidad.TIERRA);
	        criatura.modificarEnergia(-200);
	        assertEquals(Integer.valueOf(100), criatura.getEnergia());
	    }


	    @Test
	    public void queUnaCriaturaAncestralEntrenaYAjustaEnergia() {
	    	CriaturaAncestral criatura = new CriaturaAncestral("Goku", 100, Afinidad.TIERRA);
	        criatura.entrenar();
	        assertEquals(Integer.valueOf(120), criatura.getEnergia());
	    }


	    @Test
	    public void queCriaturaAncestralSePacificaYReduceEnergia() {
	    	CriaturaAncestral criatura = new CriaturaAncestral("Goku", 150, Afinidad.FUEGO);
	        criatura.setInestable(true);
	        criatura.pacificar();
	        assertFalse(criatura.esInestable());
	        assertEquals(Integer.valueOf(130), criatura.getEnergia());
	    }

}
