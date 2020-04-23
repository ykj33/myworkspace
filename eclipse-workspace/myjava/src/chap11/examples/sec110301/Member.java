package chap11.examples.sec110301;

public class Member {
	public String id;

	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		// 매개값이 Member타입인지 확인
		if (obj instanceof Member) {
			// Member 타입으로 강제 타입 변환하고 id 필드값이 동일한지 검사한 후, 동일하면 true
			Member member = (Member) obj;
			if (id.equals(member.id)) {
				return true;
			}
		}
		// 매개값이 Member 타입이 아니거나 id 필드값이 다른 경우 false를 리턴
		return false;
	}

	@Override
	public int hashCode() {
		// id가 동일한 문자열인 경우 같은 해시코드를 리턴
		return id.hashCode();
	}
}
