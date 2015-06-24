public class ParkingRobotMain {

	private static int move = 50;
	private static int size = 75;

	public static void main(final String[] args) throws InterruptedException {
		NXTRobot robo = new NXTRobot();
		int espacoLivre = 0;
		while(!robo.ehVaga()){
			robo.frente();
		}
		while(robo.ehVaga()){
			robo.frente();
			espacoLivre += move;
		}

		Ponto2D p0 = new Ponto2D(espacoLivre, espacoLivre / 3);
		Ponto2D p1 = new Ponto2D(espacoLivre / 2, espacoLivre / 3);
		Ponto2D p2 = new Ponto2D(espacoLivre / 2, 0);
		Ponto2D p3 = new Ponto2D(0, 0);
		Ponto2D ultimoPonto = p0;
		for (float t = 0.05f; t < 1.001f; t = t + 0.05f) {
			System.out.println(t);
			Ponto2D p0p1 = calculaPontoSpline(p0, p1, t);
			Ponto2D p1p2 = calculaPontoSpline(p1, p2, t);
			Ponto2D p2p3 = calculaPontoSpline(p2, p3, t);

			Ponto2D p0p1p2 = calculaPontoSpline(p0p1, p1p2, t);
			Ponto2D p1p2p3 = calculaPontoSpline(p1p2, p2p3, t);

			Ponto2D p0p1p2p3 = calculaPontoSpline(p0p1p2, p1p2p3, t);
			System.out.println("movimentar");
			robo.movimentar(ultimoPonto, p0p1p2p3);
			ultimoPonto = p0p1p2p3;
		}
	}

	private static Ponto2D calculaPontoSpline(final Ponto2D ponto1, final Ponto2D ponto2, final float t) {
		double x = ponto1.getX() + ((ponto2.getX() - ponto1.getX()) * t);
		double y = ponto1.getY() + ((ponto2.getY() - ponto1.getY()) * t);

		return new Ponto2D(x, y);
	}
}
