package nine_LinkedList;

import java.util.Scanner;

public class LinkedListTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		LinkedList<Integer>.Node<Integer> node = null;
		//linkedlist.new Node<Integer>(100, null);
		System.out.print("��� �����͸� �����Ͻðڽ��ϱ�? : ");
		int num = scanner.nextInt();
		for(int i = 1; i <= num; i++) {
			System.out.print("������ �����͸� �Է��ϼ���(����) : ");
			int data = scanner.nextInt();
			linkedlist.addLast(data);
		}
		linkedlist.dump();
	}
}
