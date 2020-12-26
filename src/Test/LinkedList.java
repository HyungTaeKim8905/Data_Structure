package Test;

public class LinkedList<E> {
	
	private Node<E> head;
	private Node<E> crnt;
	
	class Node<E> {
		private E data;
		private Node<E> next;
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public LinkedList() {
		this.head = this.crnt = null;
	}
	
	//��� �˻��ϴ� �Լ�
	public E search(E obj)  {
		Node<E> ptr =this.head;
		if(ptr != null)	{
			while(ptr.data != obj) {
				if(ptr.data == obj) {
					return ptr.data;
				}
				ptr = ptr.next;
			}
		}
		return null;
	}
	
	//��� �߰� �Լ�
	public void add(E obj) {
		Node<E> ptr = this.head;
		/* �Ӹ��� ��带 �߰� �ҽ�...
		 * next �ʵ忡 ptr�� �ִ� ������ ptr�� ����Ű�� �ִ� ���� ����� �ּҰ��� ����
		 * ������ ����� next �ʵ忡 �����ϸ� ���� ���� ����� next�� ���� ��带 ����Ų��.
		 */
		this.head = this.crnt = new Node<E>(obj, ptr);
	}

	// �Ӹ� ��� �߰� �Լ�
	public void addFirst(E obj) {
		//�Ӹ��� ��带 �߰� �Ϸ��� crnt�� head�� ���� ��带 �����ϰ� �־�� �Ѵ�.
		this.crnt = this.head;
		add(obj);
	}

	// ���� ��� �߰� �Լ�
	public void addLast(E obj) {
		//������ ��带 �߰� �Ϸ��� crnt�� ������ ����� �ּҰ��� �˰� �־�� �Ѵ�.
		if(this.head == null) {
			addFirst(obj);
		}
		else {
			Node<E> ptr = this.head;
			while(ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = new Node<E>(obj, null);
			this.crnt = ptr;
		}
	}
	
	//�Ӹ� ��� ����
	public void removeFirst() {
		//�Ӹ� ��带 ���� �Ϸ��� ù ��° ����� �ּҰ��� �˾ƾ��Ѵ�.
		if(this.head != null) {
			this.head = this.crnt = this.head.next;
		}
	}
	
	//���� ��� ����
	public void removeLast() {
		if(this.head != null) {
			if(this.head.next == null) {
				removeFirst();
			}
			else {
				Node<E> ptr = this.head; //������ ��带 ����Ű�� ptr
				Node<E> pre = this.head; //�������� �ι��� ��带 ����Ű�� pre
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;
				this.crnt = pre;
			}
		}
	}
	
	// ������ ��� p�� ����
	public void remove(Node<E> p) {
		if(this.head != null) {
			if(this.head == p) {	 //p�� �Ӹ�����
				removeFirst(); 		 // �Ӹ� ��带 ����
			}
			else {
				Node<E> ptr = this.head;
				while(ptr.next != p) {
					ptr = ptr.next; //�����ϰ��� �ϴ� ����� ���� ��带 ptr�� ����Ų��.
				}
				//�����ϰ��� �ϴ� ����� ���� ����� �ּҰ��� �����ϰ��� �ϴ� ����� ���� ����� next�ʵ忡 �����Ѵ�.
				ptr.next = p.next;
				this.crnt = ptr;
			}
		}
	}
	
	//���� ��带 ����
	public void removeCurrentNode(E obj) {
		//������ ��带 �����ϱ� ���ؼ��� �����ϰ��� �ϴ� ����� �ּҰ��� �˾ƾ��Ѵ�.
		Node<E> ptr = this.head;
		if(ptr != null) {
			while(ptr.data != obj) {
				ptr = ptr.next;
			}
			this.crnt = ptr;
			remove(this.crnt);
		}
	}
	
	//��� ��� ���
	public void dump() {
		Node<E> ptr = this.head;
		while(ptr != null) {
			System.out.println(ptr.data + " -> ");
			ptr = ptr.next;
			if(ptr == null) {
				System.out.println(ptr);
			}
		}
	}
	
	
}
