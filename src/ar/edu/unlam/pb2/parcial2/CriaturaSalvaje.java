package ar.edu.unlam.pb2.parcial2;

public class CriaturaSalvaje extends Criatura {

	public CriaturaSalvaje(String nombre, Integer energia, Afinidad afinidad) {
		super(nombre, energia, afinidad);
	}

	@Override
	public void entrenar() {
		if (energia + 20 > 200) {
			throw new EnergiaExcedidaException(
					"La energía excede el máximo de 200 permitido para una criatura salvaje.");
		}
		modificarEnergia(20);
	}

	@Override
	public void pacificar() {
		this.inestable = false;
		modificarEnergia(-20);
	}
}
