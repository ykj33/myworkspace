package kr.co.ca;

import java.io.File;

public class MainEx {
	public static void main(String[] args) {

		File f4 = new File("C:" + File.separator + "BBB");

		if (!f4.exists()) {
			f4.mkdir();
		}

		// 파일 세퍼레이터를 쓸 수는 있으나 가독성 확보를 위해 파일 객체를 2개 만들어 사용한다.
		// 파일 이름에 경로를 추가하여 원하는 곳으로 파일을 집어넣을 수도 있다.
		File f5 = new File("C:", "new.txt");
		File f6 = new File(f4, "new.txt");
		f5.renameTo(f6);
		
		// 파일명 변경
		File f3 = new File("C:", "test119.txt");
		File newName = new File("C:", "new.txt");
		f3.renameTo(newName);

		// 파일은 삭제만 가능
		File f2 = new File("C:" + File.separator + "test119.txt");
		boolean isDel = f2.delete();
		if (isDel) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}

		// 파일의 존재 유무는 모르지만 일단 가리킨다.
		// 확장자로 끝나면 파일, 확장자로 끝나지 않으면 폴더
		// File.separator를 통해 윈도우, 리눅스 환경 모두에서 사용할 수 있도록 함 - 파일구분자
		File f1 = new File("C:" + File.separator + "AAA");

		// 파일이 있는가
		// 가장 많이 사용될 것 같은 코드가 맨 위에 있는 것이 좋다.
		if (!f1.exists()) {
			// 폴더를 생성한다.
			f1.mkdir();
		} else {
			f1.delete();
		}
	}
}
