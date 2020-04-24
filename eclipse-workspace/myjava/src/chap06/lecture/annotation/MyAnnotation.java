package chap06.lecture.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션 적용 대상
@Target(ElementType.METHOD)
// 어노테이션 적용 기간
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	// 메소드처럼 작성하여 이것이 꼭 포함되도록 해야 한다.
	// 기본값을 제시해 줄 수 있으며, 이것이 있을 경우 어노테이션 적용시 필수적으로 값을 넣어주지 않아도 된다.
	String value() default "python";

	int number();
}
