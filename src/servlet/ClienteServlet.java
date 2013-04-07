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
			if (Facade.getClienteByCpf(cpf) != null)
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
		return false;

	}

	private boolean removeCliente(HttpServletRequest request,
			HttpServletResponse response) {

		String cpf = request.getParameter("cpf");
		try {
			Facade.remove(cpf);
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
			ArrayList<String> aux = new ArrayList<>();
			String arg = request.getParameter("arg");
			String ind = request.getParameter("indicador");
			try {
				clientes = Facade.getCliente();
				for (String cliente : clientes) {
					if ( cliente.toUpperCase().contains((ind +": " + arg).toUpperCase())) {
						System.out.println(cliente.toString());
						aux.add(cliente);
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			return aux;

	}

	private ArrayList<String> getClientes() {

		try {
			return Facade.getCliente();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("lista", getClientes());
		request.setAttribute("tipo", "Clientes");
		request.getRequestDispatcher("lista.jsp")
				.forward(request, response);
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if (flag.equalsIgnoreCase("cadastrar")) {

			if (cadastrarCliente(request, response))
				request.setAttribute("cad", "cliente cadastrado com sucesso");
			else
				request.setAttribute("cad", "erro ao tentar cadastrar cliente");
			request.getRequestDispatcher("cadCliente.jsp").forward(request,
					response);
		}

		if (flag.equals("remover")) {
			if (removeCliente(request, response))
				request.setAttribute("remv", "cliente removido com sucesso");
			else
				request.setAttribute("remv", "erro ao tentar remover cliente");
			request.getRequestDispatcher("removCliente.jsp").forward(request,
					response);
		}

		if (flag.equalsIgnoreCase("pesquisar")) {
			ArrayList<String> clientes = pesquisaCliente(request, response);
			request.setAttribute("lista", clientes);
			request.setAttribute("tipo", "Clientes");
			request.getRequestDispatcher("lista.jsp")
					.forward(request, response);
		}

	}
}
