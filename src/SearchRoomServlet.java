import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.hotel.Room;
import mysql.hotel.ETRoom;

@WebServlet("/searchRoom")
public class SearchRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchRoomServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/searchRoom.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String type = request.getParameter("type");
			ArrayList<Room> rooms = ETRoom.findByType(type);
			if(rooms != null) {
		        request.setAttribute("rooms", rooms);
				getServletContext().getRequestDispatcher("/findRoom.jsp").forward(request, response);
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
