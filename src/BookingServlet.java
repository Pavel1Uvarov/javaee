import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.hotel.Booking;
import mysql.hotel.ETBooking;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        ArrayList<Booking> bookings = ETBooking.pick();
        request.setAttribute("bookings", bookings);
          
        getServletContext().getRequestDispatcher("/booking.jsp").forward(request, response);
    }
}