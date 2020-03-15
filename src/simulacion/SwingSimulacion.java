package simulacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SwingSimulacion extends JPanel {

	private Calle calle_1, calle_2, calle_3, calle_4;
	private static List<Carro> carros = new ArrayList<Carro>();
	private static List<Carro> carros_cola2 = new ArrayList<Carro>();
	private static List<Carro> carros_cola3 = new ArrayList<Carro>();
	private static List<Carro> carros_cola4 = new ArrayList<Carro>();

	// Constantes
	private static final int ANCHO_CALLE_X = 500;
	private static final int ALTO_CALLE_X = 60;
	private static final int ANCHO_CALLE_Y = 60;
	private static final int ALTO_CALLE_Y = 600;
	private static final int ANCHO_CARRO = 50;
	private static final int ALTO_CARRO = 50;

	private static boolean se_movio_cola = false;

	public SwingSimulacion() {
		initUI();
	}

	private void initUI() {
		calle_1 = new Calle(new Rectangle(0, 0, ANCHO_CALLE_X, ALTO_CALLE_X), 1, 0, null, null);
		calle_2 = new Calle(new Rectangle(calle_1.getRectangle().width, calle_1.getRectangle().height, ANCHO_CALLE_Y, ALTO_CALLE_Y),1, 0, null, null);
		calle_3 = new Calle(new Rectangle(0, calle_2.getRectangle().height, ANCHO_CALLE_X, ALTO_CALLE_X),1, 0, null, null);
		calle_4 = new Calle(new Rectangle(calle_3.getRectangle().width, calle_2.getRectangle().height, ANCHO_CALLE_X, ALTO_CALLE_X),1, 0, null, null);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.GRAY);
		g.fillRect(calle_1.getRectangle().x, calle_1.getRectangle().y, calle_1.getRectangle().width,calle_1.getRectangle().height);
		g.fillRect(calle_2.getRectangle().x, calle_2.getRectangle().y, calle_2.getRectangle().width,calle_2.getRectangle().height);
		g.fillRect(calle_3.getRectangle().x, calle_3.getRectangle().y, calle_3.getRectangle().width,calle_3.getRectangle().height);
		g.fillRect(calle_4.getRectangle().x, calle_4.getRectangle().y, calle_4.getRectangle().width,calle_4.getRectangle().height);

		for (Carro carro : carros) {
			ImageIcon img = new ImageIcon(this.getClass().getResource(constantes.carro_der));
			g.drawImage(img.getImage(), carro.getRectangle().x, carro.getRectangle().y, carro.getRectangle().height, carro.getRectangle().width, null);
			
		}
		for (Carro carro : carros_cola2) {
			ImageIcon img = new ImageIcon(this.getClass().getResource(constantes.carro_abajo));
			g.drawImage(img.getImage(), carro.getRectangle().x, carro.getRectangle().y, carro.getRectangle().height, carro.getRectangle().width, null);
		}
		for (Carro carro : carros_cola3) {
			ImageIcon img = new ImageIcon(this.getClass().getResource(constantes.carro_izq));
			g.drawImage(img.getImage(), carro.getRectangle().x, carro.getRectangle().y, carro.getRectangle().height, carro.getRectangle().width, null);
		}
		for (Carro carro : carros_cola4) {
			ImageIcon img = new ImageIcon(this.getClass().getResource(constantes.carro_der));
			g.drawImage(img.getImage(), carro.getRectangle().x, carro.getRectangle().y, carro.getRectangle().height, carro.getRectangle().width, null);
		}

	}
	


	public void agregar_carro_calle_x1() {
		Carro car_1 = new Carro(new Rectangle(calle_1.getRectangle().x + 0, calle_1.getRectangle().y / 2, ANCHO_CARRO, ALTO_CARRO), 1);
		car_1.setCalle(calle_1);
		carros.add(car_1);
	}
	
	public void mover(boolean esta_detenida) {
		int count = 0;
		for (int i=carros.size()-1;i>=0;i--) {
			Carro carro = carros.get(i);
			
			if(carro.getEstado()==1) {
				try {
					Carro carro2 = carros.get(i-1);
					if(carro2.getRectangle().x > carro.getRectangle().x +carro.getRectangle().width + 10 ) {
						carro.setEstado(1);
						carro.setRectangle(new Rectangle(carro.getRectangle().x + 1, carro.getRectangle().y, carro.getRectangle().height, carro.getRectangle().width));
					}
					else {
						carro.setEstado(0);
					}
				}catch (Exception e) {
					System.out.println("E cola1="+carro.getRectangle().x);
					if(carro.getRectangle().x > carro.getCalle().getRectangle().width + 25) {
						if(esta_detenida) {
							carro.setEstado(0);
						}else {
							carro.setEstado(1);
							System.out.println("Se metio a la excepcion");
							Carro car = carros.get(i);
							carros.remove(i);
							System.out.println(car.toString());
							car.setCalle(calle_2);
							carros_cola2.add(car);
							break;
						}
					}else {
						carro.setRectangle(new Rectangle(carro.getRectangle().x + 1, carro.getRectangle().y, carro.getRectangle().height, carro.getRectangle().width));
					}
				}
			}else {
				carro.setEstado(1);
			}
		}


		for (int i=carros_cola2.size()-1;i>=0;i--) {
			Carro carro = carros_cola2.get(i);			
			if(carro.getEstado()==1) {
				try {
					Carro carro2 = carros_cola2.get(i-1);
					if(carro2.getRectangle().y - carro2.getRectangle().height - 10 > carro.getRectangle().y) {
						carro.setRectangle(new Rectangle(carro.getRectangle().x, carro.getRectangle().y + 1, carro.getRectangle().height, carro.getRectangle().width));
						System.out.println("Y = "+carro.getRectangle().y + " Y2 = "+carro2.getRectangle().y);
					}else {
						carro.setEstado(0);
						System.out.println("Detenido = "+carro.getRectangle().y);
					}
				}catch (Exception e) {
					if(carro.getRectangle().y > carro.getCalle().getRectangle().height + 25) {
						if(esta_detenida) {
							carro.setEstado(0);
						}else {
							System.out.println("Se metio a la excepcion");
							Carro car = carros_cola2.get(i);
							carros_cola2.remove(i);
							Random rand = new Random();
							int valor = rand.nextInt(100);
							if(valor>50) {
								carros_cola3.add(car);
							}else {
								carros_cola4.add(car);
							}
							break;
						}
					}else {
						carro.setRectangle(new Rectangle(carro.getRectangle().x, carro.getRectangle().y + 1, carro.getRectangle().height, carro.getRectangle().width));
					}
				}
			}else {
				carro.setEstado(1);	
			}
			
		}
		
		for (int i=carros_cola3.size()-1;i>=0;i--) {
			Carro carro = carros_cola3.get(i);
			
			if(carro.getEstado()==1) {
				try {
					Carro carro2 = carros_cola3.get(i-1);
					if(carro2.getRectangle().x < carro.getRectangle().x +carro.getRectangle().width + 10 ) {
						carro.setEstado(1);
						carro.setRectangle(new Rectangle(carro.getRectangle().x - 1, carro.getRectangle().y, carro.getRectangle().height, carro.getRectangle().width));
					}
					else {
						carro.setEstado(0);
					}
				}catch (Exception e) {
					System.out.println("E cola1="+carro.getRectangle().x);
					if(carro.getRectangle().x < 0) {
						if(esta_detenida) {
							carro.setEstado(0);
						}else {
							carro.setEstado(1);
							System.out.println("Se metio a la excepcion");
							Carro car = carros_cola3.get(i);
							carros_cola3.remove(i);
							System.out.println(car.toString());
							car.setRectangle(new Rectangle(0, 0, car.getRectangle().height, car.getRectangle().width));
							car.setCalle(calle_1);
							carros.add(car);
							break;
						}
					}else {
						carro.setRectangle(new Rectangle(carro.getRectangle().x - 1, carro.getRectangle().y, carro.getRectangle().height, carro.getRectangle().width));
					}
				}
			}else {
				carro.setEstado(1);
			}
		}		
		
		for (int i=carros_cola4.size()-1;i>=0;i--) {
			Carro carro = carros_cola4.get(i);
			
			if(carro.getEstado()==1) {
				try {
					Carro carro2 = carros_cola4.get(i-1);
					if(carro2.getRectangle().x > carro.getRectangle().x +carro.getRectangle().width + 10 ) {
						carro.setEstado(1);
						carro.setRectangle(new Rectangle(carro.getRectangle().x + 1, carro.getRectangle().y, carro.getRectangle().height, carro.getRectangle().width));
					}
					else {
						carro.setEstado(0);
					}
				}catch (Exception e) {
					if(carro.getRectangle().x < carro.getCalle().getRectangle().width + 25) {
						if(esta_detenida) {
							carro.setEstado(0);
						}else {
							carro.setEstado(1);
							System.out.println("Se metio a la excepcion cola 4");
							Carro car = carros_cola4.get(i);
							carros_cola4.remove(i);
							System.out.println(car.toString());
							car.setCalle(calle_2);
							//carros_cola2.add(car);
							break;
						}
					}else {
						carro.setRectangle(new Rectangle(carro.getRectangle().x + 1, carro.getRectangle().y, carro.getRectangle().height, carro.getRectangle().width));
					}
				}
			}else {
				carro.setEstado(1);
			}
		}
		
		
		
		repaint();
	}
	

}
