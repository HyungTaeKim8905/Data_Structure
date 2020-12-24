package nine_LinkedList;

import java.util.Scanner;

public class LinkedListTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		LinkedList<Integer>.Node<Integer> node = null;
		//linkedlist.new Node<Integer>(100, null);
		while(true) {
			System.out.println("(0) 머리에 노드 삽입 | (1) 꼬리에 노드 삽입 | (2) 머리 노드 삭제");
			System.out.println("(3) 꼬리 노드 삭제   | (4) 선택 노드 삭제 |  (5) 모든 노드 삭제");
			System.out.println("(6) 선택 노드 출력   | (7) 모든 노드 출력 |  (8) 노드 검색");
			int num = scanner.nextInt();
			int data = 0;
			if(num == 0)	{
				System.out.print("머리 노드에 삽입할 데이터를 입력하세요(숫자)  : ");
				data = scanner.nextInt();
				linkedlist.addFirst(data);
			}
			if(num == 1)	{
				System.out.print("꼬리 노드에 삽입할 데이터를 입력하세요(숫자)  : ");
				data = scanner.nextInt();
				linkedlist.addLast(data);
			}
			if(num == 2)	{
				System.out.print("머리 노드를 삭제합니다.");
				linkedlist.removeFirst();
			}
			if(num == 3)	{
				System.out.print("머리 노드를 삭제합니다.");
				linkedlist.removeFirst();
			}
			if(num == 4)	{
				System.out.print("꼬리 노드를 삭제합니다.");
				linkedlist.removeLast();
			}
			if(num == 5)	{
				System.out.print("선택 노드의 데이터를 입력해주세요(숫자) : ");
				data = scanner.nextInt();
				linkedlist.removeCurrentNode(data);
			}
			if(num == 6)	{
				System.out.print("선택 노드의 데이터를 입력해주세요(숫자) : ");
				data = scanner.nextInt();
				linkedlist.removeCurrentNode(data);
			}
			if(num == 7)	{
				System.out.print("선택 노드의 데이터를 입력해주세요(숫자) : ");
				data = scanner.nextInt();
				linkedlist.removeCurrentNode(data);
			}
			if(num == 8)	{
				System.out.print("선택 노드의 데이터를 입력해주세요(숫자) : ");
				data = scanner.nextInt();
				linkedlist.removeCurrentNode(data);
			}
		}
	}
}
