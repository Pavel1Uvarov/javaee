package mysql.hotel;
 
import java.sql.*;
import java.util.ArrayList;
 
public class ETBooking {
 
	static String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=Europe/Kiev&allowPublicKeyRetrieval=true&useSSL=false";
    private static String username = "root";
    static String password = "asd417018";
    
    public static ArrayList<Booking> pick() {
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Booking");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int number = resultSet.getInt(3);
                    Booking booking = new Booking(id, name, number);
                    bookings.add(booking);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return bookings;
    }
    
    public static Booking pickBooking(int id) {
    	Booking booking = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM Booking WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int bookingId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int number = resultSet.getInt(3);
                        booking = new Booking(bookingId, name, number);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return booking;
    }
    
    public static ArrayList<Booking> findByNumber(int number) {
    	ArrayList<Booking> bookings = new ArrayList<Booking>();
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    		try (Connection conn = DriverManager.getConnection(url, username, password)){
    			String sql = "SELECT * FROM Booking WHERE number=?";
    			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
    				preparedStatement.setInt(1, number);
    				ResultSet resultSet = preparedStatement.executeQuery();
    				while(resultSet.next()) {
    					int id = resultSet.getInt(1);
    					String name = resultSet.getString(2);
    					int bookingNumber = resultSet.getInt(3);
    					Booking booking = new Booking(id, name, bookingNumber);
    					bookings.add(booking);
    				}
    			}
    		}
    	}
    	catch(Exception ex){
            System.out.println(ex);
        }
    	return bookings;
    }
    
    public static int appendNew(Booking booking) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO Booking (name, number) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, booking.getName());
                    preparedStatement.setInt(2, booking.getNumber());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int redact(Booking booking) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE Booking SET name = ?, number = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, booking.getName());
                    preparedStatement.setInt(2, booking.getNumber());
                    preparedStatement.setInt(3, booking.getId());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    
    public static int extract(int id) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "DELETE FROM Booking WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

}