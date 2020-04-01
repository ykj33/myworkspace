package chap04.switchcase;

public class Type {

	public static void main(String[] args) {
		// int, byte, short, char, String
		// Enum, Integer, Byte, Short, Char
		
		String a = "";
		
		switch (a) {
		case "":
			System.out.println("사용 가능");
			break;

		default:
			break;
		}

	}

}
