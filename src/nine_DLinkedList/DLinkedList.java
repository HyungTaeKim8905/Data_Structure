package nine_DLinkedList;

import java.util.Comparator;

// 이중 연결 리스트
public class DLinkedList<E> {
	private Node<E> head;
	private Node<E> crnt;
	
	// 노드
	class Node<E> {
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		// 더미 노드 생성 (삽입, 수정, 삭제를 쉽게 해주는 녀석이지)
		Node() {
			this.data = data;
			this.next = this.next = this;
		}
		
		Node(E data, Node<E> prev, Node<E> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	// 더미 노드 생성
	DLinkedList() {
		this.crnt = this.head = new Node();
	}
	
	
	// 리스트가 비었는지 검사하는 메서드
	public boolean isEmpty() {
	
		// head가 가리키고 있는 다음 노드가 head가 가리키는 더미노드라면 true를 반환 
		return this.head.next == this.head;
	}
	
	
	
	// 검색
	public E search(E data, Comparator<? super E> c) {
		Node<E> ptr = this.head.next;
		
		while(ptr != this.head) {
			if(c.compare(data, ptr.data) == 0) {
				this.crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}
	
	// 선택 노드를 출력
	public void printCurrentNode() {
		// 현재 리스트가 비어있는지 확인 해야한다.
		if(isEmpty()) {
			System.out.println("선택한 리스트가 없습니다.");
		}
		else {
			System.out.println(this.crnt.data);
		}
	}
	
	// 모든 노드를 출력
	public void dump() {
		Node<E> ptr = this.head.next;
		
		while(ptr != this.head) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}
	}
	
	
	// 모든 노드를 거꾸로 출력
	public void dumpReverse() {
		Node<E> ptr = this.head.prev;
		
		while(ptr != this.head) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.prev;
		}
	}
	
	
	// 선택한 노드의 바로 뒤에 삽입
	public void add(E data) {
		Node<E> node = new Node<E>(data, this.crnt, this.crnt.next);
		this.crnt.next = this.crnt.next.prev = node;
		this.crnt = node;
	}
	
	// 머리에 노드를 삽입
	public void addFirst(E data) {
		this.crnt = this.head.next;
		add(data);
	}
	
	
	// 꼬리에 노드를 삽입
	public void addLast(E data) {
		this.crnt = this.head.prev;
		add(data);
	}
	
	// 선택 노드를 삭제
	public void removeCurrentNode() {
		this.crnt.prev.next = this.crnt.next;
		this.crnt.next.prev = this.crnt.prev;
		
		if(this.crnt == this.head) {
			this.crnt = this.head.next;
		}
	}
	
	
	// 노드 p를 삭제
	public void remove(Node p) {
		Node<E> ptr = this.head.next;
		
		while(ptr != this.head) {
			if(ptr == p) {
				this.crnt = ptr;
				removeCurrentNode();
				break;
			}
			ptr = ptr.next;
		}
	}
	
	// 머리 노드를 삭제
	public void removeFirst() {
		this.crnt = this.head.next;
		removeFirst();
	}
	
	
	// 꼬리 노드를 삭제
	public void removeLast() {
		this.crnt = this.head.prev;
		removeFirst();
	}
	
	
	// 모든 노드를 삭제
	public void clear() {
		while(!isEmpty()) {
			removeFirst();
		}
	}
}









