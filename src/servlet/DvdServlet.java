package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Facade;

/**
 * Servlet implementation class DvdServlet
 */
public class DvdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DvdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean cadastrar(HttpServletRequest request,
			HttpServletResponse response)  {

		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		String qtm = request.getParameter("qt");
		String duracao = request.getParameter("duracao");
		String sinopse = request.getParameter("sinopse");
		String qtcopias = request.getParameter("qtcopias");
		

			try {
				for (int i = 1; i <= Integer.parseInt(qtcopias); i++){
					Facade.cadastrarDvd(titulo, genero, (short) Integer.parseInt(qtm),
						Integer.parseInt(duracao), sinopse); 
					System.out.println("passou");
					}
				return true;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		
		
	}

	private boolean remover(HttpServletRequest request,	HttpServletResponse response){
		
		String id = request.getParameter("cod");
		try {
			Facade.removeDVD(Integer.parseInt(id));
			return true;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	private void pesquisar(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException{
		
		String nome  = request.getParameter("nome");
		try {
			ArrayList<String> dvds = Facade.getDVDs();
			for(String s : dvds){
				if(!s.toLowerCase().contains(nome.toLowerCase()))
					dvds.remove(s);
			}
			request.setAttribute("dvds", dvds);
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
private void listar(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException{
			
		try {
			ArrayList<String> dvds = Facade.getDVDs();
			request.setAttribute("dvds", dvds);
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		switch (flag) {
		case "cadastrar":
			
		if ( cadastrar(request, response ) ){
			request.setAttribute("cadastro", "sucesso");
			response.sendRedirect("cadDVD.html");
		}
			break;

		case "remover":
			
			if(remover(request, response)){
				request.setAttribute("DVD", "removido com sucesso");
				response.sendRedirect("removDVD.html");
			}
			break;
			
		case "pesquisar":
			
			pesquisar(request, response);
			
			break;
			
		case "listar":
			
			listar(request, response);
			
			
			break;
			
		default:
			break;
		}	
		
	}

}
