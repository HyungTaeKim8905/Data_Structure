package four_Stack;

import java.util.Scanner;

public class IntStackTester {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IntStack s = new IntStack(64);				//�ִ� 64���� Ǫ���� �� �ִ� ����
		
		while(true)	{
			System.out.println("���� ������ �� : " + s.size() + " / " + s.capacity());
			System.out.print("(1)Ǫ�á�(2)�� (3)��ũ (4)������(0)���᣺");
			
			int menu = scanner.nextInt();
			if(menu == 0) {
				break;
			}
			
			int x;
			switch (menu) {
			case 1:
				System.out.print("������ : ");
				x = scanner.nextInt();
				try	{
					s.push(x);
				}
				catch(IntStack.OverflowIntStackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
			
			case 2:
				try {
					x = s.pop();
					System.out.println("���� �����ʹ� " + x + " �Դϴ�.");
				}
				catch(IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;
			case 3:
				try {
					x = s.peek();
					System.out.println("��ũ�� �����ʹ� " + x + " �Դϴ�.");
				}
				catch(IntStack.EmptyIntStackException e) {
					System.out.println("������ ����ֽ��ϴ�.");
				}
				break;
			case 4:
				s.dump();
				break;
			}
		}
	}
}