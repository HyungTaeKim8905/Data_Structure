package Test;

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
	
	public LinkedList() {
		this.head = this.crnt = null;
	}
	
	//노드 검색하는 함수
	public E search(E obj)  {
		Node<E> ptr =this.head;
		if(ptr != null)	{
			while(ptr.data != obj) {
				if(ptr.data == obj) {
					return ptr.data;
				}
				ptr = ptr.next;
			}
		}
		return null;
	}
	
	//노드 추가 함수
	public void add(E obj) {
		Node<E> ptr = this.head;
		/* 머리에 노드를 추가 할시...
		 * next 필드에 ptr을 넣는 이유는 ptr이 가리키고 있는 기존 노드의 주소값을 새로
		 * 생성된 노드의 next 필드에 저장하면 새로 생긴 노드의 next가 기존 노드를 가리킨다.
		 */
		this.head = this.crnt = new Node<E>(obj, ptr);
	}

	// 머리 노드 추가 함수
	public void addFirst(E obj) {
		//머리에 노드를 추가 하려면 crnt가 head와 같은 노드를 참조하고 있어야 한다.
		this.crnt = this.head;
		add(obj);
	}

	// 꼬리 노드 추가 함수
	public void addLast(E obj) {
		//꼬리에 노드를 추가 하려면 crnt가 마지막 노드의 주소값을 알고 있어야 한다.
		if(this.head == null) {
			addFirst(obj);
		}
		else {
			Node<E> ptr = this.head;
			while(ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = new Node<E>(obj, null);
			this.crnt = ptr;
		}
	}
	
	//머리 노드 삭제
	public void removeFirst() {
		//머리 노드를 삭제 하려면 첫 번째 노드의 주소값을 알아야한다.
		if(this.head != null) {
			this.head = this.crnt = this.head.next;
		}
	}
	
	//꼬리 노드 삭제
	public void removeLast() {
		if(this.head != null) {
			if(this.head.next == null) {
				removeFirst();
			}
			else {
				Node<E> ptr = this.head; //마지막 노드를 가리키는 ptr
				Node<E> pre = this.head; //마지막의 두번재 노드를 가리키는 pre
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
	public void remove(Node<E> p) {
		if(this.head != null) {
			if(this.head == p) {	 //p가 머리노드면
				removeFirst(); 		 // 머리 노드를 삭제
			}
			else {
				Node<E> ptr = this.head;
				while(ptr.next != p) {
					ptr = ptr.next; //삭제하고자 하는 노드의 앞쪽 노드를 ptr이 가리킨다.
				}
				//삭제하고자 하는 노드의 뒤쪽 노드의 주소값을 삭제하고자 하는 노드의 앞쪽 노드의 next필드에 저장한다.
				ptr.next = p.next;
				this.crnt = ptr;
			}
		}
	}
	
	//선택 노드를 삭제
	public void removeCurrentNode(E obj) {
		//선택한 노드를 삭제하기 위해서는 삭제하고자 하는 노드의 주소값을 알아야한다.
		Node<E> ptr = this.head;
		if(ptr != null) {
			while(ptr.data != obj) {
				ptr = ptr.next;
			}
			this.crnt = ptr;
			remove(this.crnt);
		}
	}
	
	//모든 노드 출력
	public void dump() {
		Node<E> ptr = this.head;
		while(ptr != null) {
			System.out.println(ptr.data + " -> ");
			ptr = ptr.next;
			if(ptr == null) {
				System.out.println(ptr);
			}
		}
	}
	
	
}
