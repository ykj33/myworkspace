package kr.co.ca;

import java.util.Scanner;

public interface Command {
	public abstract void execute(Scanner sc); // 콘솔 창에서 사용할 것이기 때문에 Scanner를 파라미터로 준다.
}
