package chap06.lecture.encapsulation;

public class Car {
	// speed에 음수값을 넣지 못하게 하기 위해 일단 필드에 접근하지 못하도록 함
	private int speed;
	private String airbag;

	// 값을 읽을 수만 있다.
	public String getAirbag() {
		return this.airbag;
	}
	
	public Car() {
		this.airbag = "전면";
	}

	// 메소드로 한번 거쳐서 필드에 값을 할당
	public void setSpeed(int speed) {
		if (speed >= 0) {
			this.speed = speed;
		} else {
			this.speed = 0;
		}
	}

	// 필드 값에 접근할 수 없으므로 메소드를 거쳐 나온 값을 return 값을 통해 돌려줌
	public int getSpeed() {
		return this.speed;
	}
}
