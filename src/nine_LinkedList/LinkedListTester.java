package nine_LinkedList;

import java.util.Scanner;

public class LinkedListTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		LinkedList<Integer>.Node<Integer> node = null;
		//linkedlist.new Node<Integer>(100, null);
		System.out.print("몇개의 데이터를 저정하시겠습니까? : ");
		int num = scanner.nextInt();
		for(int i = 1; i <= num; i++) {
			System.out.print("저장할 데이터를 입력하세요(숫자) : ");
			int data = scanner.nextInt();
			linkedlist.addLast(data);
		}
		linkedlist.dump();
	}
}
