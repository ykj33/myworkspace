package chap02.datatype;

public class Double1 {
	public static void main(String[] args) {
		// 8byte 크기
		// 부동소수점 (floating point) (ieee 754)
		// 최대값(1.7976931348623157E308) == (1.79 * 10^308) -를 붙이면 가장 작은 음수
		System.out.println(Double.MAX_VALUE);
		// 최소값 음수가 아니다. (4.9E-324) == (4.9*10^-324) 굉장히 0에 가깝다. -를 떼면 가장 0과 가까운 수
		System.out.println(Double.MIN_VALUE);

		double d = 3.14;
		d = 3.14E-2;
		System.out.println(d);
	}
}
