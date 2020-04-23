package chap11.lecture.objectsClass.compare;

import java.util.Arrays;

public class SortSample {
	public static void main(String[] args) {
		int[] intArr = new int[] { 3, 0, -1, 9 };
		Arrays.sort(intArr);

		for (int n : intArr) {
			System.out.println(n);

		}
		System.out.println();

		Book[] books = new Book[] { new Book(9), new Book(8), new Book(5) };
		// 객체들을 비교하기 위해 comparator를 사용
		Arrays.sort(books, new BookComparator());

		for (Book b : books) {
			System.out.println(b.isbn);
		}

	}
}
