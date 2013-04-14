package servlet;

import java.io.IOException;
import java.sql.Date;
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
        
    }

	private boolean cadastrarPromocao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
//			request.setCharacterEncoding("UTF-8");
			String nome = request.getParameter("nome");
			String valor = request.getParameter("valor");
			int dia = Integer.parseInt(request.getParameter("dia"));
			int mes = Integer.parseInt(request.getParameter("mes"));
			int ano = Integer.parseInt(request.getParameter("ano"));
			Facade.cadastrarPromocao(nome, Double.parseDouble(valor), dia, mes,	ano);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}

	}
	
//	private boolean removeLocacao(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//			
//		try {
//			 int id = Integer.parseInt(request.getParameter("cod"));
//			if( Facade.removeLocacao(id) )
//			 return true; 
//			else return false;
//			} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		
//		
//	}

	private ArrayList<String> getLocacoes(){
		
		try {
			ArrayList<String> locacoes = Facade.getLocacoes();
			return locacoes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	private int realizaLocacao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			String cliente = request.getParameter("cpf");
			String funcionario = request.getParameter("mat");
			String produto = request.getParameter("id");
			Date d = new Date(Calendar.getInstance().getTimeInMillis());
			if (Facade.getPromocaoAberta() != null) {
				request.setAttribute("promocao", Facade.getPromocaoAberta().getNome());
				request.setAttribute("valor", Facade.getPromocaoAberta().getValor());
			}
			return Facade.locarProduto(cliente, funcionario, d,
					(short) Integer.parseInt(produto));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

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
					
					request.setAttribute("locacao", "produto locado com sucesso");
					request.getRequestDispatcher("cadlocacao.jsp").forward(request, response);
				}
				else{
					request.setAttribute("locacao", "Erro ao tentar locar produto! Verifique se os dados estão corretos e se o produto está disponível.");
					request.getRequestDispatcher("cadlocacao.jsp").forward(request, response);
				}
		
			
			break;
			
//		case "remover":
//			if( removeLocacao(request, response)){
//				request.setAttribute("locacao", "locacao removida com sucesso");
//				request.getRequestDispatcher("removLocacao.jsp").forward(request, response);
//			}
//			else{
//				request.setAttribute("locacao", "erro ao tentar remover locacao");
//				request.getRequestDispatcher("removLocacao.jsp").forward(request, response);
//			}
//			
//			break;
		case "devolver":
			
			
			try {
				
				ArrayList<String> aux = Facade.Extrato(request.getParameter("cod"), Integer.parseInt(request.getParameter("multa")));
				request.setAttribute("locacoes", aux);
				request.getRequestDispatcher("finalizalocacoes.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("tipo", "locacao");
				request.getRequestDispatcher("lista.jsp").forward(request, response);
			}
			
			
			
			break;
			
		case "encerrar" :
			
			String[] locacao = request.getParameterValues("encerrar");
			for(int i = 0; i < locacao.length; i++){
				String id = locacao[i].split(",")[0].split(" ")[1];
				double valor1 = Double.parseDouble(locacao[i].split("Valor: ")[1].split(",")[0]);
				double valor2 = Double.parseDouble(locacao[i].split("valor: ")[1].split(",")[0]);
				
				try {
					
					Facade.FinalizarLocacao(Integer.parseInt(id), valor1+valor2);
					request.getRequestDispatcher("menu.jsp").forward(request, response);
					
				} catch (Exception e) {
					e.printStackTrace();
					request.getRequestDispatcher("menu.jsp").forward(request, response);
					
				} 
				
			}
		

			break;
		default:
			break;
		}
		
		
		
		
	}

	
}
