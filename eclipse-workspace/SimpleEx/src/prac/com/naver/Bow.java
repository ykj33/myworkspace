package prac.com.naver;

public class Bow extends Weapon {
	public Bow() {
		// TODO Auto-generated constructor stub
	}

	public Bow(String name, int attackPower) {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void describe() {
		System.out.println("활을 마구 쏩니다.");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}
}
