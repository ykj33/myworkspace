package chap05.enumType;

public class EnumMethodsSample {
	public static void main(String[] args) {
		Language l1 = Language.ENGLISH;
		Language l2 = Language.ENGLISH_UK;
		System.out.println(l1 instanceof Enum);
		System.out.println(l1.name());
		System.out.println(l1.ordinal());
		System.out.println(l1.compareTo(l2));
		Language l3 = Language.valueOf("CHINESE");
		System.out.println(l3);
		Language[] langs = Language.values();
		for (Language lang : langs) {
			System.out.println(lang);
		}
	}
}
