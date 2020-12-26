package Test1_1;

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
	
	//���� ��� ����
	public DLinkedList() {
		this.head = this.crnt = new Node<E>();
	}
	
	//����Ʈ ����ִ��� Ȯ��
	public boolean isEmpty() {
		if(this.head == this.head.next) {
			return true;
		}
		else {
			return false;
		}
	}
	//��� �߰�
	public void add(E obj) {	
								// ���̳�� �ּҰ�,  ���̳�尡 ����Ű�� ����� �ּҰ� :: �Ӹ���� �߰���
								// ������ ����� �ּҰ�, ���̳���� �ּҰ� :: ������� �߰���
		Node<E> node = new Node(obj, this.crnt, this.crnt.next);
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
	
	//���� ��� ����
	public void removeCurrentNode() {
		if(!isEmpty()) {
			this.crnt.prev.next = this.crnt.next;
			this.crnt.next.prev = this.crnt.prev;
		}
	}
	
	public void remove(Node p) {
		Node<E> ptr = this.head.next;
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
	public void removeLast( ) {
		this.crnt = this.head.prev;
		removeCurrentNode();
	}
	
	//��� ��� ����
	public void clear() {
		if(!isEmpty()) {
			removeFirst();
		}
	}
	
	
	
	
}
