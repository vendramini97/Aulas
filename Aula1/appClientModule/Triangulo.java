
public class Triangulo extends Poligono {

	public Triangulo(int base, int altura) {
		super(base, altura);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double area() {
		return super.area()/2;
	}

}
