package nine_DLinkedList;

import java.util.Comparator;

public class DLinkedList<E> {
	private Node<E> head; // 머리노드
	private Node<E> crnt;

	// 노드
	class Node<E> {
		private E data; // 데이터
		private Node<E> prev; // 앞쪽 포인터 (앞쪽 노드에 대한 참조)
		private Node<E> next; // 뒤쪽 포인터 (뒤쪽 노드에 대한 참조)

		// 생성자
		public Node() {
			this.data = null;
			this.prev = this.next = this;
		}

		// 생성자
		Node(E data, Node<E> prev, Node<E> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	// 생성자
	public DLinkedList() {
		this.head = this.crnt = null;
	}

	// 리스트가 비어있는지 확인 하는 메서드
	public boolean isEmpty() {
		return this.head.next == this.head;
	}

	// 노드를 검색하는 메서드
	public E search(E data, Comparator<? super E> c) {
		Node<E> ptr = this.head.next;
		while (ptr != this.head) {
			if (c.compare(ptr.data, data) == 0) {
				this.crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}

	// 선택 노드를 출력
	public void printCurrentNode() {
		if (isEmpty()) {
			System.out.println("선택한 노드가 없습니다.");
		} else {
			System.out.println(this.crnt.data);
		}
	}

	// 모든 노드를 출력
	public void dump() {
		Node<E> ptr = this.head.next;

		while (ptr != this.head) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}
	}

	// 모든 노드를 거꾸로 출력
	public void dumpReverse() {
		Node<E> ptr = this.head.prev;

		while (ptr != this.head) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.prev;
		}
	}

	// 선택한 노드의 바로 뒤에 노드를 삽입
	public void add(E data) {
		Node<E> node = new Node<E>(data, this.crnt, this.crnt.next);

		// 더미 노드의 뒤쪽 포인터와 앞쪽 포인터가 가리키는 곳으 노드 A 이다.
		this.crnt.next = this.crnt.next.prev = node;

		this.crnt = node;
	}

	// 머리에 노드 삽입
	public void addFirst(E data) {
		this.crnt = this.head;
		add(data);
	}

	// 꼬리에 노드 삽입
	public void addLast(E data) {
		this.crnt = this.head.prev;
		add(data);
	}
	
	
	// 선택 노드를 삭제
	public void removeCurrentNode() {
		if(!isEmpty()) {
			this.crnt.prev.next = this.crnt.next;
			this.crnt.next.prev = this.crnt.prev;
			this.crnt = this.crnt.prev;
			
			if(this.crnt == this.head) {
				this.crnt = this.head.next;
			}
		}
	}
	
	// 노드 p를 삭제
	public void remove(Node p) {
		Node<E> ptr = this.head.next;
		
		// 한바퀴 돌때까지 while 돌려 ~
		while(ptr != this.head) {
			if(ptr == p) {
				this.crnt = p;
				removeCurrentNode();
				break;
			}
			ptr = ptr.next;
		}
	}
	
	
	// 머리 노드를 삭제
	public void removeFirst() {
		this.crnt = this.head.next;
		removeCurrentNode();
	}
	
	
	// 꼬리 노드를 삭제
	public void removeLast() {
		this.crnt = this.head.prev;
		removeCurrentNode();
	}
	
	
	// 모든 노드를 삭제
	public void clear() {
		while(!isEmpty()) {
			removeCurrentNode();
		}
	}
}









