package fydna2600.mancala;

public class Main {

	public static void main(String args[]){
		
		Board b = new Board();
		b.print();
		try {
			b.move(0);
			b.print();
			b.move(5);
			b.print();
			b.move(1);
			b.print();
			b.move(1);
			b.print();
			b.move(3);
			b.print();
			b.move(3);
			b.print();
			b.move(0);
			b.print();
			b.move(0);
			b.print();
			b.move(2);
			b.print();
			b.move(4);
			b.print();
		} catch (InvalidMove e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
