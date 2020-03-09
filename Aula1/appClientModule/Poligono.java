
public abstract class Poligono extends Figura2D {
	
	private int base;
	private int altura;
	
	

	public Poligono(int base, int altura) {
		setBase(base);
		setAltura(altura);
		// TODO Auto-generated constructor stub
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	@Override
	public double area() {
		return getBase ()*getAltura();
	}
}


