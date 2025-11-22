package ar.edu.unlam.pb2.parcial2;

public class AscensoDelViento extends Transformacion {

	private Afinidad afinidadOriginal;

	public AscensoDelViento(Criatura criaturaOriginal) {
		super(criaturaOriginal);
		this.afinidadOriginal = criaturaOriginal.getAfinidad();
	}

	@Override
	public void entrenar() {
		criaturaOriginal.afinidad = Afinidad.AIRE;
		criaturaOriginal.entrenar();
		criaturaOriginal.afinidad = afinidadOriginal;
	}

	@Override
	public void pacificar() {
		criaturaOriginal.pacificar();
	}
	
}
