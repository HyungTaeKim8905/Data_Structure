package Test1_2;

import java.util.Scanner;

public class DLinkedListTester {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		DLinkedList<Integer> Dlinkedlist = new DLinkedList<Integer>();
		
		System.out.print("몇개의 데이터를 저정하시겠습니까? : ");
		int num = scanner.nextInt();
		
		for(int i = 1; i <= num; i++) {
			System.out.print("저장할 데이터를 입력하세요(숫자) : ");
			int data = scanner.nextInt();
			Dlinkedlist.addLast(data);
		}
		
		System.out.println("이중 원형 연결리스트 출력");
		Dlinkedlist.dump();
		System.out.println();
		
		System.out.println("이중 원형 연결리스트 거꾸로 출력");
		Dlinkedlist.dumpReverse();
		System.out.println();
		
		System.out.print("검색할 데이터를 입력하세요(숫자) : ");
		int data = scanner.nextInt();
		System.out.println("검색한 데이터는 : " + Dlinkedlist.search(data) + " 입니다.");
		System.out.println();
		
		//머리 노드 삭제
		System.out.println("머리 노드 삭제");
		Dlinkedlist.removeFirst();
		Dlinkedlist.dump();
		System.out.println();
		Dlinkedlist.dumpReverse();
		System.out.println();
		
		//꼬리 노드 삭제
		System.out.println("꼬리 노드 삭제");
		Dlinkedlist.removeLast();
		Dlinkedlist.dump();
		System.out.println();
		Dlinkedlist.dumpReverse();
		System.out.println();

		
		scanner.close();
	}
}
