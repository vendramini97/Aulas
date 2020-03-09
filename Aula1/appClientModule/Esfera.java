
public class Esfera extends Figura3D {
	
	private int raio;
	
	public Esfera(int raio) {
		this.raio = raio;
	}
	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	@Override
	public double volume() {
		// TODO Auto-generated method stub
		return 4/3 * Math.PI * (Math.pow(raio, 3));
	}

}
