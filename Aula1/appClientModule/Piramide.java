
public class Piramide extends Figura3D {
	
	private int areaBase;
	private int altura;	
	
	public Piramide(int areaBase, int altura) {
		this.areaBase = areaBase;
		this.altura = altura;
	}
	
	public int getAreaBase() {
		return areaBase;
	}

	public void setAreaBase(int areaBase) {
		this.areaBase = areaBase;
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
		return 1/3 * areaBase * altura;
	}

}
