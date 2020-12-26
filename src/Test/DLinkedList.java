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
	
	//삽입 삭제 검색을 원할하게 하기 위해 더미 노드 생성
	public DLinkedList() {
		this.head = this.crnt = new Node<E>();
	}
	
	//리트스가 비어있는지 확인
	public boolean isEmpty() {
		if(this.head == this.head.next) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//노드 검색
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
	
	//선택 노드의 바로 뒤에 삽입
	public void add(E obj) {
		Node<E> node = new Node<E>(obj, this.crnt, this.crnt.next);
		this.crnt.next = this.crnt.next.prev = node;
	}
	
	// 머리에 노드 삽입 (더미노드의 주소값을 알아야한다.)
	public void addFirst(E obj) {
		this.crnt = this.head; //head가 가리키고 있는 더미 노드의 주소값을 crnt에 저장
		add(obj); // add 호출
	}
	
	// 꼬리에 노드 삽입 (마지막 노드의 주소값을 알아야한다.)
	public void addLast(E obj) {
		this.crnt = this.head.prev;	//마지막 노드의 주소값을 crnt에 저장
		add(obj);
	}
	
	// 선택 노드를 삭제
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
	
	//노드 p를 삭제
	public void remove(Node p) {
		//삭제할 노드의 주소값을 알아야한다.
		Node<E> ptr = this.head;
		while(ptr != head) {
			if(ptr == p) {
				this.crnt = ptr;
				removeCurrentNode();
			}
			ptr = ptr.next;
		}
	}
	
 	//머리 노드 삭제
	public void removeFirst() {
		this.crnt = this.head.next; //머리 노드를 삭제하려면 머리 노드의 주소값을 알아야한다.
		removeCurrentNode();
	}
	
	//꼬리리 노드 삭제
	public void removeLast() {
		this.crnt = this.head.prev; //꼬리 노드를 삭제하려면 꼬리 노드의 주소값을 알아야한다.
		removeCurrentNode();
	}
	
	//모든 노드 삭제
	public void clear() {
		while(!isEmpty()) {
			removeFirst();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
