package MazeGeneratorProducts.Product1;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		String outputprefix = "labyrinth";
		
		HashMap<String, Integer> optionmap = new HashMap<String, Integer>();
		optionmap.put("-m", 0);
		optionmap.put("-s", 20);
		optionmap.put("-w", 20);
		optionmap.put("-h", 20);
		optionmap.put("-t", 0);
		
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
		
		DepthFirstSearch depthFirstSearch;
		Labyrinth labyrinth = null;
		
		switch (optionmap.get("-m")) {
		case 0: {
			if (optionmap.get("-w") < 1 || optionmap.get("-h") < 1) {
				System.out.println("Invalide size " + optionmap.get("-w") + "x"
						+ optionmap.get("-h") + " for rectangular labyrinth");
			}

			System.out.println("Rectangular labyrinth of size " + optionmap.get("-w") + "x"
					+ optionmap.get("-h"));
			labyrinth = new RectangularLabyrinth(optionmap.get("-w"), optionmap.get("-h"));

			break;
		}

		case 1: {
			if (optionmap.get("-s") < 1) {
				System.out.println("Invalide size " + optionmap.get("-s")
						+ " for circular labyrinth");
			}
			System.out.println("Circular labyrinth of size " + optionmap.get("-s"));
			labyrinth = new CircularLabyrinth(optionmap.get("-s"));

			break;
		}

		default:
			System.out.println("Unknown labyrinth type " + optionmap.get("-m"));
		}

		System.out.println("Labyrinth generation using Depth-first search"); 
		depthFirstSearch = new DepthFirstSearch();

		System.out.println("Initialising graph..."); 
		labyrinth.InitialiseGraph();

		System.out.println("Generating labyrinth..."); 
		labyrinth.GenerateLabyrinth(depthFirstSearch);

		if (optionmap.get("-t") == 0) {
			System.out.println("Rendering maze to '" + outputprefix + ".svg'...");
			labyrinth.PrintLabyrinthSVG(outputprefix);
		} else {
			System.out.println("Exporting maze plotting parameters to '" + outputprefix
					+ ".plt' ...");
			labyrinth.PrintLabyrinthPNG(outputprefix);
			/*System.out.println("Rendering maze to '" + outputprefix
					+ ".png' using gnuplot...");
			system(("gnuplot '" + outputprefix + ".plt'").c_str());*/
		}
	}

}
