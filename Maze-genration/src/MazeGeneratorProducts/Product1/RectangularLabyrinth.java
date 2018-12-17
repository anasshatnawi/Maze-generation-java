package MazeGeneratorProducts.Product1;

public class RectangularLabyrinth extends Labyrinth {

	private int width_;
	private int height_;
	
	public RectangularLabyrinth(int width, int height) {
		super(width * height, 0, width * height -1);
		width_ = width;
		height_ = height;
	}
	
	private int VertexIndex(int row, int column) {
		return row * width_ + column;
	}
	
	public void InitialiseGraph() {
		super.InitialiseGraph();
		//Body ...
	}
	
	@Override
	protected Tuple<Double, Double, Double, Double> GetCoordinateBounds() {
		return new Tuple<Double, Double, Double, Double>((double) 0,(double) 0,(double) width_, (double) height_);
	}
}
