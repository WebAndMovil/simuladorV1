package simulacion;

import java.awt.Rectangle;

public class Calle {
	private Rectangle rectangle;
	private int direccion_x;
	private int direccion_y;
	private Interseccion int_frente = null;
	private Interseccion int_atras = null;
	public static int TIEMPO_ROJO = 50; // Sin final, se puede modificar c:

	public Calle() {

	}

	public Calle(Rectangle rectangle, int direccion_x, int direccion_y, Interseccion int_frente,
			Interseccion int_atras) {
		super();
		this.rectangle = rectangle;
		this.direccion_x = direccion_x;
		this.direccion_y = direccion_y;
		this.int_frente = int_frente;
		this.int_atras = int_atras;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public int getDireccion_x() {
		return direccion_x;
	}

	public void setDireccion_x(int direccion_x) {
		this.direccion_x = direccion_x;
	}

	public int getDireccion_y() {
		return direccion_y;
	}

	public void setDireccion_y(int direccion_y) {
		this.direccion_y = direccion_y;
	}

	public Interseccion getInt_frente() {
		return int_frente;
	}

	public void setInt_frente(Interseccion int_frente) {
		this.int_frente = int_frente;
	}

	public Interseccion getInt_atras() {
		return int_atras;
	}

	public void setInt_atras(Interseccion int_atras) {
		this.int_atras = int_atras;
	}

}
