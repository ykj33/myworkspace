package chap02.datatype;

public class Integer1 {
	public static void main(String[] args) {
		// 4byte 크기
		// -2147483648 ~ 2147483647

		int i;
		i = 2147483647;
//		i = 2147483648;
		System.out.println(i);

		i++;
		System.out.println(i);

		i = 2_147_483_647; // 읽기 힘드니까 3자리마다 _를 넣어도 된다.
		i = 21_4748_3647; // 어디에 넣어도 상관없다.
		i = 2_148_65004; // 어디에 넣어도 상관없다.

		i = 0765; // 8진법으로 저장
		System.out.println(i);
		i = 0xACCF;// 16진법으로 저장
		System.out.println(i);
	}
}
