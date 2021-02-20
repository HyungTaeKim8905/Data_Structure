package five_Recursive;

import java.util.Scanner;

public class EuclidGCD {

	public static int gcd(int x, int y) {
		// x가 세로 y가가로가고 해보자고
		if(y == 0) {
			return x;
		}
		else {
			return gcd(y, x % y);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int x = scanner.nextInt();
		
		System.out.print("정수를 입력하세요 : ");
		int y = scanner.nextInt();
		
		System.out.println("최대공약수 값 : " + gcd(x, y));
	}
}
