package ar.edu.unlam.pb2.parcial2;

public abstract class Transformacion extends Criatura {

	protected Criatura criaturaOriginal;
	
	public Transformacion(Criatura criaturaOriginal) {
		super(criaturaOriginal.getNombre(), criaturaOriginal.getEnergia(), criaturaOriginal.getAfinidad());
		this.criaturaOriginal=criaturaOriginal;
	
	}



    @Override
    public abstract void entrenar();

    @Override
    public abstract void pacificar();
}
