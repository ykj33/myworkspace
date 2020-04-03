package chap05.exercises;

public class Exercise07 {
public static void main(String[] args) {
	int max = 0;
	int[] array = {1,5,3,8,2};
	
//	for (int i = 0; i<array.length; i++) {
//		if(array[i] > array[i-1]) {
//			max = array[i];
//		} else {
//			max = array[i-1];
//		}
//		
//	}

	for (int v : array) {
		max = max < v? v : max;
	}
	System.out.println("max : " + max);
}
}
