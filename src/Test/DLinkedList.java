package Test;

public class DLinkedList<E> {
	private Node<E> head;
	private Node<E> crnt;
	
	class Node<E> {
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		//더미 노드 
		public Node()	{
			this.data = null;
			this.prev = this.next = this;
		}
		
		//생성자
		public Node(E data, Node<E> prev, Node<E> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	//생성자
	public DLinkedList()	{
		this.head = this.crnt = new Node<E>();
	}
	
	
	// 선택 노드의 바로 뒤에 노드를 삽입
	public void add(E obj) {
		
	}
	
	// 머리에 노드 삽입
	public void addFirst(E obj) {
		this.crnt = this.head;			//prev		  next
		Node<E> node = new Node<E>(obj, this.crnt, this.crnt.next);
		this.crnt.prev = node;
		this.crnt.next = node;
		this.crnt = node;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
