package chap07.lecture.protectedKeyword.package2;

import chap07.lecture.protectedKeyword.package1.Parent;

public class OtherChild {
	public static void main(String[] args) {
		Parent p = new Parent();

//		다른 패키지에 있으며 상속도 되지 않아 사용 불능
//		p.defaultField = 3;
//		p.protectedField = 3;
	}
}
