package pgdp.collections;

public interface Queue<T> extends DataStructure{
	public void enqueue(T x);
	public T dequeue();
}
