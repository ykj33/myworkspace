package prac.com.naver;

public class Hammer extends Weapon {
	public Hammer() {
		// TODO Auto-generated constructor stub
	}

	public Hammer(String name, int attackPower) {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void describe() {
		System.out.println("망치를 마구 휘두릅니다.");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}
}
