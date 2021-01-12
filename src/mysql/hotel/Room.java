package mysql.hotel;

import java.io.Serializable;

public class Room implements Serializable {

	private static final long serialVersionUID = 1L;	 
    private int id;
    private String type;
    private int number;
    
    public Room(){ }
    
    public Room(String type, int number){
        this.type = type;
        this.number = number;
    }
    public Room(int id, String type, int number){
         
        this.id = id;
        this.type = type;
        this.number = number;
    }
     
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
     
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
 
    public int getNumber() {
        return number;
    }
 
    public void setNumber(int number) {
        this.number = number;
    }
}