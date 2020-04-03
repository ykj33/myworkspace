package chap05.examples;

public class AdvancedForExample {
public static void main(String[] args) {
	int[] scores = {95,71,84,93,87};
	
	int sum = 0;
	for (int score : scores) {
		sum = sum + score;
	}
	
	// 이것과 같은 코드
//	for (int i = 0; i<scores.length;i++) {
//		sum = sum + scores[i];
//	}
	System.out.println("점수 총합 = " + sum);
	
	double avg = (double) sum / scores.length;
	System.out.println("점수 평균 = " + avg);
}
}
