package ar.edu.unlam.pb2.parcial2;

public class ManejadorDeInteracciones implements Interaccion {

	@Override
	public void aplicar(Criatura criatura1, Criatura criatura2) {
		if (criatura1 instanceof CriaturaAncestral || criatura2 instanceof CriaturaAncestral) {
			aplicarReglaAncestral(criatura1, criatura2);
			return;
		}

		if (criatura1.getAfinidad() == criatura2.getAfinidad()) {
			criatura1.modificarEnergia(10);
			criatura2.modificarEnergia(10);
			return;
		}

		if (sonOpuestas(criatura1.getAfinidad(), criatura2.getAfinidad())) {
			criatura1.setInestable(true);
			criatura2.setInestable(true);
		}
	}

	private void aplicarReglaAncestral(Criatura criatura1, Criatura criatura2) {
		if (criatura1 instanceof CriaturaAncestral) {
			criatura1.modificarEnergia(20);
			criatura2.modificarEnergia(-15);
		} else {
			criatura2.modificarEnergia(20);
			criatura1.modificarEnergia(-15);
		}
	}

	private boolean sonOpuestas(Afinidad a1, Afinidad a2) {
        return (a1 == Afinidad.AGUA && a2 == Afinidad.FUEGO) ||
               (a1 == Afinidad.FUEGO && a2 == Afinidad.AGUA) ||
               (a1 == Afinidad.AIRE && a2 == Afinidad.TIERRA) ||
               (a1 == Afinidad.TIERRA && a2 == Afinidad.AIRE);
    }

}
