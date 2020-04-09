package chap07.lecture.protectedKeyword.package1;

public class OtherParent {
public static void main(String[] args) {
	Parent p = new Parent();
	// 같은 패키지이므로 default, protected 둘 다 접근 가능
	p.defaultField = 3;
	p.protectedField = 3;
}
}
