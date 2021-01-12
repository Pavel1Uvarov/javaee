import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.hotel.Booking;
import mysql.hotel.ETBooking;

@WebServlet("/searchBooking")
public class SearchBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchBookingServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/searchBooking.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int number = Integer.parseInt(request.getParameter("number"));
			ArrayList<Booking> bookings = ETBooking.findByNumber(number);
			if(bookings != null) {
		        request.setAttribute("bookings", bookings);
				getServletContext().getRequestDispatcher("/findBooking.jsp").forward(request, response);
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
