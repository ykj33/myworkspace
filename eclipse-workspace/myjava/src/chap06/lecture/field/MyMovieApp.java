package chap06.lecture.field;

public class MyMovieApp {
	public static void main(String[] args) {
		Movie m1 = new Movie();
		m1.title = "기생충";
		m1.director = "봉준호";
		m1.actor = new Actor();
		m1.actor.name = "송강호";
		m1.actor.age = 12;
	}
}
