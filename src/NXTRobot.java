
public class NXTRobot {

	private static int DEFAULTVALUE = 100;
	private static UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S4);
	private static int SLOWVALUE = 30;

	public boolean ehVaga() {
		return sensor.getDistance() > 30;
	}

	public void frente(final int rotate) {
		Motor.A.rotate(rotate, true);
		Motor.C.rotate(rotate);
	}

	public void frente() {
		frente(DEFAULTVALUE);
	}

	public void frenteSlow() {
		frente(SLOWVALUE);
	}

	public void reVolanteDireita() {
		Motor.C.rotate(DEFAULTVALUE, true);
		Motor.A.rotate(DEFAULTVALUE*2);
	}

	public void reVolanteReto() {
		Motor.A.rotate(DEFAULTVALUE, true);
		Motor.C.rotate(DEFAULTVALUE);
	}

	public void reVolanteEsquerda() {
		Motor.A.rotate(DEFAULTVALUE, true);
		Motor.C.rotate(DEFAULTVALUE*2);
	}

	public void movimentar(final Ponto2D ultimoPonto, final Ponto2D p0p1p2p3) {
		Motor.A.rotate((ultimoPonto.getX() - p0p1p2p3.getX()) * 10);
		Motor.A.rotate((ultimoPonto.getY() - p0p1p2p3.getY()) * 10);
	}
}

