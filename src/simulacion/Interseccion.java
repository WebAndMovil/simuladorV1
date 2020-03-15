package simulacion;

import java.awt.Rectangle;

public class Interseccion {
	private Rectangle rectangle;
	private Calle calle_norte = null;
	private Calle calle_sur = null;
	private Calle calle_este = null;
	private Calle calle_oeste = null;

	public Interseccion() {
		
	}
	
	public Interseccion(Rectangle rectangle, Calle calle_norte, Calle calle_sur, Calle calle_este, Calle calle_oeste) {
		super();
		this.rectangle = rectangle;
		this.calle_norte = calle_norte;
		this.calle_sur = calle_sur;
		this.calle_este = calle_este;
		this.calle_oeste = calle_oeste;
	}



	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public Calle getCalle_norte() {
		return calle_norte;
	}

	public void setCalle_norte(Calle calle_norte) {
		this.calle_norte = calle_norte;
	}

	public Calle getCalle_sur() {
		return calle_sur;
	}

	public void setCalle_sur(Calle calle_sur) {
		this.calle_sur = calle_sur;
	}

	public Calle getCalle_este() {
		return calle_este;
	}

	public void setCalle_este(Calle calle_este) {
		this.calle_este = calle_este;
	}

	public Calle getCalle_oeste() {
		return calle_oeste;
	}

	public void setCalle_oeste(Calle calle_oeste) {
		this.calle_oeste = calle_oeste;
	}

}
