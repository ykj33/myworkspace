package chap04.examples;

public class WhileKeyControlExample {
	public static void main(String[] args) throws Exception {
		boolean run = true;
		int speed = 0;
		int keyCode = 0;

		while (run) {
			if (keyCode != 13 && keyCode != 10) { // window에서 Enter는 13과 10이 조합된 코드, 13과 10 즉 Enter는 무시하길 원했던 코드
				System.out.println("-------------------------");
				System.out.println("1.증속 | 2.감속 | 3. 중지");
				System.out.println("-------------------------");
				System.out.print("선택 : ");
			}
			keyCode = System.in.read(); // out은 콘솔에 해당하는 객체, in은 키보드를 의미하는 객체 read()는 1바이트씩 읽는다.

			if (keyCode == 49) { // 1을 읽었을 경우
				speed++;
				System.out.println("현재 속도 : " + speed);
			} else if (keyCode == 50) { // 2를 읽었을 경우
				speed--;
				System.out.println("현재 속도 : " + speed);
			} else if (keyCode == 51) { // 3을 읽었을 경우
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}
