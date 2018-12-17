package MazeGeneratorProducts.Product1;

import java.util.HashMap;

import MazeGeneratorProducts.Product1.BreadthFirstSearch;
import MazeGeneratorProducts.Product1.DepthFirstSearch;
import MazeGeneratorProducts.Product1.MinimumSpanningtreeAlgorithm;
import MazeGeneratorProducts.Product3.commit3.RectangularMaze;

public class Main {

	public static void main(String[] args) {
		String outputprefix = "labyrinth";
		
		HashMap<String, Integer> optionmap = new HashMap<String, Integer>();
		optionmap.put("-s", 20);
		optionmap.put("-w", 20);
		optionmap.put("-h", 20);
		
		/* parsing command line parameters */
		for (int i = 1; i < args.length; i++) {
		    if (optionmap.get(args[i]) == optionmap.get(optionmap.size())) {
		      System.out.println("Unknown argument " + args[i] + "\n");
		    }

		    if (i + 1 == args.length) {
		      System.out.println("Missing option for argument " + args[i] + "\n");
		    }
		    int x = 0;
		    try {
		      x = Integer.parseInt(args[i + 1]);
		    } catch (Exception e) {
		      System.out.println("Invalid argument " + args[i + 1] + " for option "
		                + args[i] + "\n");
		    }
		    optionmap.put(args[i++] , x);
		  }
		
		RectangularMaze rectangularMaze;
		MinimumSpanningtreeAlgorithm algorithm = null;
		
		if (optionmap.get("-w") < 1 || optionmap.get("-h") < 1) {
			System.out.println("Invalide size " + optionmap.get("-w") + "x"
					+ optionmap.get("-h") + " for rectangular labyrinth");
		}

		System.out.println("Rectangular labyrinth of size " + optionmap.get("-w") + "x"
				+ optionmap.get("-h"));
		rectangularMaze = new RectangularMaze(optionmap.get("-w"), optionmap.get("-h"));


		switch (optionmap.get("-a")) {

		case 0: {
			System.out.println("labyrinth generation using Depth-first search");
			algorithm = new DepthFirstSearch();

			break;
		}

		case 1: {
			System.out.println("labyrinth generation using Breadth-first search");
			algorithm = new BreadthFirstSearch();

			break;
		}

		default:
			System.out.println("Unknown algorithm type " + optionmap.get("-a"));
		}

		System.out.println("Initialising graph...");
		rectangularMaze.InitialiseGraph();

		System.out.println("Generating labyrinth..."); 
		rectangularMaze.GenerateMaze(algorithm);

		rectangularMaze.PrintMazeSVG(outputprefix);
	}
}