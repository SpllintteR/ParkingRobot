import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;


public class NXTRobot {

	private static int DEFAULTVALUE = 50;
	private static int CURVAVALUE = 10;
	private static UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S4);

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
		double variacaoX = (ultimoPonto.getX() - p0p1p2p3.getX()) * 5;
		double variacaoY = (ultimoPonto.getY() - p0p1p2p3.getY()) * 10;
		int x = (int) variacaoX;
		int y = (int) (variacaoX - variacaoY);
		Motor.C.rotate(x, true);
		Motor.A.rotate(y);
	}
}

