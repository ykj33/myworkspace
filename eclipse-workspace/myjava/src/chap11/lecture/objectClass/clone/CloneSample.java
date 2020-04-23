package chap11.lecture.objectClass.clone;

import chap06.examples.sec061301.package1.B;

class Book implements Cloneable {
	int isbn;
	String[] authors;

	@Override
	// 상위 접근제한자보다 넓거나 같은 접근제한자
	public Object clone() throws CloneNotSupportedException {
//		Book n = new Book();
//		n.isbn = this.isbn;
//		n.authors = this.authors;
		
		return super.clone(); // 얕은 복사
	}
}

public class CloneSample {
	public static void main(String[] args) throws Exception {
		Book b1 = new Book();
		b1.isbn = 3;
		b1.authors = new String[] { "a", "b" };

		// 얕은 복사를 해서 참조값이 같다.
		Object o = b1.clone();
		System.out.println(o instanceof Book);
		Book b2 = (Book) o;
		System.out.println(b2.isbn);
		System.out.println(b2.authors);
		
	
		System.out.println();
		System.out.println(b1.isbn);
		System.out.println(b1.authors);
		
		b1.authors[0] = "c";
		System.out.println(b2.authors[0]);
	}
}
