package nine_Stack;

public class IntStack {
	private int max;		//���� �뷮	:: ���ÿ� ���� �� �ִ� �ִ� ������ ��
	private int ptr;		//���� ������	:: ���ÿ� �׿� �ִ� ������ ����
	private int stk[];		//���� ��ü	:: ���� ��ü�� �����ϴ� �迭 ����
	
	//���� �� ���� : ������ �������
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() { };
	}
	
	//���� �� ���� : ������ ���� ��
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() { };
	}
	
	//������
	public IntStack(int capacity) {
		this.ptr = 0;
		this.max = capacity;
		try	{
			this.stk = new int[max];			//���� ��ü�� �迭�� ����
		} catch(OutOfMemoryError e)	{
			this.max = 0;						//������ �� ����
			System.out.println("ERROR : " + e.getMessage());
		}
	}
	
	//���ÿ� x�� Ǫ��
	public int push(int x) throws OverflowIntStackException	{
		if(this.ptr >= max) {							//������ ���� �� ��� ���� �߻�
			throw new OverflowIntStackException();
		}
		return this.stk[this.ptr++];
	}
	
	//���ÿ��� �����͸� ��(���� �ִ� �����͸� ����)
	public int pop() throws EmptyIntStackException	{
		if(this.ptr < 0) {						//������ ����ִٸ�
			throw new EmptyIntStackException();
		}
		return this.stk[--this.ptr];
	}
	
	//���ÿ��� �����͸� ��ũ(���� �ִ� �����͸� �鿩�ٺ�)
	public int peek() throws EmptyIntStackException {
		if(this.ptr < 0) {
			throw new EmptyIntStackException();
		}
		return this.stk[this.ptr - 1];
	}
	
	//���ÿ��� x�� ã�� �ε���(������ -1)�� ��ȯ
	public int indexOf(int x) {
		for (int i = this.ptr - 1; i >= 0; i--) {		//�����ʿ��� ���� �˻�
			if(this.stk[i] == x) {
				return i;
			}
		}
		return -1;
	}
	
	//������ ���
	public void clear()	{
		this.ptr = 0;
	}
	
	//������ �뷮�� ��ȯ
	public int capacity() {
		return this.max;
	}
	
	//���ÿ� �׿� �ִ� ������ ���� ��ȯ
	public int size() {
		return this.ptr;
	}
	
	//������ ����ִ��� Ȯ��
	public boolean isEmpty() {
		return this.ptr <= 0;
	}
	
	//������ ���� ã���� Ȯ��
	public boolean isFull()	{
		return this.ptr >= this.max;
	}
	
	//���� ���� ��� �����͸� �ٴ� -> ����� ������ ���
	public void dump() {
		if(this.ptr <= 0) {
			System.out.println("������ ����ֽ��ϴ�.");
		}
		else {
			for(int i = 0; i < this.ptr; i++) {
				System.out.println(this.stk[i]);
			}
		}
	}
}
