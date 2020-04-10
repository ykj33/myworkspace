package chap07.lecture.polymorphism.abstractKeyword;

// 추상적 개념일 뿐이지 실제로 인스턴스가 존재하면 안되므로 인스턴스를 만들 수 없게 한다.
public abstract class KindaCat {
	// 추상 메소드, 꼭 구현해야 함. 추상메소드가 존재할 경우 클래스도 꼭 추상 클래스
	public abstract void cry();

	public void hide() {
		System.out.println("박스에 들어갑니다.");
	}
}
