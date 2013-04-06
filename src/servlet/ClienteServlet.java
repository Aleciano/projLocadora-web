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
 * Servlet implementation class ClienteServlet
 */
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClienteServlet() {
		super();

	}

	private boolean cadastrarCliente(HttpServletRequest request,
			HttpServletResponse response) {

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String cep = request.getParameter("cep");
		String email = request.getParameter("email");
		String fone = request.getParameter("fone");
		String cel = request.getParameter("cel");
		try {
			Facade.cadastrarCliente(cpf, nome, logradouro,
					Integer.parseInt(numero), bairro, cidade, cep, email, fone,
					cel);
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

	private boolean removeCliente(HttpServletRequest request,
			HttpServletResponse response) {

		String cpf = request.getParameter("cpf");

		try {
			Facade.remove(cpf);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	private ArrayList<String> pesquisaCliente(HttpServletRequest request,
			HttpServletResponse response) {

		ArrayList<String> clientes = new ArrayList<>();
		try {
			
			clientes = Facade.getCliente();
			String botaoPesq = null;
			if ((botaoPesq = request.getParameter("botaoPesqcpf")) == null) 
				botaoPesq = request.getParameter("botaoPesqNome");
			for( String cliente : clientes ){
				if(!cliente.contains(botaoPesq))
					clientes.remove(cliente);
			}
			
			return clientes;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private ArrayList<String> getClientes(){
			
		try {
			return Facade.getCliente();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if(flag.equalsIgnoreCase("cadastrar")){
			if(cadastrarCliente(request, response))
				request.setAttribute("cadastro", "sucesso");
				response.sendRedirect("cadCliente2.html");
//			else {
//				request.setAttribute("erro", "cliente já cadastrado");
//				request.getRequestDispatcher("erro.jsp").forward(request, response);
//			}
		}
			
		
		if (flag.equalsIgnoreCase("remover")){
			if(removeCliente(request, response)){
				System.out.println("entrou");
				request.setAttribute("cliente", "removido");
				response.sendRedirect("WEB-INF/menu.html");
			}
//			else {
//				request.setAttribute("erro","cliente nao existe");
//				request.getRequestDispatcher("erro.jsp").forward(request, response);
//			}
		}
		
		if (flag.equalsIgnoreCase("pesquisar")){
			ArrayList<String> clientes = pesquisaCliente(request, response);
			request.setAttribute("clientes", clientes);
			request.getRequestDispatcher("WEB-INF/listaClientes.jsp").forward(request, response);
		}
		
		if (flag.equalsIgnoreCase("listar")){
			request.setAttribute("lista", getClientes());
			request.getRequestDispatcher("WEB-INF/listaClientes.jsp").forward(request, response);
			
		}
	}

}
