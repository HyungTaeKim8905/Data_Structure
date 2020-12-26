package Test1_1;

public class LinkedList<E> {
	
	private Node<E> head;
	private Node<E> crnt;
	
	class Node<E> {
		private E data;
		private Node<E> next;
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	// 검색
	public E search(E obj) {
		Node<E> ptr = this.head;
		if(ptr != null) {
			while(ptr.data != obj) {
				ptr = ptr.next;
			}
			if(ptr.data == obj) {
				return ptr.data;
			}
		}
		return null;
	}
	
	//머리에 노드 추가
	public void addFirst(E obj) {
		Node<E> ptr = this.head;
		this.head = this.crnt = new Node<E>(obj, ptr);
	}
	
	//꼬리에 노드 추가
	public void addLast(E obj) {
		if(this.head == null) {
			addFirst(obj);
		}
		else {
			Node<E> ptr = this.head;
			while(ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = new Node<E>(obj, null);
		}
	}
	
	// 머리 노드 삭제
	public void removeFirst() {
		this.head = this.head.next;
	}
	
	// 꼬리 노드 삭제
	public void removeLast() {
		if(this.head != null) {
			if(this.head.next == null) {
				removeFirst();
			}
			else {
				Node<E> ptr = this.head;
				Node<E> pre = this.head;
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;
			}
		}
	}
	
	//원하는 노드 삭제
	public void removeCurrendNode(E obj) {
		if(this.head != null) {
			if(this.head.next == null) {
				removeFirst();
			}
			else {
				Node<E> ptr = this.head;
				while(ptr.data != obj) {
					if(ptr.data == obj) {
						this.crnt = ptr;
						remove(this.crnt);
					}
					ptr = ptr.next;
				}
			}
		}
	}
	
	// 선택한 노드 p를 삭제
	public void remove(Node<E> p) {
		if(this.head != null) {
			if(this.head == p) {
				removeFirst();
			}
			else {
				Node<E> ptr = this.head;
				while(ptr.next != p) {
					ptr = ptr.next;
					if(ptr == null) {
						return;
					}
				}
				ptr.next = p.next;
			}
		}
	}
	
	// 모든 노드를 출력
	public void dump() {
		Node<E> ptr = this.head;
		while(ptr != null) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
			if(ptr == null) {
				System.out.println(ptr);
			}
		}
	}
}
