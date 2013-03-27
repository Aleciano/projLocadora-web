package test;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Cliente;
import entidades.Funcionario;
import entidades.DVD;
import dao.DAO;
import dao.Facade;


public class Teste {
	
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		/*ArrayList<DVD> dvds = (ArrayList<DVD>) Facade.getDVD("matrix");
		System.out.printf("\n%d",dvds.size());
		for(DVD value: dvds){
			System.out.println("\noi");
			System.out.println( value.toString());
			
		} */
		Cliente cls = Facade.getCliente("06755773");
		if(cls!=null) System.out.print(cls.toString());
		else System.out.print("Cliente não consta na base de dado");
	}

}
