package MazeGeneratorProducts.Product1;

import java.util.ArrayList;

public class RectangularLabyrinth {
	private int width_;
	private int height_;
	private int vertices_;
	private int startvertex_, endvertex_;
	private ArrayList<ArrayList<Pair<Integer, CellBorder>>> adjacencylist_;
		
	public RectangularLabyrinth(int width, int height) {
		vertices_ = width * height;
		startvertex_ = 0;
		endvertex_ = width * height -1; 
		width_ = width;
		height_ = height;
	}
	
	/** Proper to rectangular maze **/
	private int VertexIndex(int row, int column) {
		return row * width_ + column;
	}
	/** ************************** **/
	
	public void InitialiseGraph() {
		//Body...
	}
	
	public Tuple<Double, Double, Double, Double> GetCoordinateBounds() {
		return new Tuple<Double,Double,Double,Double>((double)0, (double)0, (double)width_, (double)height_);
	}
	
	public void GenerateLabyrinth(DepthFirstSearch algorithm) {
		ArrayList<Pair<Integer,Integer>> minimumspanningtree = algorithm.MinimumSpanningTree(vertices_,
				adjacencylist_);
		RemoveBorders(minimumspanningtree);
	}
	
	public void RemoveBorders(ArrayList<Pair<Integer,Integer>> edges) {
		// Body ...
	}
	
	public void PrintLabyrinthSVG(String outputprefix) {
		// Body...
	}
}
