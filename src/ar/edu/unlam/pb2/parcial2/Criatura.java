package ar.edu.unlam.pb2.parcial2;


public abstract class Criatura {
	protected String nombre;
	protected Integer energia;
	protected Afinidad afinidad;
	protected Boolean inestable;

	public Criatura(String nombre, Integer energia, Afinidad afinidad) {
		this.nombre = nombre;
		this.energia = energia;
		this.afinidad = afinidad;
		this.inestable = false;
	}

	public abstract void entrenar(); 

	public abstract void pacificar();

	public String getNombre() {
		return nombre;
	}

	public Integer getEnergia() {
		return energia;
	}

	public Afinidad getAfinidad() {
		return afinidad;
	}

	public Boolean esInestable() {
		return inestable;
	}

	public void setInestable(Boolean inestable) {
		this.inestable = inestable;
	}

	public void modificarEnergia(Integer incremento) {
		this.energia += incremento;
		if (this.energia < 0)
			this.energia = 0;
	}
}
