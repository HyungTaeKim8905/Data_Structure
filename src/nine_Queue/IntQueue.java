package nine_Queue;

public class IntQueue {
	private int max;		//ť�� �뷮
	private int num;		//���� �������� ����
	private int front;		//ù ��° ��� Ŀ��
	private int rear;		//������ ��� Ŀ��
	private int que[];		//ť ��ü
	
	//���� �� ���� : ť�� �������
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException () {}
	}
	
	//���� �� ���� : ť�� ���� ��
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException () {}
	}
	
	public IntQueue(int capacity) {
		this.num = this.front = this.rear = 0;
		this.max = capacity;
		try {
			this.que = new int[this.max];
		}
		catch(OutOfMemoryError e) {
			this.max = 0;
		}
	}
	
	//ť�� �����͸� ��ť
	public int enque(int x) throws OverflowIntQueueException {
		if(this.num >= this.max) {
			System.out.println("ť�� �� ���ֽ��ϴ�.");
			throw new OverflowIntQueueException();
		}
		this.que[this.rear++] = x;
		this.num++;
		if(this.rear == this.max) {
			this.rear = 0;
		}
		return x;
	}
	
	//ť���� �����͸� ��ť
	public int deque() throws EmptyIntQueueException {
		if(this.num <= 0) {
			System.out.println("ť�� �����Ͱ� ����Ǿ� ���� �ʽ��ϴ�.");
			throw new EmptyIntQueueException();
		}
		int x = this.que[this.front++];
		this.num--;
		if (this.front == this.max) {
			this.front = 0;
		}
		return x;
	}
	
	//ť���� �����͸� ��ũ(����Ʈ �����͸� �鿩�ٺ�)
	public int peek() throws EmptyIntQueueException {
		if(this.num <= 0) {
			throw new EmptyIntQueueException();
		}
		return que[this.front];
	}
	
	//ť���� x�� �˻��Ͽ� �ε���(ã�� ���ϸ� -1)�� ��ȯ
	public int indexOf(int x) {
		for(int i = 0; i < num; i++) {
			int idx = (i + this.front) % this.max;
			if(this.que[idx] == x) {				//�˻� ����
				return idx;
			}
		}
		return -1;
	}
	
	//ť�� ���
	public void clear() {
		this.num = this.front = this.rear = 0;
	}
	
	//ť�� �뷮�� ��ȯ
	public int capacity() {
		return this.max;
	}
	
	//ť�� �׿� �ִ� ������ ���� ��ȯ
	public int size() {
		return this.num;
	}
	
	//ť�� ��� �ִ��� Ȯ��
	public boolean isEmpty() {
		return num <= 0;
	}
	
	//ť�� ���� á���� Ȯ��
	public boolean isFull() {
		return this.num >= this.max;
	}
	
	//ť ���� ��� �����͸� front -> rear ������ ���
	public void dump() {
		if(this.num <= 0) {
			System.out.println("ť�� ��� �ֽ��ϴ�.");
		}
		else {
			for(int i = 0; i < num; i++) {
				System.out.println(this.que[(i + this.front) % this.max] + " ");
			}
		}
	}
}
