package chap10.examples.sec100403;

public class MultiCatchExample {
	public static void main(String[] args) {
		try {
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1 + " + " + data2 + " = " + result);
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("실행 매개값의 수가 부족하거나 숫자로 변환할 수 없습니다.");
			// 에러메세지가 어디서 어떻게 일어났는지 알 수 있음
			System.out.println(e.getMessage());
			// 좀 더 선호하는 방식
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알수 없는 예외 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("다시 실행하세요.");
		}
	}
}
