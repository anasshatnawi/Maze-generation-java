package MazeGeneratorProducts.Product1;

import java.util.ArrayList;
import java.util.Random;

public class DepthFirstSearch {
	protected ArrayList<Pair<Integer, Integer>> minimumspanningtree;
	protected Random generator = new Random();
	
	private ArrayList<Boolean> visited;
	
	/** Proper to depthfirstsearch **/
	public ArrayList<Pair<Integer, Integer>> MinimumSpanningTree(int vertices, ArrayList<ArrayList<Pair<Integer, CellBorder>>> adjacencylist) {
		minimumspanningtree.clear();
		visited = new ArrayList<Boolean>(vertices);
		DFS(getRandomIntInclusive(0,vertices - 1),
				adjacencylist);
		return minimumspanningtree;
	}
	/** ************************** **/
	
	/** Proper to depthfirstsearch **/
	private void DFS(int vertex, ArrayList<ArrayList<Pair<Integer,CellBorder>>> adjacencylist) {
		//Body...
		visited.set(vertex, true);
		ArrayList<Integer> nodeorder = new ArrayList<>(adjacencylist.get(vertex).size());
		makeSequence(nodeorder, 0);
		// shuffle(nodeorder.begin(), nodeorder.end(), generator);

	}

	int getRandomIntInclusive(int min,int max) {
		min = (int) Math.ceil(min);
		max = (int) Math.floor(max);
		return (int) (Math.floor(Math.random() * (max - min +1)) + min);
	}

	void  makeSequence(ArrayList<Integer> l, int value) {
		for (int i=0; i < l.size(); i++) {
			l.set(i, value);
			value++;
		}  
	}
}
