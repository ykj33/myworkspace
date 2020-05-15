package kr.co.ca;

import com.naver.AccountDAO;

public class MainEx {
	public static void main(String[] args) {
		AccountDAO dao = new AccountDAO();
		dao.transfer("a", "b", 1000);

		new com.naver.Process();
	}
}
