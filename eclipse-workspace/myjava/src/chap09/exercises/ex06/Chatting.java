package chap09.exercises.ex06;

public class Chatting {
	void startChat(String chatId) {
		String nickName = null;
		nickName = chatId;
		// final이 아니기 때문
		Chat chat = new Chat() {
			@Override
			public void start() {
				while (true) {
					String inputData = "안녕하세요";
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
