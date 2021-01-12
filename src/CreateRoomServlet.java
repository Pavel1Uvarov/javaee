import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.hotel.Room;
import mysql.hotel.ETRoom;
 
@WebServlet("/createRoom")
public class CreateRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        getServletContext().getRequestDispatcher("/createRoom.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        try {
            String type = request.getParameter("type");
            int number = Integer.parseInt(request.getParameter("number"));
            Room room = new Room(type, number);
            ETRoom.appendNew(room);
            response.sendRedirect(request.getContextPath()+"/room");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/createRoom.jsp").forward(request, response); 
        }
    }
}