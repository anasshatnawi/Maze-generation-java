package MazeGeneratorProducts.Product1;

import java.util.List;

public class LineBorder extends CellBorder{
	protected double x1_;
	protected double y1_;
	protected double x2_;
	protected double y2_;
	protected List<String> xy_;
	
	public LineBorder(double x1, double y1, double x2, double y2) {
		x1_ = x1;
		y1_ = y1;
		x2_ = x2;
		y2_ = y2;
	}
	
	public LineBorder(Tuple<Double, Double, Double, Double> xy) {
		x1_ = xy.a;
		y1_ = xy.b;
		x2_ = xy.c;
		y2_ = xy.d;
	}
	
	public String GnuplotPrintString() {
		return "";
	}
	
	public String SVGPrintString() {
		return "";
	}
	
			
}