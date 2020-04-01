package codingbat;

public class StringEx1 {
	public static void main(String[] args) {
		// charAt(int index) 해당 인덱스에 해당하는 캐릭터를 반환한다.
		String s1 = "samsung";
		String s2 = "apple";

		char c = s1.charAt(0);
		System.out.println(c);
		System.out.println(s1.charAt(0));
		System.out.println(s2.charAt(0));
		System.out.println(s1.charAt(1));
		System.out.println(s1.charAt(6));
		System.out.println(s2.charAt(4));

//		System.out.println(s1.charAt(7)); // 배열의 범위를 넘었기 때문에 exception이 발생하여 프로그램이 정지

		// length()
		System.out.println("길이");
		int s1Length = s1.length();
		int s2Length = s2.length();
		System.out.println(s1Length);
		System.out.println(s2Length);

		// substring(int begin, int end)
		// 시작 인덱스부터 마지막 인덱스에 해당하는 String 반환
		String sub1 = s1.substring(1, 3); // 첫번째는 포함, 두번째는 포함X
		System.out.println(sub1);
		String s3 = "asdfasdgadgsadfzcvasgeqrygqehedsgad";
		int s3Length = s3.length();
		String sub3 = s3.substring(s3Length - 2, s3Length); // 마지막 인덱스는 포함하지 않기에 length까지 가야 한다.
		System.out.println(sub3);

		// substring(int begin) 시작위치부터 끝까지 다 뽑는다.
		sub3 = s3.substring(s3Length - 2);
		System.out.println(sub3);

		// indexOf(String s) 해당 문자가 어디서부터 시작되는지 인덱스번호를 알려주는 메소드
		s1 = "자바스크립트";
		int i = s1.indexOf("스크립트");
		System.out.println(i);

		s1 = "990000-1234-56-7"; // 해당 문자열이 여러개 있다면 무조건 첫번 째 나오는 것으로 반환
		i = s1.indexOf("-");
		System.out.println(i);
		i = s1.lastIndexOf("-"); // 뒤에서부터 찾는다.
		System.out.println(i);

		// replace(String old, String new); 새로운 문자열로 바꿈
		s1 = "나는 아이폰, 아이폰 있다"; // 여러개 있을 시 모두 다 바꾸어줌
		String news1 = s1.replace("아이폰", "갤럭시");
		System.out.println(news1);
		System.out.println(s1); // 원본이 바뀌는 것은 아님

		// toLowerCase(), toUpperCase() 원본이 바뀌는 것은 아니다.
		s1 = "javaSCRIPT";
		String ls1 = s1.toLowerCase(); // 모두 소문자로 변환
		System.out.println(ls1);
		System.out.println(s1);

		String us1 = s1.toUpperCase(); // 모두 대문자로 변환
		System.out.println(us1);
		System.out.println(s1);

		// equals(String s)
		s1 = "자바";
		s2 = "자바";
		System.out.println(s1.equals(s2));
		s1 = "자바";
		s2 = "JAVA";
		System.out.println(s1.equals(s2));
		s1 = "자바";
		s2 = " 자바 ";
		System.out.println(s1.contentEquals(s2));
		
		//trim();
		s1 = " 자 바 ";
		String ns1 = s1.trim(); // 양쪽 끝에 있는 공백만 제거, 가운데는 제거 X, 원본이 바뀌는 것은 아님
		System.out.println(ns1);
		System.out.println(s1);
	}
}
