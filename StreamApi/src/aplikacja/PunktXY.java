package aplikacja;

public class PunktXY {
	private float x;
	private float y;
	
	public PunktXY(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public String toString() {
		return "PunktXY [x=" + x + ", y=" + y + "]";
	}
	
}

