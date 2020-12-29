package Test1_2;
//���� ���� ���� ����Ʈ
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
	
	//���� ��� ����(���� ���� �˻��� �����ϰ� �ϱ� ����)
	public DLinkedList() {
		this.head = this.crnt = new Node<E>();
	}
	
	//��� �ִ��� �˻�
	public boolean isEmpty() {
		if(this.head == this.head.next) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//�˻�
	public E search(E obj) {
		Node<E> ptr = this.head.next;
		while(ptr != this.head) {
			if(ptr.data == obj) {
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}
	
	//��� �߰�
	public void add(E obj) {
		Node<E> node = new Node<E>(obj, this.crnt, this.crnt.next);
		this.crnt.next = this.crnt.next.prev = node;
	}
	
	//�Ӹ��� ��� �߰�
	public void addFirst(E obj) {
		this.crnt = this.head;
		add(obj);
	}
	
	//������ ��� �߰�
	public void addLast(E obj) {
		this.crnt = this.head.prev;
		add(obj);
	}
	
	//������ ��� ����
	public void removeCurrentNode() {
		if(!isEmpty()) {
			this.crnt.prev.next = this.crnt.next;
			this.crnt.next.prev = this.crnt.prev;
		}
	}
	
	//node p ����
	public void remove(Node p) {
		Node<E> ptr =this.head.next;
		if(!isEmpty()) {
			while(ptr != this.head) {
				if(ptr == p) {
					this.crnt = ptr;
					removeCurrentNode();
					break;
				}
				ptr = ptr.next;
			}
		}
	}
	
	//�Ӹ� ��� ����
	public void removeFirst() {
		this.crnt = this.head.next;
		removeCurrentNode();
	}
	
	//���� ��� ����
	public void removeLast() {
		this.crnt = this.head.prev;
		removeCurrentNode();
	}
	//��� ��� ����
	public void clear() {
		if(!isEmpty()) {
			removeFirst();
		}
	}
	
	

	//��� ��带 ���
	public void dump()	{
		Node<E> ptr = head.next;		//���� ����� ���� ���
		
		while(ptr != head) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}
	}
	
	//��� ��带 �Ųٷ� ���
	public void dumpReverse()	{
		Node<E> ptr = this.head.prev;
		
		while(ptr != head) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.prev;
		}
	}
	
}
