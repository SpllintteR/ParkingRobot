

public class NXTRobot {

	private static int DEFAULTVALUE = 50;
	private static int CURVAVALUE = 10;
	private static UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S4);
	private final int lasty = 0;
	private static int MOV = 350;

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

	public void movimentar(final Ponto2D p1, final Ponto2D p2) {
		double angulo = encontrarAngulo(p1, p2); // em graus, ex: 45
		double diff = (-MOV * angulo) / 90;
		Motor.A.rotate(MOV, true);
		Motor.C.rotate(diff);
	}

	private double encontrarAngulo(final Ponto2D p1, final Ponto2D p2){
		double x = p2.getY() - p1.getY();
		double y = p2.getX() - p1.getX();
		return  Math.atan2(y, x) * (180 / Math.PI);
	}
}

