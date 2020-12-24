package Test;

public class DLinkedList<E> {
	private Node<E> head;
	private Node<E> crnt;
	
	class Node<E> {
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		//���� ��� 
		public Node()	{
			this.data = null;
			this.prev = this.next = this;
		}
		
		//������
		public Node(E data, Node<E> prev, Node<E> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	//������
	public DLinkedList()	{
		this.head = this.crnt = new Node<E>();
	}
	
	
	// ���� ����� �ٷ� �ڿ� ��带 ����
	public void add(E obj) {
		
	}
	
	// �Ӹ��� ��� ����
	public void addFirst(E obj) {
		this.crnt = this.head;			//prev		  next
		Node<E> node = new Node<E>(obj, this.crnt, this.crnt.next);
		this.crnt.prev = node;
		this.crnt.next = node;
		this.crnt = node;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
