package kr.co.ca;

import java.util.Scanner;

public interface Command {
	// 인터페이스에 추상 메소드가 1개만 들어가는 경우  functional interface라고 함
public abstract void execute(Scanner sc);
}
