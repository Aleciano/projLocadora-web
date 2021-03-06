package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	}

	private boolean cadastrar(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException  {
		request.setCharacterEncoding("UTF-8");
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
					}
				return true;
			} catch (Exception e) {
				e.printStackTrace();			
				return false;
			}
			
		
		
	}

	private boolean remover(HttpServletRequest request,	HttpServletResponse response){
		
		String id = request.getParameter("cod");
		try {
			    if(Facade.getDVD(Integer.parseInt(id)) == null)
			    	return false;
				Facade.removeDVD(Integer.parseInt(id));
				return true;
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
			return false;
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return false;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	private void pesquisar(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException{
		
		String nome  = request.getParameter("nome");
		try {
			ArrayList<String> dvds = Facade.getDVDs();
			ArrayList<String> aux = new ArrayList<>();
			for(String s : dvds){
				if(s.toLowerCase().contains(nome.toLowerCase()))
					aux.add(s);
			}
			request.setAttribute("lista", aux);
			request.setAttribute("tipo", "DVDS");
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
private void listar(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException{
			
	try {
		ArrayList<String> dvds = Facade.getDVDs();
		request.setAttribute("lista", dvds);
		request.setAttribute("tipo", "DVDS");
		request.getRequestDispatcher("lista.jsp").forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
	}


	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("login")!=null) {
		listar(request, response);
		}
		else
			response.sendRedirect("index.jsp?erro=1");
		
	}





	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		switch (flag) {
		case "cadastrar":
			
		if ( cadastrar(request, response ) ){
			request.setAttribute("cadastro", "cadastrado com sucesso");
			
		}
		else request.setAttribute
			("cadastro", "falha ao tentar cadastrar");
		
		request.getRequestDispatcher("cadDVD.jsp").forward(request, response);
			break;

		case "remover":
			
			if(remover(request, response)){
				request.setAttribute("dvd", "DVD removido com sucesso");
			}
			else
				request.setAttribute("dvd", "Falha ao tentar remover DVD. .");
			
			request.getRequestDispatcher("removDVD.jsp").forward(request, response);
			break;
			
		case "pesquisar":
			
			pesquisar(request, response);
			
			break;
			
		default:
			break;
		}	
		
	}

}
