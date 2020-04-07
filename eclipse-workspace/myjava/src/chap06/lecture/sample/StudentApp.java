package chap06.lecture.sample;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
//		Student s1 = new Student("a", 50, 20, 60);
//		Student s2 = new Student("b", 40, 77, 92);
//
//		System.out.println("최대값 : " + s1.getMaxScore());
//		System.out.println("평균 : " + s1.getAvg());
//
//		System.out.println("최대값 : " + s2.getMaxScore());
//		System.out.println("평균 : " + s2.getAvg());

		Student[] students = new Student[100];
		int size = 0;

		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.학생추가 | 2. 통계 | 3. 종료");
			System.out.println("-------------------------------------");
			System.out.print("선택 > ");
			// 입력받을 준비
			String menu = scanner.nextLine();

			switch (menu) {
			//입력받은 값에 따라 행동
			case "1":
				System.out.println("이름");
				String name = scanner.nextLine();
				System.out.println("국어>");
				int korean = Integer.parseInt(scanner.nextLine());
				System.out.println("영어>");
				int english = Integer.parseInt(scanner.nextLine());
				System.out.println("수학>");
				int math = Integer.parseInt(scanner.nextLine());
				// 학생의 수를 입력하여 새로운 객체 생성, 0번 인덱스를 가진 배열부터 생성해서 점차 증가하며 생성
				students[size] = new Student(name, korean, english, math);
				size++;
				break;
				
			case "2":
				System.out.println("이름\t국어\t영어\t수학\t최고\t평균");
				for (int i = 0; i < size; i++) {
					System.out.println(students[i].name + " \t" + students[i].korean + " \t" + students[i].english
							+ " \t" + students[i].math + " \t" + students[i].getMaxScore() + " \t"
							+ students[i].getAvg());
				}
				break;
				
			case "3":
				System.out.println("프로그램을 종료합니다.");
				run = false;

			default:
				break;
			}

		}
	}
}
