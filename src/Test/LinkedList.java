package Test;

public class LinkedList<E> {
	
	private Node<E> head;
	private Node<E> crnt;
	
	class Node<E> {
		private E data;
		private Node<E> next;
		
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public LinkedList()	{
		this.head = this.crnt = null;
	}
	
	//노드 검색
	public E search(E obj) {
		Node<E> ptr = this.head;
		while(ptr != null) {
			if(ptr.data == obj) {
				this.crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;	// 원하는 검색 데이터가 없음
	}
	
	
	//머리 노드 추가
	public void addFirst(E obj)	{
		Node<E> ptr = this.head;
		this.head = this.crnt = new Node<E>(obj, ptr);
	}
	
	//꼬리 노드 추가
	public void addLast(E obj) {
		if(this.head == null) {
			addFirst(obj);
		}
		else	{
			Node<E> ptr = head;
			while(ptr.next != null)	{
				ptr = ptr.next;
			}
			ptr.next = this.crnt = new Node<E>(obj, null);
		}
	}
	
	//머리 노드 삭제
	public void removeFirst()	{
		if(this.head != null) {
			this.crnt = this.head = this.head.next;
		}
	}
	
	//꼬리 노드 삭제
	public void removeLast()	{
		if(this.head != null) {
			if(this.head.next == null) {
				removeFirst();
			}
			else	{
				Node<E> ptr = this.head;
				Node<E> pre = this.head;
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;
				this.crnt = pre;
			}
		}
	}
	
	//선택한 노드 p를 삭제
	public void remove(Node p)	{
		if(this.head != null)	{
			if(this.head.next == null) {
				removeFirst();
			}
			else	{
				Node<E> ptr = this.head;
				while(ptr.next != p) {
					ptr = ptr.next;
					if(ptr == null) {
						return;
					}
				}
				ptr.next = p.next;
				this.crnt = ptr;
			}
		}
	}
	
	//선택 노드를 삭제
	public void removeCurrentNode(E obj)	{
		Node<E> ptr = this.head;
		if(ptr != null) {
			while(ptr.data != obj) {
				ptr = ptr.next;
			}
			this.crnt = ptr;
			remove(this.crnt);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
