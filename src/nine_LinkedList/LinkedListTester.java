package nine_LinkedList;

import java.util.Scanner;

public class LinkedListTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		LinkedList<Integer>.Node<Integer> node = null;
		//linkedlist.new Node<Integer>(100, null);
		while(true) {
			System.out.println("(0) �Ӹ��� ��� ���� | (1) ������ ��� ���� | (2) �Ӹ� ��� ����");
			System.out.println("(3) ���� ��� ����   | (4) ���� ��� ���� |  (5) ��� ��� ����");
			System.out.println("(6) ���� ��� ���   | (7) ��� ��� ��� |  (8) ��� �˻�");
			int num = scanner.nextInt();
			int data = 0;
			if(num == 0)	{
				System.out.print("�Ӹ� ��忡 ������ �����͸� �Է��ϼ���(����)  : ");
				data = scanner.nextInt();
				linkedlist.addFirst(data);
			}
			if(num == 1)	{
				System.out.print("���� ��忡 ������ �����͸� �Է��ϼ���(����)  : ");
				data = scanner.nextInt();
				linkedlist.addLast(data);
			}
			if(num == 2)	{
				System.out.print("�Ӹ� ��带 �����մϴ�.");
				linkedlist.removeFirst();
			}
			if(num == 3)	{
				System.out.print("�Ӹ� ��带 �����մϴ�.");
				linkedlist.removeFirst();
			}
			if(num == 4)	{
				System.out.print("���� ��带 �����մϴ�.");
				linkedlist.removeLast();
			}
			if(num == 5)	{
				System.out.print("���� ����� �����͸� �Է����ּ���(����) : ");
				data = scanner.nextInt();
				linkedlist.removeCurrentNode(data);
			}
			if(num == 6)	{
				System.out.print("���� ����� �����͸� �Է����ּ���(����) : ");
				data = scanner.nextInt();
				linkedlist.removeCurrentNode(data);
			}
			if(num == 7)	{
				System.out.print("���� ����� �����͸� �Է����ּ���(����) : ");
				data = scanner.nextInt();
				linkedlist.removeCurrentNode(data);
			}
			if(num == 8)	{
				System.out.print("���� ����� �����͸� �Է����ּ���(����) : ");
				data = scanner.nextInt();
				linkedlist.removeCurrentNode(data);
			}
		}
	}
}
