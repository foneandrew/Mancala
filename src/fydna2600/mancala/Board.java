package fydna2600.mancala;

import java.util.ArrayList;

/**
 * the board contains all the holes
 * 
 * @author Andy
 *
 */
public class Board {
	private ArrayList<Hole> p1, p2;
	private boolean p1Turn;

	public Board(){
		/* 	initialize rows:
		 *  +---+---+---+---+---+---+----------+
		 *  | 0 | 1 | 2 | 3 | 4 | 5 | 6(score) |
		 *  +---+---+---+---+---+---+----------+
		 */
		p1 = new ArrayList<Hole>();
		p2 = new ArrayList<Hole>();
		//create holes
		for(int i = 0; i < 6; i++){
			p1.add(new NormalHole());
			p2.add(new NormalHole());
		}
		p1.add(new ScoreHole());
		p2.add(new ScoreHole());
		//link the holes and set the opposites
		for (int i = 0; i < 6; i++){
			//links
			p1.get(i).setNext(p1.get(i+1));
			p2.get(i).setNext(p2.get(i+1));
			//opposites
			p1.get(i).setOpposite(p2.get(5 - i));
			p2.get(i).setOpposite(p1.get(5 - i));
		}
		p1.get(6).setNext(p2.get(0));
		p2.get(6).setNext(p1.get(0));
		//set player 1s turn
		p1Turn = true;
	}
	
	public void move(int h) throws InvalidMove{
		try{
			if (h > 5 || h < 0) throw new InvalidMove("Invalid hole");
			ArrayList<Hole> hole;
			if (p1Turn) hole = p1;
			else hole = p2;
			System.out.print("about to move pebbles:\n");
			//move the pieces from the hole and swap turns if necessary
			if (!hole.get(h).move()) p1Turn = !p1Turn;
			System.out.print("moved pebbles\n");
		} catch (InvalidMove m){
					
		}
	}
	
	/**
	 * prints out the board in text format
	 * 
	 * 	   [p1]  [5] [4] [3] [2] [1] [0]
	 * 	+-------+---+---+---+---+---+---+-------+
	 * 	|		| 6 | 5 | 4 | 3 | 2 | 1 |		|
	 * 	| score +---+---+---+---+---+---+ score |
	 * 	|		| 1 | 2 | 3 | 4 | 5 | 6 |		|
	 * 	+-------+---+---+---+---+---+---+-------+
	 *           [0] [1] [2] [3] [4] [5]   [p2]
	 * 
	 */
	public void print(){
		System.out.print("   [p1]  [5] [4] [3] [2] [1] [0]\n");
		System.out.print("+-------+---+---+---+---+---+---+-------+\n");
		System.out.print("|       | " + p1.get(5).count() + " | " + p1.get(4).count() + " | " + p1.get(3).count() + " | "
				+ p1.get(2).count() + " | " + p1.get(1).count() + " | " + p1.get(0).count() + " |       |\n");
		System.out.print("+   " + p1.get(6).count() + "   +---+---+---+---+---+---+   " + p2.get(6).count() + "   +\n");
		System.out.print("|       | " + p2.get(0).count() + " | " + p2.get(1).count() + " | " + p2.get(2).count() + " | "
				+ p2.get(3).count() + " | " + p2.get(4).count() + " | " + p2.get(5).count() + " |       |\n");
		System.out.print("+-------+---+---+---+---+---+---+-------+\n");
		System.out.print("         [0] [1] [2] [3] [4] [5]   [p2]\n\n");
	}

}
