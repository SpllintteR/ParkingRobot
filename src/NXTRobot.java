public class NXTRobot {

	private static int DEFAULTVALUE = 10;

	public boolean ehVaga() {
		return false;
	}

	public void frente(final int rotate) {
		Motor.A.rotate(rotate, true);
		Motor.C.rotate(rotate);
	}

	public void frente() {
		frente(DEFAULTVALUE);
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

}

