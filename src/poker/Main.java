package poker;

public class Main {

	public static void main(String[] args) throws HandSizeException, CardException, EmptyDeckException {
		// TODO Auto-generated method stub
		//i added a line
		Poker p1 = new Poker(5); 
		Poker p2 = new Poker(7);
		p1.setNumberOfHandsToPlay(10000000);
		p1.playAndDisplay();
		System.out.println("7 Card");
		p2.setNumberOfHandsToPlay(10000000);
		p2.playAndDisplay();
	}
}
