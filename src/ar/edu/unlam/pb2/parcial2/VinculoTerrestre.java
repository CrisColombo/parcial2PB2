package ar.edu.unlam.pb2.parcial2;

public class VinculoTerrestre extends Transformacion {

	public VinculoTerrestre(Criatura criaturaOriginal) {
		super(criaturaOriginal);
	}

	@Override
	public void entrenar() {
		criaturaOriginal.entrenar();

		if (criaturaOriginal.getEnergia() < 50) {
			criaturaOriginal.modificarEnergia(50 - criaturaOriginal.getEnergia());
		}
	}

	@Override
	public void pacificar() {
		criaturaOriginal.pacificar();
	}
}
