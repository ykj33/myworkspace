package chap09.exercises.ex06;

public class Chatting {
	void startChat(String chatId) {
		// final이어야 하는데 값을 2번 할당하여 문제가 됨
//		String nickName = null;
//		nickName = chatId;
		String nickName = chatId; 
		Chat chat = new Chat() {
			@Override
			public void start() {
				while (true) {
					String inputData = "안녕하세요";
					// 로컬 클래스에서 지역변수를 사용하려고 하면 지역변수는 항상 final이어야 함
					// final이어야 사용 가능하지만 값을 2번 받았다 = final이 아니니 사용할 수 없어서 에러가 남
					String message = "[" + nickName + "]" + inputData;
					sendMessage(message);
				}
			}
		};
		chat.start();
	}

	class Chat {

		void start() {
		}

		void sendMessage(String message) {
		}
	}
}
