package chap06.lecture.packageKeyword;

//import java.util.List;
//import java.util.Scanner;
// *로 모두 import할 수 있음
import java.util.*;
import chap06.lecture.packageKeyword.subPackage.YourClass;
import static java.lang.Math.*;

public class MyApp {
	public static void main(String[] args) {
		// 원래는 패키지 명까지 다 적어주어야 하지만 같은 패키지 내부에 있는 경우는 생략하여도 됨
		chap06.lecture.packageKeyword.MyClass c1 = new chap06.lecture.packageKeyword.MyClass();
		MyClass c2 = new MyClass();

		YourClass c3 = new YourClass();
		// 다른 패키지에 있는 같은 이름의 클래스라도 패키지 명까지 적어주면 사용 가능
		chap06.lecture.packageKeyword.subPackage.MyClass c4 = new chap06.lecture.packageKeyword.subPackage.MyClass();

		java.util.Scanner scanner1 = new java.util.Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);

		// 같은 이름의 클래스를 import할 경우 이클립스에서 선택창이 나옴
//	java.awt.List list;
//	java.util.List list2;
		List list3;

		// java.lang은 생략하여 사용 가능
		String str = "";
		
		// static import를 할 경우 클래스 명을 쓰지 않고 만들 수 있다.
		double d = random();
		int i = abs(10-11);
	}

}
