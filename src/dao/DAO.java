package dao;

import java.sql.SQLException;
import java.util.Collection;

import entidades.Cliente;
import entidades.Funcionario;

public interface DAO <T>{
	
	void save(T obj) throws SQLException, ClassNotFoundException;
	void update(T obj) throws ClassNotFoundException, SQLException;
	void remove(T obj) throws ClassNotFoundException, SQLException;
	T get(T id) throws ClassNotFoundException, SQLException;
	Collection<T> get() throws ClassNotFoundException, SQLException;
	Collection<T> get(String regex) throws ClassNotFoundException,SQLException;

}
