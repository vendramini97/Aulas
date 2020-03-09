public class Losango extends Poligono {

	public Losango(int baseMaior, int baseMenor) {
		super(baseMaior, baseMenor);
	}
	
	@Override
	public double area() {
		return (getBase() * getAltura()) / 2;
	}
}
