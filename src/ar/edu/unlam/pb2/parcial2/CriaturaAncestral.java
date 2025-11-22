package ar.edu.unlam.pb2.parcial2;

public class CriaturaAncestral extends Criatura {

	public CriaturaAncestral(String nombre, Integer energia, Afinidad afinidad) {
		super(nombre, energia, afinidad);
	}

	@Override
	public void entrenar() {
		 modificarEnergia(20);
	}

	@Override
	public void pacificar() {
		this.inestable = false;
		modificarEnergia(-20);
	}
	
	@Override
	public void modificarEnergia(Integer incrementoEnergia) {
		this.energia += incrementoEnergia;
		if (this.energia < 100) {
			this.energia = 100;
		}
}
	
}