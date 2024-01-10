package pgdp.collections;

public interface DataStructure {
	int size();
	default boolean isEmpty() {
		if(size( )== 0)
			return true;
		return false;
	}
	
}
