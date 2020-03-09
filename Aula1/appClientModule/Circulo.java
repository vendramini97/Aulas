public class Circulo extends Figura2D {

	private int raio;
	
	public Circulo(int raio) {
		this.raio = raio;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}
	
	@Override
	public double area() {
		return Math.PI * (Math.pow(raio, 2));
	}
}