package four_Queue;

public class IntQueueTester {
	private int max;		// 큐의 용량
	private int num;		// 현재 데이터 수
	private int front;		// 첫 번째 요소 커서
	private int rear;		// 마지막 요소 커서
	private int que[];		// 큐 본체
	
	
	// 큐가 비어있다면 예외 발생
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {};
	}
	
	
	// 큐가 꽉차있다면 예외 발생
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {};
	}
	
	// 큐 생성자
	public IntQueueTester(int capacity) {
		this.max = capacity;
		this.num = this.front = this.rear = 0;
		try {
			this.que = new int[this.max];
		}
		catch(OutOfMemoryError e) {
			System.out.println("ERROR : " + e.getMessage());
		}
	}
	
	
	// 큐에 데이터를 인큐
	public int enque(int data) throws OverflowIntQueueException {
		if(this.num >= this.max) {
			throw new OverflowIntQueueException();
		}
		this.que[this.rear++] = data;
		this.num++;
		if(this.rear == this.max) {
			this.rear = 0;
		}
		return data;
	}
	
	
	// 큐에서 데이터를 디큐
	public int deque() throws EmptyIntQueueException {
		if(this.num <= 0) {
			throw new EmptyIntQueueException();
		}
		int data = this.que[this.front++];
		this.num--;
		if(this.front == this.max) {
			this.front = 0;
		}
		return data;
	}
	
	public int peek() throws EmptyIntQueueException {
		if(this.num <= 0) {
			throw new EmptyIntQueueException();
		}
		return this.que[this.front];
	}
	
	public int indexOf(int data) {
		for(int i = 0; i < this.num; i++) {
			int idx = (i + this.front) % this.max;
			if(this.que[idx] == data) {
				return idx;
			}
		}
		return -1;
	}
}
