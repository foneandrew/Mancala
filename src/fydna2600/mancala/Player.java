package fydna2600.mancala;

public class Player {
	public enum pColor {DARK, LIGHT};
	private pColor col;
	
	public Player(pColor c){
		col = c;
	}
	
	public pColor getColor(){
		return col;
	}
}
