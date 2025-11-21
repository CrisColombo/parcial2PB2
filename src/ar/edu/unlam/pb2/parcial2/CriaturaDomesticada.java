package ar.edu.unlam.pb2.parcial2;

public class CriaturaDomesticada extends Criatura {

	public CriaturaDomesticada(String nombre, Integer energia, Afinidad afinidad) {
		super(nombre, energia, afinidad);
		
	}

	@Override
	public void entrenar() {
		 modificarEnergia(5);

	}

	@Override
	public void pacificar() {
		this.inestable=false;
	}

	 @Override
	    public void setInestable(Boolean inestable) {
	        // para q nunca sea inestable
	        this.inestable = false;
	    }
}
