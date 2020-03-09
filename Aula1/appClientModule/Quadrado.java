
public class Quadrado extends Poligono implements Diagonal {

	public Quadrado(int lado) {
		super(lado, lado);
		
	}

	@Override
	public double calculaDiagonal() {
		return super.getBase() * Math.sqrt(2);
	}
}
