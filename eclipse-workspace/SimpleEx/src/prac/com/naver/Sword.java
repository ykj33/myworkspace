package prac.com.naver;

public class Sword extends Weapon {

	public Sword() {
		// TODO Auto-generated constructor stub
	}

	public Sword(String name, int attackPower) {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void describe() {
		System.out.println("칼을 마구 휘두릅니다.");

	}

	@Override
	public String toString() {
		return getName();
	}
}
