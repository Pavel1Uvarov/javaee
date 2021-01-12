import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import mysql.hotel.ETBooking;
 
@WebServlet("/extractBooking")
public class ExtractBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));          
            ETBooking.extract(id);
            response.sendRedirect(request.getContextPath() + "/booking");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}