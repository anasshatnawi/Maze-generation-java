package MazeGeneratorProducts.Product1;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch extends MinimumSpanningtreeAlgorithm {
	private List<Boolean> visited;
	private List<Integer> currentLevel;
	private List<Integer> nextLevel;
	
	@Override
	public ArrayList<Pair<Integer, Integer>> MinimumSpanningTree(int vertices, ArrayList<ArrayList<Pair<Integer,CellBorder>>> adjacencylist) {
		for (int i = 0; i < vertices; i++) {
			visited.set(i, false);
		}
		int startvertex = 0 + generator.nextInt((vertices-1)-0);
		currentLevel.add(startvertex);
		visited.set(startvertex, true);
		minimumspanningtree.clear();
		while(!currentLevel.isEmpty()) {
			for (int vertex : currentLevel) {
				for (Pair<Integer,CellBorder> edge : adjacencylist.get(vertex)) {
					int nextvertex = edge.x;
					if(nextvertex < 0 || visited.get(nextvertex))continue;
					visited.set(nextvertex, true);
					minimumspanningtree.add(new Pair<>(vertex, nextvertex));
					nextLevel.add(nextvertex);
				}
			}
			
			currentLevel.clear();
			List<Integer> tmp = currentLevel;
			currentLevel = nextLevel;
			currentLevel = tmp;
			// shuffle here	
		}	
		return minimumspanningtree;
	}
}
