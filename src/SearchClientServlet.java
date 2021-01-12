import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.hotel.Client;
import mysql.hotel.ETClient;

@WebServlet("/searchClient")
public class SearchClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchClientServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/searchClient.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int age = Integer.parseInt(request.getParameter("age"));
			ArrayList<Client> clients = ETClient.findByAge(age);
			if(clients != null) {
		        request.setAttribute("clients", clients);
				getServletContext().getRequestDispatcher("/findClient.jsp").forward(request, response);
			}
			else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
		}
		catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
	}

}
