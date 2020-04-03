package chap05.exercises;

import java.util.Scanner;

public class Exercise09 {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수 입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("--------------------------------------------------------------");
			System.out.print("<선택> ");

			int selectNo = scanner.nextInt();
			
			if ((selectNo == 1)) {
				System.out.print("학생 수 : ");
//				int input = scanner.nextInt();
//				stuNo = input;
//				System.out.println(stuNo);
				studentNum = scanner.nextInt();
				scores = new int[studentNum];

			} else if (selectNo == 2) {
//				System.out.println("점수 : ");
//				int inputGrade = scanner.nextInt();
//				gradeList = new int[stuNo];
//				for (int i = 0; i < gradeList.length; i++) {
//					gradeList[i] = inputGrade;
				for (int i = 0; i<scores.length; i++) {
					System.out.println("scores[" + i + "]: ");
					scores[i] = scanner.nextInt();

				}
			} else if (selectNo == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores [" + i + "] : " + scores[i]);
				}
			} else if (selectNo == 4) {
				int max = 0;
				int sum = 0;
				double avg = 0.0;
				for (int v : scores) {
					max = max < v ? v : max;
					sum += v;
				}
				avg = (double) sum / scores.length;
				System.out.println(" 최고 점수 : " + max);
				System.out.println(" 평균 점수 : " + avg);
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}
