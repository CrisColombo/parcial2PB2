package ar.edu.unlam.pb2.parcial2;

public class BendicionDelRio extends Transformacion {

	public BendicionDelRio(Criatura criaturaOriginal) {
		super(criaturaOriginal);
	}

	@Override
	public void entrenar() {
		  Integer energiaActual = criaturaOriginal.getEnergia();
	        Integer energiaDuplicada = energiaActual * 2;

	        if (energiaDuplicada > 180) {
	            energiaDuplicada = 180;
	        }

	        int incremento = energiaDuplicada - energiaActual;
	        criaturaOriginal.modificarEnergia(incremento);
	}

	@Override
	public void pacificar() {
criaturaOriginal.pacificar();
	}

}
