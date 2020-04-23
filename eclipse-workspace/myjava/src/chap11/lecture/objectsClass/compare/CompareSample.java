package chap11.lecture.objectsClass.compare;

import java.util.Comparator;
import java.util.Objects;

// 제네릭, 타입 파라미터
class BookComparator implements Comparator<Book> {
	@Override
	public int compare(Book o1, Book o2) {
		return o2.isbn - o1.isbn;
	}
}

class Book {
	int isbn;

	public Book() {
	}

	Book(int isbn) {
		this.isbn = isbn;
	}
}

public class CompareSample {
	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book();
		b1.isbn = 99;
		b2.isbn = 200;

		int c = Objects.compare(b1, b2, new BookComparator());
		System.out.println(c);

	}
}
