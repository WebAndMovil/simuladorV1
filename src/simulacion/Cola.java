package simulacion;

public class Cola {
	private Carro carro_inicio, carro_final;
	private Calle calle;
	public static final int espacio = 10;

	public Cola() {
		carro_inicio = null;
		carro_final = null;
		// Como no hay ningun parametro, no hay necesidad de un This.
	}

	public Cola(Calle calle) {
		super();
		this.calle = calle;
		this.carro_inicio = null;
		this.carro_final = null;
	}

	public Carro getCarro_inicio() {
		return carro_inicio;
	}

	public void setCarro_inicio(Carro carro_inicio) {
		this.carro_inicio = carro_inicio;
	}

	public Carro getCarro_final() {
		return carro_final;
	}

	public void setCarro_final(Carro carro_final) {
		this.carro_final = carro_final;
	}

	public Calle getCalle() {
		return calle;
	}

	public void setCalle(Calle calle) {
		this.calle = calle;
	}

	// **************************************************
	// Metodos Cola.
	// **************************************************

	// Cola vacia.
	boolean colaVaciaCarro() {
		if (carro_inicio == null) {
			return true;
		} else {
			return false;
		}
	}
	/*

	// Insertar carro.
	boolean insertarCarro(Carro carro_nuevo) {

		boolean retorno = false;

		// Verificando si la cola esta vacia.
		if (colaVaciaCarro() == true) {
			if ((carro_nuevo.getRectangle().x + carro_nuevo.getRectangle().width) < calle.getRectangle().width) {
				carro_inicio = carro_nuevo;
				carro_final = carro_nuevo;
				retorno = true;
			}
		} else {
			// Verificanfo la direccion de la calle.

			// Eje x.
			if (calle.getDireccion_x() != 0) {
				if ((carro_nuevo.getRectangle().getWidth() + espacio) < (calle.getRectangle().width
						- (calle.getRectangle().width - espacio - carro_final.getRectangle().x))
						&& ((carro_nuevo.getRectangle().x + carro_nuevo.getRectangle().width) < calle
								.getRectangle().width)) {

					System.out.println(carro_nuevo.getRectangle().x);
					System.out.println(calle.getRectangle().width);

					carro_nuevo.setCarro_siguiente_adelante(carro_final);
					carro_final.setCarro_siguiente_atras(carro_nuevo);
					carro_final = carro_nuevo;

					retorno = true;
				} else {
					carro_nuevo.setEstado(0); // No se mueve.
					// Los demas carros los pondremos a velocidad 0 en el hilo.
				}
			} else {
				// Eje y.
				if ((carro_nuevo.getRectangle().getHeight() + espacio) < (calle.getRectangle().height
						- (calle.getRectangle().height - espacio - carro_final.getRectangle().y))) {
					carro_nuevo.setCarro_siguiente_adelante(carro_final);
					carro_final.setCarro_siguiente_atras(carro_nuevo);
					carro_final = carro_nuevo;
					retorno = true;
				} else {
					carro_nuevo.setEstado(0); // No se mueve.
				}

			}
		}

		return retorno;
	}

	// Extraer Carro.
	// No eliminamos de una sola vez porque necesitamos saber a que cola se añadir.

	Carro extraerCarro() {
		// No verificamos si esta vacia porque ya lo inicializamos con null.
		return getCarro_final();
	}

	// Eliminar carro.
	boolean eliminarCarro() {
		boolean retorno = false;

		try {
			if (colaVaciaCarro() == false) {
				Carro carro_primero = getCarro_inicio();
				Carro carro_siguiente_primero = carro_primero.getCarro_siguiente_atras();
				carro_siguiente_primero.setEstado(1);
				setCarro_inicio(carro_siguiente_primero);
				carro_primero.setCarro_siguiente_adelante(null);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return retorno;
	}*/
}
