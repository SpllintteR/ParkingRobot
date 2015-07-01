package src;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;


public class NXTRobot {

	private static int DEFAULTVALUE = 50;
	private static UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S4);
	private static int MOV = 700;
	private double lastAngulo;

	public boolean ehVaga() {
		int d = sensor.getDistance();
		return d > 15;
	}
	
	public int getDistancia(){
		return sensor.getDistance();
	}

	public void frente(final int rotate) {
		Motor.A.rotate(-rotate, true);
		Motor.C.rotate(-rotate);
	}

	public void frente() {
		frente(DEFAULTVALUE);
	}

	public void movimentar(final Ponto2D p1, final Ponto2D p2) throws InterruptedException {
		double angulo = 90 - encontrarAngulo(p1, p2); // em graus, ex: 45
		System.out.println("angulo : " + angulo);
		
		double xAng = angulo - lastAngulo;
		
		int diff = (int) ((-MOV * xAng) / 90);
		System.out.println("diff: " + diff);
		int x = (int) (p1.getX() - p2.getX());
		int a = x;
		int c = x - diff;
		
		lastAngulo = angulo;
		Motor.A.rotate(a, true);
		Motor.C.rotate(c);
	}

	private double encontrarAngulo(final Ponto2D p1, final Ponto2D p2){
		double x = p1.getY() - p2.getY();
		double y = p1.getX() - p2.getX();
		return  Math.atan2(y, x) * (180 / Math.PI);
	}
}

