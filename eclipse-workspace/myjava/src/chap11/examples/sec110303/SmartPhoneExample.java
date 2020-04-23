package chap11.examples.sec110303;

public class SmartPhoneExample {
public static void main(String[] args) {
	SmartPhone myPhone = new SmartPhone("구글", "안드로이드");
	
	String strObj = myPhone.toString();
	System.out.println(strObj);
	// myPhone.toString()을 자동 호출해서 리턴값을 얻은 후 출력
	// println 메소드는 객체의 toString메소드를 호출하기 때문
	System.out.println(myPhone);
}
}
