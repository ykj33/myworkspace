package chap03.binary.arithmetic;

public class InfinityNaN {
	public static void main(String[] args) {
		int i = 10;
		int j = 0;

//		int r = i / j;

		double d = 10;
		double e = 0.0;

		double f = d / e;
		System.out.println(f); // Infinity

		f = d / -0.0;
		System.out.println(f); // -Infinity

		f = f + 1;
		System.out.println(f);
		f = f - 1;
		System.out.println(f);

		f = d % 0.0;
		System.out.println(f); // 나머지를 구할 수 없기에 NaN
		f = f + 1;
		System.out.println(f);
		f = f / f;
		System.out.println(f);

		f = d / 0.0;
		boolean isInf = Double.isInfinite(f);
		System.out.println(isInf);

		f = d % 0.0;
		boolean isNan = Double.isNaN(f);
		System.out.println(isNan);
	}
}
