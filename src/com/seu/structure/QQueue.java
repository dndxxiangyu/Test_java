package com.seu.structure;

public interface QQueue<E> {
	boolean isEmpty();
	boolean enqueue(E element);
	E dequeue();
}
