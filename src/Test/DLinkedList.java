package Test;

public class DLinkedList<E> {
	private Node<E> head;
	private Node<E> crnt;
	
	class Node<E>{
		private E data;
		private Node<E> prev;	//프리비어스
		private Node<E> next;
		
		public Node()	{
			this.data = null;
			this.next = this.prev = this;
		}
		
		public Node(E data, Node<E> prev, Node<E> next)	{
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	public DLinkedList()	{
		this.head = this.crnt = new Node();
	}
	
	//선택 노드의 바로 뒤에 노드를 삽입
	public void add(E obj)	{
		Node<E> node = new Node(obj, this.crnt, this.crnt.next);
		this.crnt.next = this.crnt.next.prev = node;
		this.crnt = node;
	}
	
	//머리에 노드를 삽입
	public void addFirst(E obj)	{
		this.crnt = this.head;
		add(obj);
	}
	
	//꼬리에 노드를 삽입
	public void addLast(E obj)	{
		this.crnt = this.head.prev;
		add(obj);
	}
	
	public void dump()	{
		Node<E> ptr = head.next;
		while(ptr != this.head) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}
	}
	
	
	
}
