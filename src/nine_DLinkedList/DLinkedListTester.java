package nine_DLinkedList;

import java.util.Scanner;

public class DLinkedListTester {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		DLinkedList<Integer> Dlinkedlist = new DLinkedList<Integer>();
		System.out.print("��� �����͸� �����Ͻðڽ��ϱ�? : ");
		int num = scanner.nextInt();
		for(int i = 1; i <= num; i++) {
			System.out.print("������ �����͸� �Է��ϼ���(����) : ");
			int data = scanner.nextInt();
			Dlinkedlist.addLast(data);
		}
		System.out.println("���� ���� ���Ḯ��Ʈ ���");
		Dlinkedlist.dump();
		System.out.println();
		System.out.println("���� ���� ���Ḯ��Ʈ �Ųٷ� ���");
		Dlinkedlist.dumpReverse();
		System.out.println();
		System.out.print("�˻��� �����͸� �Է��ϼ���(����) : ");
		int data = scanner.nextInt();
		System.out.println("�˻��� �����ʹ� : " + Dlinkedlist.search(data, null) + " �Դϴ�.");
		scanner.close();
	}
}
