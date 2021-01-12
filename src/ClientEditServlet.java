import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.hotel.Client;
import mysql.hotel.ETClient;

@WebServlet("/editClient")
public class ClientEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Client client = ETClient.pickClient(id);
            if(client!=null) {
                request.setAttribute("client", client);
                getServletContext().getRequestDispatcher("/editClient.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            Client client = new Client(id, name, age);
            ETClient.redact(client);
            response.sendRedirect(request.getContextPath() + "/client");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
        }
    }
}