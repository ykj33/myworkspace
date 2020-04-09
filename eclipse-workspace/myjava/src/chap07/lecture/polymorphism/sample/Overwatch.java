package chap07.lecture.polymorphism.sample;

import java.util.Scanner;

public class Overwatch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("캐릭터 > ");
		String select = scanner.nextLine();
		
		// 인스턴스에 상관없이 상위 클래스의 관점으로 바라보면
		Hero hero = getHero(select);
		// 하나의 행동으로 여러개의 형태가 나올 수 있음(다형성)
		hero.onclick();
	}

	private static Hero getHero(String select) {
		if (select.equals("1")) {
			// Hanzo는 Hero를 상속받았기에 Hero 타입으로 반환 가능
			return new Hanzo();
		} else {
			// Mercy는 Hero를 상속받았기에 Hero 타입으로 반환 가능
			return new Mercy();
		}

	}
}
