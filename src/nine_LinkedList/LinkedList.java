package nine_LinkedList;

import java.util.Comparator;

// 연결 리스트 클래스
public class LinkedList<E> {
	private Node<E> head;		// 머리 노드
	private Node<E> crnt;		// 현재 선택한 노드를 가리킨다. 검색과 삭제 용도
	
	class Node<E> {
		private E data;			// data 필드
		private Node<E> next;	// 다음 노드를 참조하는 next 필드
		
		// 생성자를 호출하면 노드 하나가 만들어진다.
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	// 생성자를 호출하면 비어있는 연결 리스트가 생성이 된다.
	public LinkedList() {
		this.head = this.crnt = null;
	}
	
	// 검색
	public E search(E data, Comparator<? super E> c) {
		Node<E> ptr = this.head;
		
		while(ptr != null) {
			if(c.compare(data, ptr.data) == 0) {
				this.crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}
	
	// 머리에 노드 삽입
	public void addFirst(E data) {
		Node<E> ptr = this.head;
		this.head = this.crnt = new Node<E>(data, ptr);
	}
	
	// 꼬리에 노드 삽입
	public void addLast(E data) {
		if(this.head == null) {
			addFirst(data);
		}
		else {
			Node<E> ptr = this.head;
			while(ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = this.crnt = new Node<E>(data, null);
		}
	}
	
	// 머리 노드를 삭제
	public void removeFirst() {
		if(this.head != null) {	// 리스트가 비어있지 않다면
			this.head = this.crnt = this.head.next;
		}
	}
	
	// 꼬리 노드를 삭제
	public void removeLast() {
		if(this.head != null) {
			if(this.head.next == null) {
				removeFirst();
			}
			else {
				Node<E> ptr = this.head;	// 스캔 중인 노드
				Node<E> pre = this.head;	// 스캔 중인 노드의 앞쪽 노드
				
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;
				this.crnt = pre;
			}
		}
	}
	
	// 선택한 노드 p를 삭제
	public void remove(Node p) {
		if(this.head != null) {
			if(this.head == p) {	// p가 머리노드면
				this.head = null;
			}
			else {
				Node<E> ptr = this.head;
				
				while(ptr.next != null) {
					ptr = ptr.next;
					if(ptr == null) {
						return;	// p가 리스트에 없다.
					}
				}
				
				ptr.next = p.next;
				this.crnt = ptr;
			}
		}
	}
	
	// 선택한 노드를 삭제
	public void removeCurrentNode() {
		remove(this.crnt);
	}
	
	// 모든 노드 삭제
	public void clear() {
		while(this.head != null) {
			removeFirst();
		}
		this.crnt =null;
	}
	
	// 선택한 노드를 출력
	public void printCurrentNode() {
		if(this.crnt == null) {
			System.out.println("선택한 노드가 없습니다.");
		}
		else {
			System.out.println(this.crnt.data);
		}
	}
	
	// 모든 노드를 출력
	public void dump() {
		Node<E> ptr = this.head;
		
		while(ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
}