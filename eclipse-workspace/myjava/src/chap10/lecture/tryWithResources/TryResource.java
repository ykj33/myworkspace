package chap10.lecture.tryWithResources;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryResource {
	void method1() {
		// finally에 있는 close메소드를 위해 try블럭 밖에서 선언
		FileReader fr = null;
		try {
			fr = new FileReader("src/myjava/Hello.java");
			// 읽는 작업을 함...

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 늘 실행되어야하기 때문에 close메소드는 finally 블럭에 선언
			try {
				if (fr != null) {
					// fr에 할당도 되기 전에 예외가 생기면 nullPointerException이 발생하기 때문에
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void method2() {
		// try() 안에 변수 선언과 할당을 함
		try (FileReader fr = new FileReader("src/myjava/Hello.java");
				FileReader f2 = new FileReader("src/myjava/Hello2.java");) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// close시 발생하는 IOException을 위해 catch함
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
