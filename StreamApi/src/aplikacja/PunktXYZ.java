package aplikacja;

public class PunktXYZ {
	private float x;
	private float y;
	private float z;
	
	public PunktXYZ(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public String toString() {
		return "PunktXYZ [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	public float getZ() {
		return z;
	}
	public void setZ(float z) {
		this.z = z;
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
}
