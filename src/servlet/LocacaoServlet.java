package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Facade;

/**
 * Servlet implementation class LocacaoServlet
 */

public class LocacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocacaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	private boolean cadastrarPromocao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			String nome = request.getParameter("nome");
			String valor = request.getParameter("valor");
			int dia = Integer.parseInt(request.getParameter("dia"));
			int mes = Integer.parseInt(request.getParameter("mes"));
			int ano = Integer.parseInt(request.getParameter("ano"));
			Facade.cadastrarPromocao(nome, Double.parseDouble(valor), dia, mes,	ano);
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
	
	private boolean removeLocacao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
		try {
			int id = Integer.parseInt(request.getParameter("cod"));
			if( Facade.removeLocacao(id) )
				return true;
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	private ArrayList<String> getLocacoes(){
		
		try {
			ArrayList<String> locacoes = Facade.getLocacoes();
			return locacoes;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private int realizaLocacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	 try {
		   String cliente = request.getParameter("cpf");
		   String funcionario = request.getParameter("mat");
		   String produto = request.getParameter("id");
		   Date d = new Date(Calendar.getInstance().getTimeInMillis());
		  return Facade.locarProduto(cliente, funcionario, d, (short)Integer.parseInt(produto) );
	} catch (Exception e) {
		// TODO: handle exception
	}
		return 0;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("login")!=null) {
		request.setAttribute("lista", getLocacoes());
		request.setAttribute("tipo", "Locacoes");
		request.getRequestDispatcher("lista.jsp")
				.forward(request, response); 
		}
		else
			response.sendRedirect("index.jsp?erro=1");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		
		switch (flag) {
		
		case "promocao":
			if( cadastrarPromocao(request, response)){
				request.setAttribute("promocao", "cadastrada com sucesso");
				request.getRequestDispatcher("cadPromocao.jsp").forward(request, response);
			}
			
			else{
				request.setAttribute("promocao", "erro ao tentar cadastrar promocao");
				request.getRequestDispatcher("cadPromocao.jsp").forward(request, response);
			}
				
			break;
			
		case "locar":	
				if ( realizaLocacao(request, response) > 0 ) {
					System.out.println("legal");
					request.setAttribute("locacao", "produto locado com sucesso");
					request.getRequestDispatcher("cadlocacao.jsp").forward(request, response);
				}
				else{
					System.out.println("merda");
					request.setAttribute("locacao", "erro ao tentar locar produto");
					request.getRequestDispatcher("cadlocacao.jsp").forward(request, response);
				}
		
			
			break;
			
		case "remover":
			if( removeLocacao(request, response)){
				request.setAttribute("locacao", "locacao removida com sucesso");
				request.getRequestDispatcher("removLocacao.jsp").forward(request, response);
			}
			else{
				request.setAttribute("locacao", "erro ao tentar remover locacao");
				request.getRequestDispatcher("removLocacao.jsp").forward(request, response);
			}
			
		case "devolver":
			System.out.println("out");
			
			try {
				request.setAttribute("lista",Facade.Extrato(request.getParameter("cpf"), 
						Integer.parseInt(request.getParameter("multa"))));
				request.getRequestDispatcher("lista.jsp").forward(request, response);
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
			
			request.setAttribute("tipo", "locacao");
			request.getRequestDispatcher("lista.jsp").forward(request, response);
			
			break;

		default:
			break;
		}
		
		
		
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println(Facade.Extrato("05065096481", 0));
	}
}
