package four_Queue;

// int형 큐
public class IntQueue {
	private int max;		// 큐의 용량
	private int front;		// 첫 번째 요소 커서
	private int rear;		// 마지막 요소 커서
	private int num;		// 현재 데이터 수
	private int que[];		// 큐 본체
	
	// 실행시 비어있으면 예외 발생
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {};
	}
	
	// 실행시 꽉차있으면 예외 발생
	public class OverflowIntQueueException extends RuntimeException { 
		public OverflowIntQueueException() {};
	}
	
	// 큐 생성
	public IntQueue(int capacity) {
		this.max = capacity;
		this.front = this.rear = this.num = 0;
		try {
			this.que = new int[this.max];
		}
		catch(OutOfMemoryError e) {
			System.out.println("ERROR : " + e.getMessage());
			this.max = 0;
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
	
	
	// 큐에 데이터를 디큐
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
	
	
	// 큐에서 데이터를 피크
	public int peek() throws EmptyIntQueueException {
		if(this.num <= 0) {
			throw new EmptyIntQueueException();
		}
		return this.que[this.front];
	}
	
	// 큐에서 data를 검색하여 인덱스를 반환 찾지 못하면 -1 반환
	public int indexOf(int data) {
		for(int i = 0; i < this.que.length; i++) {
			int idx = (i + this.front) % this.max;
			if(this.que[idx] == data) {
				return idx;
			}
		}
		return -1;
	}
	
	// 프런트에서 리어 순으로 출력
	public void dump() {
		if(this.num <= 0) {
			System.out.print("큐가 비어 있어요.");
		}
		else {
			for(int i = 0; i < this.que.length; i++) {
				System.out.println(this.que[(i + this.front) % this.max] + " -> ");
			}
		}
	}
}