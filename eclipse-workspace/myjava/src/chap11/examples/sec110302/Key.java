package chap11.examples.sec110302;

public class Key {
	public int number;

	public Key(int number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Key) {
			Key compareKey = (Key) obj;
			if (this.number == compareKey.number) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		// hashcode 재정의를 통해 number가 식별키로 들어갈 수 있게 함
		return number;
	}
}
