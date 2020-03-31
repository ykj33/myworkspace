package chap03.binary.logical;

public class Logical {
	public static void main(String[] args) {
		// AND &&, &
		// true && true -> true
		// true && false -> false
		// false && true -> false
		// false && false -> false

		// true & true -> true
		// true & false -> false
		// false & true -> false
		// false & false -> false
//////////////////////////////////////////	
		// OR ||, |
		// true || true -> true
		// true || false -> true
		// false || true -> true
		// false || false -> false

		// true | true -> true
		// true | false -> true
		// false | true -> true
		// false | false -> false
/////////////////////////////////////////	

		// XOR ^ 양변이 서로 다를 경우에만 true
		// true ^ true -> false
		// false ^ true -> true
		// true ^ false -> true
		// false ^ false -> false

		// NOT !
////////////////////////////////////////

		int i = 0;
		int j = 3;

		if (i == 0 && (j++) > 0) {
			System.out.println("결과 true");
		} else {
			System.out.println("결과 false");
		}
		System.out.println("j:" + j);

		if (i != 0 && (j++) > 0) { // &&는 첫 조건이 false이면 나머지 하나를 확인하지 않는다.
			System.out.println("결과 true");
		} else {
			System.out.println("결과 false");
		}
		System.out.println("j:" + j);

		if (i == 0 & (j++) > 0) {
			System.out.println("결과 true");
		} else {
			System.out.println("결과 false");
		}
		System.out.println("j:" + j);
		if (i != 0 & (j++) > 0) { // &는 첫 조건이 false여도 확인을 하고 실행한다.
			System.out.println("결과 true");
		} else {
			System.out.println("결과 false");
		}
		System.out.println("j:" + j);

		i = 0;
		j = 3;
		if (i != 0 && (j / i) > 0) { // 0으로 나눌 경우 에러가 나야 하나, 앞의 조건이 false이므로 연산 실행 X, 에러 발생 X
			System.out.println("j를 i로 나눈 값은 양수");
		}

		String s = null;
		if (s != null && s.length() > 0) { // null 에러가 일어나야 하지만 앞의 조건이 false이므로 실행시키지 않아 에러 발생 X
			System.out.println("s는 빈 스트링이 아니다.");
		}

		i = 0;
		j = 3;
		if (i == 0 || (j++) > 0) { // || 앞이 true일 경우 뒤를 판단하지 않고 진행, 어차피 true이기 때문
			System.out.println("값은 ture");
		} else {
			System.out.println("값은 false");
		}
		System.out.println(j);
		if (i == 0 | (j++) > 0) { // | 앞이 true여도 일단 진행
			System.out.println("값은 ture");
		} else {
			System.out.println("값은 false");
		}
		System.out.println(j);
	}
}
