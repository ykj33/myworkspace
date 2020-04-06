package chap06.lecture.constructor;

public class Movie {
	String title;
	String director;
	
	// 생성자 : 객체를 초기화 함
	public Movie() {
		System.out.println("객체를 초기화합니다.");
		title = "제목 없음";
		director = "감독 없음";
	}
}
