package ar.edu.unlam.pb2.parcial2;

public class LlamaInterna extends Transformacion {

	public LlamaInterna(Criatura criaturaOriginal) {
		super(criaturaOriginal);
	}

	@Override
	public void entrenar() {
		if (criaturaOriginal.getAfinidad() == Afinidad.FUEGO) {
			criaturaOriginal.modificarEnergia(30);
		} else {
			criaturaOriginal.setInestable(true);
		}
	}

	@Override
	public void pacificar() {
		criaturaOriginal.pacificar();
	}
}
