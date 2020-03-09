
public class Cilindro extends Figura3D {
	
	private int raio;
	private int altura;
	
	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	@Override
	public double volume() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(raio, 2) * altura;
	}

}
