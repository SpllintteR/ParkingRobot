public class ParkingRobotMain {

	private static int tetoVagaPequena = 30;
	
	public static void main(final String[] args) {
		NXTRobot robo = new NXTRobot();
		int espacoLivre = 0;
//		while(!robo.ehVaga()){
//			robo.frenteSlow();
//		}
//		while(robo.ehVaga()){
//			robo.frenteSlow();
//			espacoLivre++;
//		}
//		if(espacoLivre < tetoVagaPequena){
			int[] movements = encontrar4Pontos(espacoLivre);
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
//		}
			
	}

	private static int[] encontrar4Pontos(final int espacoTotal){
		//TODO - apartir do espacoTotal bolar uma formula de descobrir os numeros pra `estacionar corretamente`
		/*https://researchbank.rmit.edu.au/eserv/rmit:24157/n2006044655.pdf
		 * primeiro ponto eh o ponto da roda traseira do robo, que deve estar alinhado com o fim do obstaculo
		 * segundo ponto eh o primeiro ponto - metade do tamanho da vaga
		 * terceiro ponto eh o segundo ponto + largura da vaga
		 * quarto ponto eh o terceiro ponto - metade do tamanho da vaga
		 * aplicar formula do splines, N2-6 de CG
		 */
		int[] ret = new int[4];
		ret[0] = 3;
		ret[1] = 3;
		ret[2] = 3;
		ret[3] = 1;
		return ret;
	}

}
