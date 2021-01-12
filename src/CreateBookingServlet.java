import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.hotel.Booking;
import mysql.hotel.ETBooking;
 
@WebServlet("/createBooking")
public class CreateBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        getServletContext().getRequestDispatcher("/createBooking.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            int number = Integer.parseInt(request.getParameter("number"));
            Booking booking = new Booking(name, number);
            ETBooking.appendNew(booking);
            response.sendRedirect(request.getContextPath()+"/booking");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/createBooking.jsp").forward(request, response); 
        }
    }
}