package dao;

import java.util.Collection;

public interface DAO <T>{
	
	void save(T obj);
	void update(T obj);
	void remove(T obj);
	T get(T id);
	Collection<T> get();
	Collection<T> get(String regex);

}
