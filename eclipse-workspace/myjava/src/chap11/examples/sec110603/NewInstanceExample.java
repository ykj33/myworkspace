package chap11.examples.sec110603;

public class NewInstanceExample {
	public static void main(String[] args) {
		try {
			// 나중에 어디선가 클래스에 대한 정보를 받아야 할 때 사용
			// 동적으로 메모리에 로드시킬 수 있다.
			Class clazz = Class.forName("chap11.examples.sec110603.SendAction");
//			Class clazz = Class.forName("chap11.examples.sec110603.ReceiveAction");
			// 인터페이스 구현한 것이므로 형변환 가능
			Action action = (Action) clazz.newInstance();
			// 실행은 다형성에 의해 각자 인스턴스의 메소드 실행
			action.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
