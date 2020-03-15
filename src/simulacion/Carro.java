package simulacion;

import java.awt.Rectangle;

public class Carro {
	private Rectangle rectangle;
	private int estado = 1; // 1: Avanzando y 0: Detenido.
	private Calle calle;
//	private Carro carro_siguiente_adelante = null;
//	private Carro carro_siguiente_atras = null;

	public Carro() {

	}

	public Carro(Rectangle rectangle, int estado) {
		super();
		this.rectangle = rectangle;
		this.estado = estado;
	}
	
	

	public Carro(Rectangle rectangle, int estado, Calle calle) {
		super();
		this.rectangle = rectangle;
		this.estado = estado;
		this.calle = calle;
	}
	
	
	

	public Calle getCalle() {
		return calle;
	}

	public void setCalle(Calle calle) {
		this.calle = calle;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
/*
	public Carro getCarro_siguiente_adelante() {
		return carro_siguiente_adelante;
	}

	public void setCarro_siguiente_adelante(Carro carro_siguiente_adelante) {
		this.carro_siguiente_adelante = carro_siguiente_adelante;
	}

	public Carro getCarro_siguiente_atras() {
		return carro_siguiente_atras;
	}

	public void setCarro_siguiente_atras(Carro carro_siguiente_atras) {
		this.carro_siguiente_atras = carro_siguiente_atras;
	}
	
*/
	
}
