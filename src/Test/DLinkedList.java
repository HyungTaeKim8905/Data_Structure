package Test;

public class DLinkedList<E> {
	
	private Node<E> head;
	private Node<E> crnt;
	
	class Node<E> {
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		public Node() {
			this.data = null;
			this.prev = this.next = this;
		}
		
		public Node(E data, Node<E> prev, Node<E> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	//���� ���� �˻��� �����ϰ� �ϱ� ���� ���� ��� ����
	public DLinkedList() {
		this.head = this.crnt = new Node<E>();
	}
	
	//��Ʈ���� ����ִ��� Ȯ��
	public boolean isEmpty() {
		if(this.head == this.head.next) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//��� �˻�
	public E search(E obj) {
		Node<E> ptr = this.head.next;
		while(ptr != this.head) {
			if(ptr.data == obj) {
				this.crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}
	
	//���� ����� �ٷ� �ڿ� ����
	public void add(E obj) {
		Node<E> node = new Node<E>(obj, this.crnt, this.crnt.next);
		this.crnt.next = this.crnt.next.prev = node;
	}
	
	// �Ӹ��� ��� ���� (���̳���� �ּҰ��� �˾ƾ��Ѵ�.)
	public void addFirst(E obj) {
		this.crnt = this.head; //head�� ����Ű�� �ִ� ���� ����� �ּҰ��� crnt�� ����
		add(obj); // add ȣ��
	}
	
	// ������ ��� ���� (������ ����� �ּҰ��� �˾ƾ��Ѵ�.)
	public void addLast(E obj) {
		this.crnt = this.head.prev;	//������ ����� �ּҰ��� crnt�� ����
		add(obj);
	}
	
	// ���� ��带 ����
	public void removeCurrentNode() {
		if(!isEmpty()) {
			this.crnt.prev.next = this.crnt.next;
			this.crnt.next.prev = this.crnt.prev;
			this.crnt = this.crnt.prev;
			if (this.crnt == this.head) {
				this.crnt = this.head.next;
			}
		}
	}
	
	//��� p�� ����
	public void remove(Node p) {
		//������ ����� �ּҰ��� �˾ƾ��Ѵ�.
		Node<E> ptr = this.head;
		while(ptr != head) {
			if(ptr == p) {
				this.crnt = ptr;
				removeCurrentNode();
			}
			ptr = ptr.next;
		}
	}
	
 	//�Ӹ� ��� ����
	public void removeFirst() {
		this.crnt = this.head.next; //�Ӹ� ��带 �����Ϸ��� �Ӹ� ����� �ּҰ��� �˾ƾ��Ѵ�.
		removeCurrentNode();
	}
	
	//������ ��� ����
	public void removeLast() {
		this.crnt = this.head.prev; //���� ��带 �����Ϸ��� ���� ����� �ּҰ��� �˾ƾ��Ѵ�.
		removeCurrentNode();
	}
	
	//��� ��� ����
	public void clear() {
		while(!isEmpty()) {
			removeFirst();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
