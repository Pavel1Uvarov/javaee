package mysql.hotel;
 
import java.sql.*;
import java.util.ArrayList;
 
public class ETClient {
 
	static String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=Europe/Kiev&allowPublicKeyRetrieval=true&useSSL=false";
    private static String username = "root";
    static String password = "asd417018";
    
    public static ArrayList<Client> pick() {
        ArrayList<Client> clients = new ArrayList<Client>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Client");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int age = resultSet.getInt(3);
                    Client client = new Client(id, name, age);
                    clients.add(client);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return clients;
    }
    
    public static Client pickClient(int id) {
    	Client client = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM Client WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int clientId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int age = resultSet.getInt(3);
                        client = new Client(clientId, name, age);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return client;
    }
    
    public static ArrayList<Client> findByAge(int age) {
    	ArrayList<Client> clients = new ArrayList<Client>();
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    		try (Connection conn = DriverManager.getConnection(url, username, password)){
    			String sql = "SELECT * FROM Client WHERE age=?";
    			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
    				preparedStatement.setInt(1, age);
    				ResultSet resultSet = preparedStatement.executeQuery();
    				while(resultSet.next()) {
    					int id = resultSet.getInt(1);
    					String name = resultSet.getString(2);
    					int clientAge = resultSet.getInt(3);
    					Client client = new Client(id, name, clientAge);
    					clients.add(client);
    				}
    			}
    		}
    	}
    	catch(Exception ex){
            System.out.println(ex);
        }
    	return clients;
    }
    
    public static int appendNew(Client client) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO Client (name, age) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, client.getName());
                    preparedStatement.setInt(2, client.getAge());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int redact(Client client) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE Client SET name = ?, age = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, client.getName());
                    preparedStatement.setInt(2, client.getAge());
                    preparedStatement.setInt(3, client.getId());
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
                String sql = "DELETE FROM Client WHERE id = ?";
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