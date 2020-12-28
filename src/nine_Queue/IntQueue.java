package nine_Queue;

public class IntQueue {
	private int max;		//큐의 용량
	private int num;		//현재 데이터의 개수
	private int front;		//첫 번째 요소 커서
	private int rear;		//마지막 요소 커서
	private int que[];		//큐 본체
	
	//실행 시 예외 : 큐가 비어있음
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException () {}
	}
	
	//실행 시 예외 : 큐가 가득 참
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
	
	//큐에 데이터를 인큐
	public int enque(int x) throws OverflowIntQueueException {
		if(this.num >= this.max) {
			System.out.println("큐가 꽉 차있습니다.");
			throw new OverflowIntQueueException();
		}
		this.que[this.rear++] = x;
		this.num++;
		if(this.rear == this.max) {
			this.rear = 0;
		}
		return x;
	}
	
	//큐에서 데이터를 디큐
	public int deque() throws EmptyIntQueueException {
		if(this.num <= 0) {
			System.out.println("큐에 데이터가 저장되어 있지 않습니다.");
			throw new EmptyIntQueueException();
		}
		int x = this.que[this.front++];
		this.num--;
		if (this.front == this.max) {
			this.front = 0;
		}
		return x;
	}
	
	//큐에서 데이터를 피크(프런트 데이터를 들여다봄)
	public int peek() throws EmptyIntQueueException {
		if(this.num <= 0) {
			throw new EmptyIntQueueException();
		}
		return que[this.front];
	}
	
	//큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
	public int indexOf(int x) {
		for(int i = 0; i < num; i++) {
			int idx = (i + this.front) % this.max;
			if(this.que[idx] == x) {				//검색 성공
				return idx;
			}
		}
		return -1;
	}
	
	//큐를 비움
	public void clear() {
		this.num = this.front = this.rear = 0;
	}
	
	//큐의 용량읠 반환
	public int capacity() {
		return this.max;
	}
	
	//큐에 쌓여 있는 데이터 수를 반환
	public int size() {
		return this.num;
	}
	
	//큐가 비어 있는지 확인
	public boolean isEmpty() {
		return num <= 0;
	}
	
	//큐가 가득 찼는지 확인
	public boolean isFull() {
		return this.num >= this.max;
	}
	
	//큐 안의 모든 데이터를 front -> rear 순으로 출력
	public void dump() {
		if(this.num <= 0) {
			System.out.println("큐가 비어 있습니다.");
		}
		else {
			for(int i = 0; i < num; i++) {
				System.out.println(this.que[(i + this.front) % this.max] + " ");
			}
		}
	}
}
