import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;


public class NXTRobot {

	private static int DEFAULTVALUE = 50;
	private static int CURVAVALUE = 10;
	private static UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S4);
	private int lasty = 0;

	public boolean ehVaga() {
		int d = sensor.getDistance();
		return d > 20;
	}

	public void frente(final int rotate) {
		Motor.A.rotate(-rotate, true);
		Motor.C.rotate(-rotate);
	}

	public void frente() {
		frente(DEFAULTVALUE);
	}

	public void movimentar(final Ponto2D ultimoPonto, final Ponto2D p0p1p2p3) {
		double variacaoX = 2200 / (ultimoPonto.getX() - p0p1p2p3.getX());
		double variacaoY = (ultimoPonto.getY() - p0p1p2p3.getY()) * 15;
//		System.out.println("x: " + variacaoX + "y: " + variacaoY);
		int x = (int) variacaoX;
		int y = (int) (variacaoY);
		int a = x;
		int c = y - (int) (1.07*lasty) + a;
		lasty = y;
		Motor.A.rotate(a, true);
		Motor.C.rotate(c);
	}
}

