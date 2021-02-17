package four_Stack;

// 스택
// int형 스택
public class IntStack {
	int max;		// 스택 용량		:: 스택에 쌓을 수 있는 최대 데이터 수
	int ptr;		// 스택 포인터		:: 스택에 쌓여 있는 데이터 수 
	int stk[];		// 스택의 본체		:: push된 데이터를 저장하는 스택 본체의 배열
	
	
	// 실행 시 예외 : 스택이 비어있음
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {};
	}

	
	// 실행 시 예외 : 스택이 꽉차있음
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {};
	}
	
	
	// 생성자
	public IntStack(int capacity) {
		this.max = capacity;
		this.ptr = 0;
		
		try {
			stk = new int[this.max];		// 스택 본체용 배열을 생성
		} catch(OutOfMemoryError error) {	// 생성 할 수 없다.
			System.out.println("스택을 생성 할 수 없습니다.");
			System.out.println("ERROR : " + error.getMessage());
			this.max = 0;
		}
	}

	// push : 스택에 데이터를 푸시하는 메서드
	public int push(int data) throws OverflowIntStackException {
		
		// 현재 스택에 쌓여있는 데이터의 수가 스택에 쌓을 수 있는 최대 데이터 수 보다 크다면 예외 발생
		if(this.ptr >= this.max) {	
			throw new OverflowIntStackException();
		}
		// ptr에 data를 저장 후 ptr을 +1 증가 시킨다.
		// return 문이 반환하는 것은 data를 저장한 후의 stk[this.ptr]의 값이다.
		System.out.println("push ==> " + this.ptr);
		return this.stk[this.ptr++] = data;
	}
	
	
	// pop : 스택의 꼭대기에서 데이터를 제거하고 제거한 데이터를 반환하는 메서드
	public int pop() throws EmptyIntStackException {
		if(this.ptr <= 0) {	// 현재 스택이 비어있다면 예외 발생
			throw new EmptyIntStackException() {};
		}
		//ptr을 먼저 감소 시킨 후 리턴 
		return this.stk[--this.ptr]; //10 ->9 ptr == 9
		// this.stk[9] 실질적으로 멤버변수 ptr이 바뀜
	}
	
	
	// 스택의 꼭대기에 있는 데이터를 몰래 엿보는 메서드
	public int peek() throws EmptyIntStackException {
		if(this.ptr <= 0) {
			throw new EmptyIntStackException() {};
		}
		return this.stk[ptr - 1];
	}
	
	
	// 스택에서 data를 찾아 인덱스(없으면 -1)를 반환
	public int indexOf(int data) {
		for(int i = ptr - 1; i >= 0; i--) {
			if(this.stk[i] == data) {
				return i;
			}
		}
		return -1;
	}
	
	// 스택을 모조리 비워버리는 메서드
	public void clear() {
		this.ptr = 0;
	}
	
	// 스택의 용량을 반환
	public int capacity() {
		return this.max;
	}
	
	// 스택에 쌓여 있는 데이터의 개수
	public int siz() {
		return this.ptr;
	}
	
	// 스택이 비어있는지 확인하는 메서드
	public boolean isEmpty() {
		return this.ptr <= 0;
	}
	
	// 스택이 가득 찼는지 확인하는 메서드
	public boolean isFull() {
		return this.ptr >= this.max;
	}
	
	// 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
	public void dump() throws EmptyIntStackException {
		if(this.ptr <= 0) {
			throw new EmptyIntStackException() {};
		}
		else {
			for(int i = 0; i < this.ptr; i++) {
				System.out.println(stk[i] + " ");
			}
			System.out.println();
		}
	}
}