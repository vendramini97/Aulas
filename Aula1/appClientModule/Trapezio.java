public class Trapezio extends Poligono {

	private int baseMenor;
	private int lado;
	
	public Trapezio(int baseMaior, int altura, int baseMenor, int lado) {
		super(baseMaior, altura);
		this.baseMenor = baseMenor;
		this.lado = lado;
	}

	public int getBaseMenor() {
		return baseMenor;
	}

	public void setBaseMenor(int baseMenor) {
		this.baseMenor = baseMenor;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}
	
	@Override
	public double area() {
		return ((getBase() * baseMenor) * getAltura()) / 2;
	}
}
