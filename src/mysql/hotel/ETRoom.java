package mysql.hotel;
 
import java.sql.*;
import java.util.ArrayList;
 
public class ETRoom {
 
	static String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=Europe/Kiev&allowPublicKeyRetrieval=true&useSSL=false";
    private static String username = "root";
    static String password = "asd417018";
    
    public static ArrayList<Room> pick() {
        ArrayList<Room>  rooms = new ArrayList<Room>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Room");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String type = resultSet.getString(2);
                    int number = resultSet.getInt(3);
                    Room room = new Room(id, type, number);
                    rooms.add(room);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return rooms;
    }
    
    public static Room pickRoom(int id) {
    	Room room = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM Room WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int roomId = resultSet.getInt(1);
                        String type = resultSet.getString(2);
                        int number = resultSet.getInt(3);
                        room = new Room(roomId, type, number);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return room;
    }
    
    public static ArrayList<Room> findByType(String type) {
    	ArrayList<Room> rooms = new ArrayList<Room>();
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    		try (Connection conn = DriverManager.getConnection(url, username, password)){
    			String sql = "SELECT * FROM Room WHERE type=?";
    			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
    				preparedStatement.setString(1, type);
    				ResultSet resultSet = preparedStatement.executeQuery();
    				while(resultSet.next()) {
    					int id = resultSet.getInt(1);
    					String roomType = resultSet.getString(2);
    					int number = resultSet.getInt(3);
    					Room room = new Room(id, roomType, number);
    					rooms.add(room);
    				}
    			}
    		}
    	}
    	catch(Exception ex){
            System.out.println(ex);
        }
    	return rooms;
    }
    
    public static int appendNew(Room room) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO Room (type, number) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, room.getType());
                    preparedStatement.setInt(2, room.getNumber());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int redact(Room room) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE Room SET type = ?, number = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, room.getType());
                    preparedStatement.setInt(2, room.getNumber());
                    preparedStatement.setInt(3, room.getId());
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
                String sql = "DELETE FROM Room WHERE id = ?";
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