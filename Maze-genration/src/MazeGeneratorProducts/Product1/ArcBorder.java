package MazeGeneratorProducts.Product1;

public class ArcBorder extends CellBorder {
	protected double cx_;
	protected double cy_;
	protected double r_;
	protected double theta1_;
	protected double theta2_;
	
	public ArcBorder(double cx, double cy, double r, double theta1, double theta2) {
		cx_ = cx;
		cy_ = cy;
		r_ = r;
		theta1_ = theta1;
		theta2_ = theta2;
	}
	
	public String GnuplotPrintString() {
		return "";
	}
	
	public String SVGPrintString() {
		return "";
	}
}
