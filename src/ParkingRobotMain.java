public class ParkingRobotMain {

	private static int MOVIMENTOVAGA = 10;
	private static int MOVIMENTONAOVAGA = 100;
	private static int TAMANHOROBO = 200;
	private static int MOVIMENTOPORTAMANHO = TAMANHOROBO / MOVIMENTOVAGA;
	private static int PROFUNDIDADEVAGA = 200;
	private static int MOVIMENTO1 = 50;
	private static int MOVIMENTOPROFUNDIDADEVAGA = PROFUNDIDADEVAGA / MOVIMENTO1;

	public static void main(final String[] args) {
		NXTRobot robo = new NXTRobot();
		int espacoLivre = 0;
		while(!robo.ehVaga()){
			robo.frente(MOVIMENTONAOVAGA);
		}
		while(robo.ehVaga()){
			robo.frente(MOVIMENTOVAGA);
			espacoLivre += MOVIMENTOVAGA;
		}
		int[] movements = encontrar3Pontos(espacoLivre);
		for(int i = 0; i < movements[0]; i++){
			robo.reVolanteDireita();
		}
		for(int i = 0; i < movements[1]; i++){
			robo.reVolanteReto();
		}
		for(int i = 0; i < movements[2]; i++){
			robo.reVolanteEsquerda();
		}
		for(int i = 0; i < movements[3]; i++){
			robo.frente();
		}
	}

	private static int[] encontrar3Pontos(final int espacoTotal){
		int[] ret = new int[3];
		ret[0] = 5;
		ret[1] = 5;
		ret[2] = 1;
		//		for (float t = 0.0f; t < 1.001f; t = t + 0.05f) {
		//			Ponto2D p0p1 = calculaPontoSpline(pontos[0], pontos[1], t);
		//			Ponto2D p1p2 = calculaPontoSpline(pontos[1], pontos[2], t);
		//			Ponto2D p2p3 = calculaPontoSpline(pontos[2], pontos[3], t);
		//
		//			Ponto2D p0p1p2 = calculaPontoSpline(p0p1, p1p2, t);
		//			Ponto2D p1p2p3 = calculaPontoSpline(p1p2, p2p3, t);
		//
		//			Ponto2D p0p1p2p3 = calculaPontoSpline(p0p1p2, p1p2p3, t);
		//			gl.glVertex2d(p0p1p2p3.getX(), p0p1p2p3.getY());
		//		}
		return ret;
	}

}
