package chap03.examples;

public class DenyLogicalOperatorExample {
	public static void main(String[] args) {
		boolean play = true;
		System.out.println(play);

		play = !play;
		System.out.println(play);

		play = !play;
		System.out.println(play);
	}
}
	