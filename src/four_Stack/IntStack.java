package four_Stack;

// 스택
// int형 스택
public class IntStack {
	private int max;
	private int ptr;
	private int stk[];
	
	
	// 스택이 비어있으면 예외
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {};
	}
	
	//실행 시 예외 : 스택이 가득 참
		public class OverflowIntStackException extends RuntimeException {
			public OverflowIntStackException() {};
		}
	
	// 스택 생성
	public IntStack(int capacity) {
		this.ptr = 0;
		this.max = capacity;
		try {
			this.stk = new int[this.max];
		}
		catch(OutOfMemoryError e) {
			this.max = 0;
			System.out.println("ERROR : " +e.getMessage());
			System.out.println("스택 오류!!");
		}
	}
	
	public int push(int data) {
		if(this.ptr >= this.max) {
			throw new OverflowIntStackException();
		}
		return this.stk[this.ptr++];
	}
	
	
	public int pop(int data) {
		if(this.ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return this.stk[--this.ptr];
	}
	
	public int peek(int data) {
		if(this.ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return this.stk[this.ptr - 1];
	}
	
	
	public int indexOf(int data) {
		for(int i = this.ptr; i >= 0; i--) {
			if(this.stk[i] == data) {
				return i;
			}
		}
		return -9999;
	}
	
	public void clear() {
		this.ptr = 0;
	}
	
	public int capacity() {
		return this.max;
	}
	
	
	// 스택의 모든 데이터 출력
	public void dump() {
		if(this.ptr <= 0) {
			throw new EmptyIntStackException();
		}
		else {
			for(int i = 0; i < this.ptr; i++) {
				System.out.println(this.stk[i]);
			}
		}
	}
}