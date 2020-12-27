package Test1_2;

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
	
	//더미 노드 생성
	public DLinkedList() {
		this.head = this.crnt = new Node<E>();
	}
	
	//리스트가 비어있는지 확인
	public boolean isEmpty() {
		if(this.head == this.head.next) {
			return true;
		}
		else {
			return false;
		}
	}
	//검색 노드
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
	
	//노드 추가
	public void add(E obj) {
		Node<E> node = new Node<E>(obj, this.crnt, this.crnt.next);
		this.crnt.next = this.crnt.next.prev = node;
		//this.crnt = node;
	}
	
	//머리에 노드 추가
	public void addFirst(E obj) {
		this.crnt = this.head;
		add(obj);
	}
	
	//꼬리에 노드 추가
	public void addLast(E obj) {
		this.crnt =this.head.prev;
		add(obj);
	}
	
	//노드 삭제
	public void removeCurrentNode() {
		if(!isEmpty()) {
			this.crnt.prev.next = this.crnt.next;
			this.crnt.next.prev = this.crnt.prev;
		}
	}
	
	//노드 p 삭제
	public void remove(Node p) {
		if(this.head.next == p) {
			removeFirst();
		}
		else {
			Node<E> ptr =this.head.next;
			while(ptr != this.head) {
				if(ptr == p) {
					ptr.prev.next = ptr.next;
					ptr.next.prev = ptr.prev;
					return;
				}
				ptr = ptr.next;
			}
		}
	}
	
	//머리 노드 삭제
	public void removeFirst() {
		this.crnt = this.head.next;
	}
	
	//꼬리 노드 삭제
	public void removeLast() {
		this.crnt = this.head.prev;
		removeCurrentNode();
	}
	
	//모든 노드 삭제
	public void clear() {
		if(!isEmpty()) {
			removeFirst();
		}
	}
	
	
	public void dump()	{
		Node<E> ptr = head.next;		//더미 노드의 다음 노드
		
		while(ptr != head) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}
	}
	
	//모든 노드를 거꾸로 출력
	public void dumpReverse()	{
		Node<E> ptr = this.head.prev;
		
		while(ptr != head) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.prev;
		}
	}
}
