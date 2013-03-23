package dao;

import java.util.ArrayList;
import java.util.Collection;

import entidades.Cliente;

public class ClienteDAO implements DAO<Cliente> {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	@Override
	public void save(Cliente obj) {
		clientes.add(obj);
		
	}

	@Override
	public void update(Cliente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Cliente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente get(Cliente id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cliente> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cliente> get(String regex) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
