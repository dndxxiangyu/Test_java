package huawei;

public class ArrayListClass {

	public static void main(String[] args) {
		Object[] a = new Object[0];
		
	}

}
class ArrayList<E> implements List<E>{
	private Object[] element;
	private int len;
	public ArrayList() {
		this(10);
	}
	public ArrayList(int size){
		//this.element = new Object[0];表示长度为0的object数组
		if(size < 0){
			throw new IllegalArgumentException("Illegal Capacity: " + size);
		}
		this.element = new Object[size];
		this.len = 0;
		
	}
	public boolean add(int index, E element) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean add(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}