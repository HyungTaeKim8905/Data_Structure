package nine_DLinkedList;

public class DLinkedList<E> {
	private Node<E> head;				//�Ӹ���� (���� ���)
	private Node<E> crnt;				//���ó��
	
	// ���
	class Node<E> {
		private E data;					//������
		private Node<E> prev;			//���� ������(���� ��忡 ���� ����)
		private Node<E> next;			//���� ������(���� ��忡 ���� ����)
		
		//������
		Node()	{
			data = null;
			prev = next = this;
		}
		
		//������
		Node(E obj, Node<E> prev, Node<E> next) {
			this.data = obj;
			this.prev = prev;
			this.next = next;
		}
	}
	
	//������
	public DLinkedList()	{
		head = crnt = new Node<E>();
	}
	
	//����Ʈ�� ����ִ��� Ȯ��
	public boolean isEmpty()	{
		if(head.next == head) {
			return true;
		}
		else	{
			return false;
		}
	}
	
	/* ��� �˻�
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head.next;
		
		while(ptr != head) {
			if(c.compare(obj, ptr.data) == 0)	{
				this.crnt = ptr;
				return ptr.data;			//�˻� ����
			}
			ptr = ptr.next;					//���� ���� ����
		}
		return null;						//�˻� ����(���ϴ� ������ ����)
	}
	*/
	
	// ��� �˻�
	public E search(E obj) {
		Node<E> ptr = head.next;
		
		while (ptr != head) {
			if (obj == ptr.data) {
				this.crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}
	
	//������ ��带 ���
	public void printCurrentNode()	{
		if(isEmpty()) {
			System.out.println("������ ��尡 �����ϴ�.");
		}
		else	{
			System.out.println(this.crnt.data);
		}
	}
	
	//��� ��带 ���
	public void dump()	{
		Node<E> ptr = head.next;		//���� ����� ���� ���
		
		while(ptr != head) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}
	}
	
	//��� ��带 �Ųٷ� ���
	public void dumpReverse()	{
		Node<E> ptr = this.head.prev;
		
		while(ptr != head) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.prev;
		}
	}
	
	//���� ��带 �ϳ� �������� �̵�
	public boolean next()	{
		if(isEmpty() || this.crnt.next == head) {
			return false;
		}
		else	{
			this.crnt = this.crnt.next;
			return true;
		}
	}
	
	//���� ��带 �ϳ� �������� �̵�
	public boolean prev()	{
		if(isEmpty() || this.crnt.prev == head) {
			return false;
		}
		else	{
			this.crnt = this.crnt.prev;
			return true;
		}
	}
	
	// ���� ����� �ٷ� �ڿ� ��带 ����
	public void add(E obj) {
		Node<E> node = new Node<E>(obj, this.crnt, this.crnt.next);
		this.crnt.next = this.crnt.next.prev = node;
		crnt = node;
	}

	// �Ӹ��� ��带 ���� 
	public void addFirst(E obj) {
		this.crnt = this.head;				// ���� ��� head�� �ٷ� �ڿ� ����
		add(obj);
	}

	// ������ ��带 ����
	public void addLast(E obj) {
		this.crnt = this.head.prev;			// ���� ��� head.prev�� �ٷ� �ڿ� ����
		add(obj);
	}

	// ���� ��带 ����
	public void removeCurrentNode() {
		if (!isEmpty()) {
			this.crnt.prev.next = this.crnt.next;
			this.crnt.next.prev = this.crnt.prev;
			this.crnt = this.crnt.prev;
			if (this.crnt == this.head) {
				this.crnt = this.head.next;
			}
		}
	}

	// ��� p�� ����
	public void remove(Node p) {
		Node<E> ptr = head.next;

		while (ptr != head) {
			if (ptr == p) {					// p�� ã��
				this.crnt = p;
				removeCurrentNode();
				break;
			}
			ptr = ptr.next;
		}
	}

	// �Ӹ� ��带 ����
	public void removeFirst() {
		this.crnt = this.head.next;			// �Ӹ� ��� head.next�� ����
		removeCurrentNode();
	}

	// ���� ��带 ����
	public void removeLast() {
		this.crnt = this.head.prev;			// ���� ��� head.prev�� ����
		removeCurrentNode();
	}

	// ��� ��带 ����
	public void clear() {
		while (!isEmpty())	{				// �� �� ������
			removeFirst();					// �Ӹ� ��带 ����
		}
	}
	
	
}
