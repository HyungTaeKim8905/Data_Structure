package nine_DLinkedList;

import java.util.Comparator;

public class DLinkedList<E> {
	private Node<E> head;				//머리노드 (더미 노드)
	private Node<E> crnt;				//선택노드
	
	// 노드
	class Node<E> {
		private E data;					//데이터
		private Node<E> prev;			//앞쪽 포인터(앞쪽 노드에 대한 참조)
		private Node<E> next;			//뒤쪽 포인터(뒤쪽 노드에 대한 참조)
		
		//생성자
		Node()	{
			data = null;
			prev = next = this;
			System.out.println(this.prev);
			System.out.println(this.next);
		}
		
		//생성자
		Node(E obj, Node<E> prev, Node<E> next) {
			this.data = obj;
			this.prev = prev;
			this.next = next;
		}
	}
	
	//생성자
	public DLinkedList()	{
		head = crnt = new Node<E>();
	}
	
	//리스트가 비어있는지 확인
	public boolean isEmpty()	{
		if(head.next == head) {
			return true;
		}
		else	{
			return false;
		}
	}
	
	//노드 검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head.next;
		
		while(ptr != head) {
			if(c.compare(obj, ptr.data) == 0)	{
				this.crnt = ptr;
				return ptr.data;			//검색 성공
			}
			ptr = ptr.next;					//다음 노드로 선택
		}
		return null;						//검색 실패(원하는 데이터 없음)
	}
	
	//선택한 노드를 출력
	public void printCurrentNode()	{
		if(isEmpty()) {
			System.out.println("선택한 노드가 없습니다.");
		}
		else	{
			System.out.println(this.crnt.data);
		}
	}
	
	//모든 노드를 출력
	public void dump()	{
		Node<E> ptr = head.next;		//더미 노드의 다음 노드
		
		while(ptr != head) {
			System.out.println(ptr.data + " -> ");
			ptr = ptr.next;
		}
	}
	
	//모든 노드를 거꾸로 출력
	public void dumpReverse()	{
		Node<E> ptr = this.head.prev;
		
		while(ptr != head) {
			System.out.println(ptr.data + " -> ");
			ptr = ptr.prev;
		}
	}
	
	//선택 노드를 하나 뒤쪽으로 이동
	public boolean next()	{
		if(isEmpty() || this.crnt.next == head) {
			return false;
		}
		else	{
			this.crnt = this.crnt.next;
			return true;
		}
	}
	
	//선택 노드를 하나 앞쪽으로 이동
	public boolean prev()	{
		if(isEmpty() || this.crnt.prev == head) {
			return false;
		}
		else	{
			this.crnt = this.crnt.prev;
			return true;
		}
	}
	
	// 선택 노드의 바로 뒤에 노드를 삽입
	public void add(E obj) {
		Node<E> node = new Node<E>(obj, this.crnt, this.crnt.next);
		this.crnt.next = this.crnt.next.prev = node;
		crnt = node;
	}

	// 머리에 노드를 삽입 
	public void addFirst(E obj) {
		crnt = head;				// 더미 노드 head의 바로 뒤에 삽입
		add(obj);
	}

	// 꼬리에 노드를 삽입
	public void addLast(E obj) {
		crnt = head.prev;			// 꼬리 노드 head.prev의 바로 뒤에 삽입
		add(obj);
	}

	// 선택 노드를 삭제
	public void removeCurrentNode() {
		if (!isEmpty()) {
			crnt.prev.next = crnt.next;
			crnt.next.prev = crnt.prev;
			crnt = crnt.prev;
			if (crnt == head) {
				crnt = head.next;
			}
		}
	}

	// 노드 p를 삭제
	public void remove(Node p) {
		Node<E> ptr = head.next;

		while (ptr != head) {
			if (ptr == p) {			// p를 찾음
				crnt = p;
				removeCurrentNode();
				break;
			}
			ptr = ptr.next;
		}
	}

	// 머리 노드를 삭제
	public void removeFirst() {
		crnt = head.next;			// 머리 노드 head.next를 삭제
		removeCurrentNode();
	}

	// 꼬리 노드를 삭제
	public void removeLast() {
		crnt = head.prev;			// 꼬리 노드 head.prev를 삭제
		removeCurrentNode();
	}

	// 모든 노드를 삭제
	public void clear() {
		while (!isEmpty())			// 텅 빌 때까지
			removeFirst();			// 머리 노드를 삭제
	}
}
