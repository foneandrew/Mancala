package fydna2600.mancala;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * the hole contains zero or more pebbles.
 * can be either a score hole, or just a normal one
 * @author Andy Fone
 *
 */
public abstract class Hole {
	private Hole next;
	protected ArrayList<Pebble> pebbles;
	private Player player;
	
	public Player getPlayer(){
		return player;
	}
	
	/**
	 * returns the number of pebbles in the hole
	 * 
	 * @return integer amount of pebbles in the hole
	 */
	public int count(){
		return pebbles.size();
	}
	
	/**
	 * moves the pebbles into the following holes,
	 * returns true if the player gets another turn
	 * 
	 * @return a hash set containing all the pebbles
	 */
	public abstract boolean move() throws InvalidMove;
	
	/**
	 * adds a pebble to the hole, returning true if the
	 * hole was empty
	 * 
	 * @param p	The pebble to be placed
	 * @return	returns true if the hole was empty
	 */
	public abstract boolean place(Pebble p);
	
	/**
	 * gets the hole on the board that is opposite to this one
	 * 
	 * @return the opposite hole
	 */
	public abstract Hole getOpposite() throws InvalidMove;
	
	/**
	 * returns true if the hole contains no pebbles 
	 *
	 * @return      returns true if the hole contains no pebbles
	 */
	public boolean isEmpty(){
		return pebbles.size() == 0;
	}
	
	/**
	 * returns the hole that comes after this one on the board
	 * 
	 * @return the next Hole object
	 */
	public Hole getNext(){
		return next;
	}
	
	protected ArrayList<Pebble> getAll(){
		return pebbles;
	}
	
	public void setNext(Hole h){
		next = h;
	}
	
	public abstract void setOpposite(Hole h);
}
