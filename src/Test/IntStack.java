package Test;

public class IntStack {
	private int max;		//스택 용량	:: 스택에 쌓을 수 있는 최대 데이터 수
	private int ptr;		//스택 포인터	:: 스택에 쌓여 있는 데이터 개수
	private int stk[];		//스택 본체	:: 스택 본체를 참조하는 배열 변수
	
	//실행 시 예외 : 스택이 비어있음
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	}
	
	//실행 시 예외 : 스택이 꽉차있음
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	//생성자
	public IntStack(int capacity) {
		this.ptr = 0;
		this.max = capacity;
		try {
			this.stk = new int[this.max];
		} catch(OutOfMemoryError e) {
			this.max = 0;
			System.out.println("생성자 OutOfMemoryError 에러 발생");
			System.out.println("ERROR : " + e.getMessage());
		}
	}
	
	//스택에 x를 푸시
	public int push(int x) throws OverflowIntStackException {
		if(this.ptr >= this.max) {
			throw new OverflowIntStackException();
		}
		//ptr에 x를 저장 후 ptr을 +1 함
		return this.stk[this.ptr++] = x;
	}
	
	//스택에서 데이터를 팜(정상에 있는 데이터를 꺼냄)
	public int pop() throws EmptyIntStackException {
		if(this.ptr < 0) {
			throw new EmptyIntStackException();
		}
		return this.stk[--this.ptr];
	}
	
	//스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
	public int peek() throws EmptyIntStackException {
		if(this.ptr < 0) {
			throw new EmptyIntStackException();
		}
		return this.stk[this.ptr - 1];
	}
	
	//스택에서 x를 찾아 인덱스(없으면 -1)를 반환
	public int indexOf(int x) {
		for(int i = this.ptr - 1; i >= 0; i--) {
			if(this.stk[i] == x) {
				return i;
			}
		}
		return -1;
	}
	//스택을 비움
	public void clear()	{
		this.ptr = 0;
	}
	
	//스택의 용량을 반환
	public int capacity() {
		return this.max;
	}
	
	//스택에 쌓여 있는 데이터 수를 반환
	public int size() {
		return this.ptr;
	}
	
	//스택이 비어있는지 확인
	public boolean isEmpty() {
		return this.ptr <= 0;
	}
	
	//스택이 가득 찾는지 확인
	public boolean isFull()	{
		return this.ptr >= this.max;
	}
	
	//스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
	public void dump() {
		if(this.ptr <= 0) {
			System.out.println("스택이 비어있습니다.");
		}
		else {
			for(int i = 0; i < this.ptr; i++) {
				System.out.println(this.stk[i]);
			}
		}
	}
}