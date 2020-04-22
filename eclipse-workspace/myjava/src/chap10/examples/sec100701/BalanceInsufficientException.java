package chap10.examples.sec100701;

public class BalanceInsufficientException extends Exception {
	// exception 클래스를 상속받아서 checkedexception으로 만듦
	public BalanceInsufficientException() {

	}

	public BalanceInsufficientException(String message) {
		// exception에 메시지를 넣어서 에러메시지로 오류를 출력하려고 함
		super(message);
	}
}
