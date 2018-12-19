package MazeGeneratorProducts.Product1;

import java.util.ArrayList;
import java.util.Random;

public abstract class MinimumSpanningtreeAlgorithm {
	
	protected ArrayList<Pair<Integer, Integer>> minimumspanningtree;
	protected Random generator = new Random();
	
	public MinimumSpanningtreeAlgorithm() {
	}
	
	public abstract ArrayList<Pair<Integer, Integer>> MinimumSpanningTree(int vertices, ArrayList<ArrayList<Pair<Integer,CellBorder>>> adjacencylist);
	
}
