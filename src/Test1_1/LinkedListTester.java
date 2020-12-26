package Test1_1;

import java.util.Scanner;

public class LinkedListTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		System.out.print("몇개의 데이터를 저정하시겠습니까? : ");
		int num = scanner.nextInt();
		for(int i = 1; i <= num; i++) {
			System.out.print("저장할 데이터를 입력하세요(숫자) : ");
			int data = scanner.nextInt();
			linkedlist.addLast(data);
		}
		System.out.println("연결리스트 출력");
		linkedlist.dump();
		
		System.out.println();
		System.out.print("검색할 데이터를 입력하세요(숫자) : ");
		int data = scanner.nextInt();
		System.out.println("검색한 데이터는 : " + linkedlist.search(data) + " 입니다.");
		
		System.out.println();
		System.out.println("머리 노드 삭제");
		linkedlist.removeFirst();
		linkedlist.dump();
		
		System.out.println();
		System.out.println("꼬리 노드 삭제");
		linkedlist.removeLast();
		linkedlist.dump();
		
		
		scanner.close();
		
	}
}
