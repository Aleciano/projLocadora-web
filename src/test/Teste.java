package test;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Cliente;
import entidades.Funcionario;
import entidades.DVD;
import dao.DAO;
import dao.Facade;


public class Teste {
	int i=0;
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ArrayList<DVD> dvds = (ArrayList<DVD>) Facade.getDVD("Matrix");
		
		for(DVD value: dvds){
			
			System.out.printf(value.getNome());
			
		}
	}

}
