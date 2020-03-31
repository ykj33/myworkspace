package chap03.ternary;

public class Conditional {
	public static void main(String[] args) {
		// 1항 ? 2항 : 3항 -> 2항 또는 3항이 결과

		// 1항이 true이면 2항
		// 1항이 false이면 3항

		int i = (true ? 3 : 4);
		System.out.println(i);
		i = (false ? 3 : 4);
		System.out.println(i);
	}
}
