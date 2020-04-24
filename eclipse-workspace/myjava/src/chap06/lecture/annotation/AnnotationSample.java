package chap06.lecture.annotation;

public class AnnotationSample {
	// 다음과 같이 적용해야 함
	// 디폴트 값이 있다면 값을 넣어주지 않아도 에러가 나지 않음
	@MyAnnotation(number = 3)
	void method() {

	}
}
