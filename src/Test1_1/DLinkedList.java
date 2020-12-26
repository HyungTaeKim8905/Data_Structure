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
	
	//더미 노드 생성
	public DLinkedList() {
		this.head = this.crnt = new Node<E>();
	}
	
	//리스트 비어있는지 확인
	public boolean isEmpty() {
		if(this.head == this.head.next) {
			return true;
		}
		else {
			return false;
		}
	}
	//노드 추가
	public void add(E obj) {	
								// 더미노드 주소값,  더미노드가 가리키는 노드의 주소값 :: 머리노드 추가시
								// 마지막 노드의 주소값, 더미노드의 주소값 :: 꼬리노드 추가시
		Node<E> node = new Node(obj, this.crnt, this.crnt.next);
		this.crnt.next = this.crnt.next.prev = node;
	}
	
	//머리에 노드 추가
	public void addFirst(E obj) {
		this.crnt = this.head;
		add(obj);
	}
	
	//꼬리에 노드 추가
	public void addLast(E obj) {
		this.crnt = this.head.prev;
		add(obj);
	}
	
	//선택 노드 삭제
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
	
	//머리 노드 삭제
	public void removeFirst() {
		this.crnt = this.head.next;
		removeCurrentNode();
	}
	
	//꼬리 노드 삭제
	public void removeLast( ) {
		this.crnt = this.head.prev;
		removeCurrentNode();
	}
	
	//모든 노드 삭제
	public void clear() {
		if(!isEmpty()) {
			removeFirst();
		}
	}
	
	
	
	
}
