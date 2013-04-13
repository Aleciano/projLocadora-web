package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Facade;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getSession().invalidate();
    	response.sendRedirect("index.jsp");
    }
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		String pagina = "index.jsp?erro=1";
		
		if (Facade.validarLogin(login, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			pagina = "menu.jsp";
		}
		else {
			 request.getSession().invalidate();
			}
		
		response.sendRedirect(pagina);	
	}

}
