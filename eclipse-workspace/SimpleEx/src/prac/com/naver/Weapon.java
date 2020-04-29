package prac.com.naver;

public abstract class Weapon {
	private String name;
	private int attackPower;

	public Weapon() {
		// TODO Auto-generated constructor stub
	}

	public Weapon(String name, int attackPower) {
		super();
		this.name = name;
		this.attackPower = attackPower;
	}

	public void attack(Monster m) {
		describe();
		int cHp = m.getHp();
		int rHp = cHp - attackPower;
		m.setHp(rHp);
		System.out.println("몬스터를 공격하였습니다.");
		System.out.println(m);
	}

	public abstract void describe();

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

}
