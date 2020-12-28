package Test1_2;

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
	
	//�˻� �޼���
	public E search(E obj) {	//20
		Node<E> ptr = this.head;
		while(ptr.data != obj) {
			ptr = ptr.next;
		}
		if(ptr.data == obj) {
			return ptr.data;
		}
		return null;
	}
	
	//�Ӹ��� ��� �߰� �Լ�
	public void addFirst(E obj) {
		Node<E> ptr = this.head;
		this.head = this.crnt = new Node<E>(obj, ptr);
	}
	
	//������ ��� �߰� �Լ�
	public void addLast(E obj) {
		if(this.head == null) {
			addFirst(obj);
		}
		else {
			Node<E> ptr = this.head;
			while(ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = new Node<E>(obj, null);
		}
	}
	
	//���ϴ� ��� ����
	public void removeCurrendNode(E obj) {
		if(this.head != null) {
			if(this.head.next == null) {
				removeFirst();
			}
			else {
				Node<E> ptr = this.head;
				while(ptr.data != obj) {
					ptr = ptr.next;
				}
				if(ptr.data == obj) {
					this.crnt = ptr;
					remove(this.crnt);
				}
			}
		}
	}
	
	//��� p ����
	public void remove(Node p) {
		if(this.head != null) {
			if(this.head == p) {
				removeFirst();
			}
			else {
				Node<E> ptr = this.head;
				while(ptr.next != p) {
					ptr = ptr.next;
					if(ptr == null) {
						return;
					}
				}
				ptr.next = p.next;
			}
		}
	}
	
	//�Ӹ� ��� ����
	public void removeFirst() {
		this.head = this.head.next;
	}
	
	//���� ��� ����
	public void removeLast() {
		if(this.head != null) {
			if(this.head.next == null) {
				removeFirst();
			}
			else {
				Node<E> ptr = this.head;
				Node<E> pre = this.head;
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;
			}
		}
	}
	
	//��� ��� ���
	public void dump() {
		Node<E> ptr = this.head;
		while(ptr != null) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}
	}
}

