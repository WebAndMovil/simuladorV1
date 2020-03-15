package simulacion;

public class ThreadCarros extends Thread {

	private static boolean activo = true;
	private SwingSimulacion simulacion;

	public ThreadCarros(SwingSimulacion simulacion) {
		this.simulacion = simulacion;

	}

	@Override
	public void run() {
		try {
			int count = 0;
			int tiempo_semaforo = 0;

			while (true) {
				if (activo) {
					//Ingresar carros cada 5 segundos con un máximo de aproximadamente 8 carros.
					if (count % 50 == 0 && count < 1000) {
						simulacion.agregar_carro_calle_x1();
					}
					if(tiempo_semaforo <= 100) {
						simulacion.mover(false);
					} else if(tiempo_semaforo > 100 && tiempo_semaforo<250){
						simulacion.mover(true);
					}else {
						tiempo_semaforo = 0;
					}
					tiempo_semaforo +=1;
					count += 1;
				}
				Thread.sleep(10);
			}
		} catch (InterruptedException ie) {
			System.out.println(ie);
		}
	}

	public void activar() {
		this.activo = true;
	}

	public void detener() {
		this.activo = false;
	}

	public static boolean isActivo() {
		return activo;
	}

	public static void setActivo(boolean activo) {
		ThreadCarros.activo = activo;
	}

}
