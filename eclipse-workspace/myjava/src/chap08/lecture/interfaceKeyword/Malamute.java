package chap08.lecture.interfaceKeyword;

// 인터페이스는 여러개 구현 가능
public class Malamute extends KindaDog implements Pet, SledDog {
	@Override
	public void howling() {
		System.out.println("아우~~~~~~~");
	}
	// 인터페이스 내에 추상메소드가 있으므로 반드시 구현해주어야 함
	@Override
	public void sit() {
		System.out.println("말라뮤트가 앉습니다.");
	}

	// 인터페이스 내에 추상메소드가 있으므로 반드시 구현해주어야 함
	@Override
	public void pull() {
		System.out.println("썰매를 끕니다.");

	}
}
