package Test1_1;

import java.util.Scanner;

public class LinkedListTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		System.out.print("��� �����͸� �����Ͻðڽ��ϱ�? : ");
		int num = scanner.nextInt();
		for(int i = 1; i <= num; i++) {
			System.out.print("������ �����͸� �Է��ϼ���(����) : ");
			int data = scanner.nextInt();
			linkedlist.addLast(data);
		}
		System.out.println("���Ḯ��Ʈ ���");
		linkedlist.dump();
		
		System.out.println();
		System.out.print("�˻��� �����͸� �Է��ϼ���(����) : ");
		int data = scanner.nextInt();
		System.out.println("�˻��� �����ʹ� : " + linkedlist.search(data) + " �Դϴ�.");
		
		System.out.println();
		System.out.println("�Ӹ� ��� ����");
		linkedlist.removeFirst();
		linkedlist.dump();
		
		System.out.println();
		System.out.println("���� ��� ����");
		linkedlist.removeLast();
		linkedlist.dump();
		
		
		scanner.close();
		
	}
}
