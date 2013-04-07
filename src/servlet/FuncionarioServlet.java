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
 * Servlet implementation class FuncionarioServlet
 */
public class FuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private boolean cadastra(HttpServletRequest request,
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
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		try {
			Facade.cadastrarFuncionario(nome, cpf, logradouro,
					Integer.parseInt(numero), bairro, cidade, cep, email, fone,
					cel, login, senha);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ArrayList<String> funcionarios = Facade.getFuncionarios();
			request.setAttribute("lista", funcionarios);
			request.setAttribute("tipo", "Funcionarios");
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

		if (cadastra(request, response))
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
