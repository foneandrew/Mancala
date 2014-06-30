package fydna2600.mancala;

import java.util.ArrayList;
import java.util.HashSet;

public class NormalHole extends Hole {
	private Hole opposite;
	private ScoreHole score;
	
	public NormalHole(){
		//Initialize hole and fill with 4 pebbles
		pebbles = new ArrayList<Pebble>();
		pebbles.add(new Pebble());
		pebbles.add(new Pebble());
		pebbles.add(new Pebble());
		pebbles.add(new Pebble());
		score = null;
	}

	@Override
	public boolean drop(Pebble p) {
		pebbles.add(p);
		return pebbles.size() == 1;
	}

	@Override
	public Hole getOpposite() throws InvalidMove{
		return opposite;
	}

	@Override
	public boolean move() throws InvalidMove{
		if (isEmpty()) throw new InvalidMove("Cannot move, hole is empty!");
		Hole h = this;
		System.out.print("inside the hole to move the pebbles:\n");
		while (!isEmpty()){
			h = h.getNext();
			//check if trying to drop into opponents scorehole
			if (h instanceof ScoreHole && !h.equals(getScoreHole())){
				System.out.print("skipping opponents hole\n");
				continue;
			}
			//TODO get random pebble
			Pebble p = pebbles.remove(0);
			System.out.print("got a pebble\n");
			
			//check if moving the final piece
			if (isEmpty()){
				System.out.print("(final peice)\n");
				// check if hole is empty
				if (h instanceof NormalHole && h.isEmpty()){
					System.out.print("hole is empty\n");
					//check if opposite hole is empty
					if (!h.getOpposite().isEmpty()){
						System.out.print("opposite hole is not empty\n");
						//get opposites pebbles
						ArrayList<Pebble> dump = h.getOpposite().getAll();
						//find score hole
						h = getScoreHole();
						System.out.print("found the score hole\n");
						//place the pebbles in the players score hole
						for (Pebble pb : dump){
							h.drop(pb);
						}
						dump.clear();
						h.drop(p);
						return false;
					}
				}
			}
			System.out.print("not empty hole + " + h.count() + "\n");
			//place each pebble from this hole into the holes after it
			
			System.out.print("have next hole\n");
			h.drop(p);
		}
		//check if get an extra move:
		if (h instanceof ScoreHole) return true;
		return false;
	}

	/**
	 * returns the scoring hole for this hole if available
	 * if not; it finds it
	 * 
	 * @return the ScoringHole that this hole will be using
	 */
	private ScoreHole getScoreHole(){
		if (score == null){
			Hole h = this;
			while (!(h instanceof ScoreHole)){
				h = h.getNext();
			}
			score = (ScoreHole) h;
		}
		 return score;
	}
	
	@Override
	public void setOpposite(Hole h) {
		opposite = h;
		
	}
	
	

}
