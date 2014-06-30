package fydna2600.mancala;

import java.util.ArrayList;
import java.util.HashSet;

public class ScoreHole extends Hole {
	
	public ScoreHole(){
		pebbles = new ArrayList<Pebble>();
	}

	@Override
	public boolean move() throws InvalidMove {
		throw new InvalidMove("Cannot move pebbles from the score holes!");
	}

	@Override
	public boolean place(Pebble p) {
		pebbles.add(p);
		return false;
	}

	@Override
	public Hole getOpposite() throws InvalidMove {
		throw new InvalidMove("Scoring hole does not have an opposite");
	}

	@Override
	public void setOpposite(Hole h) {
		//do nothing
	}

}
