package huawei;

public interface List<E> {
	boolean isEmpty();
	int size();
	E get(int index);
	E set(int index,E element);
	boolean add(int index,E element);
	boolean add(E element);
	E remove(int index);
	void clear();
}
