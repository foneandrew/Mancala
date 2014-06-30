package fydna2600.mancala;

import java.util.ArrayList;
import java.util.HashSet;

public class ScoreHole extends Hole {
	private int side;
	
	public ScoreHole(int side){
		this.side = side;
		pebbles = new ArrayList<Pebble>();
	}

	@Override
	public boolean move() throws InvalidMove {
		throw new InvalidMove("Cannot move pebbles from the score holes!");
	}

	@Override
	public boolean drop(Pebble p) {
		pebbles.add(p);
		return false;
	}
	
	public void dropAll(ArrayList<Pebble> drop){
		pebbles.addAll(drop);
	}

	@Override
	public Hole getOpposite() throws InvalidMove {
		throw new InvalidMove("Scoring hole does not have an opposite");
	}

	@Override
	public void setOpposite(Hole h) {
		//do nothing
	}
	
	public boolean equals(Object o){
		if (o != null && o instanceof ScoreHole){
			return ((ScoreHole) o).side == this.side;
		}
		return false;
	}

}
