package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Facade;

/**
 * Servlet implementation class FuncionarioServlet
 */
public class FuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private boolean cadastrar(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
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
				return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	

	}
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("login")!=null) {
		try {
			ArrayList<String> funcionarios = Facade.getFuncionarios();
			request.setAttribute("lista", funcionarios);
			request.setAttribute("tipo", "Funcionarios");
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		else
			response.sendRedirect("index.jsp?erro=1");
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (cadastrar(request, response)) {
			request.setAttribute("cadastro", "funcionario cadastrado com sucesso");
			request.getRequestDispatcher("cadFunc.jsp").forward(request, response);
		}
		
		else{ 
			request.setAttribute("cadastro", "erro ao tentar cadastrar funcionario");
			request.getRequestDispatcher("cadFunc.jsp").forward(request, response);
		}
			
	}

}
