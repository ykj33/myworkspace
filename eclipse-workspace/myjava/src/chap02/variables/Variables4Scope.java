package chap02.variables;

public class Variables4Scope {

	public static void main(String[] args) {
		int var1 = 10;
		
		if (true) {
			int var2 = 20;
			
			var1 = 30;
			System.out.println(var1);
			
			var2 = 40;
			System.out.println(var2);
		}
		
		/*
		var2 = 50; // 범위를 벗어나 사용 불가
		System.out.println(var2);
		 */
	}

}
