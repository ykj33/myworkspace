package prac.com.naver;

public class Monster {
	private int hp;

	public Monster() {
		// TODO Auto-generated constructor stub
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public Monster(int hp) {
		super();
		this.hp = hp;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "monster hp : " + hp;
	}
}
