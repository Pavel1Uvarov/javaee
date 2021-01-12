import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.hotel.Room;
import mysql.hotel.ETRoom;

@WebServlet("/room")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        ArrayList<Room> rooms = ETRoom.pick();
        request.setAttribute("rooms", rooms);
          
        getServletContext().getRequestDispatcher("/room.jsp").forward(request, response);
    }
}