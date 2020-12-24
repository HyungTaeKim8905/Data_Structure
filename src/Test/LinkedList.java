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
	
	//��� �˻�
	public E search(E obj) {
		Node<E> ptr = this.head;
		while(ptr != null) {
			if(ptr.data == obj) {
				this.crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;	// ���ϴ� �˻� �����Ͱ� ����
	}
	
	
	//�Ӹ� ��� �߰�
	public void addFirst(E obj)	{
		Node<E> ptr = this.head;
		this.head = this.crnt = new Node<E>(obj, ptr);
	}
	
	//���� ��� �߰�
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
	
	//�Ӹ� ��� ����
	public void removeFirst()	{
		if(this.head != null) {
			this.crnt = this.head = this.head.next;
		}
	}
	
	//���� ��� ����
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
	
	//������ ��� p�� ����
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
	
	//���� ��带 ����
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
