package mysql.hotel;

import java.io.Serializable;

public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;	 
    private int id;
    private String name;
    private int number;
    
    public Booking(){ }
    
    public Booking(String name, int number){
        this.name = name;
        this.number = number;
    }
    public Booking(int id, String name, int number){
         
        this.id = id;
        this.name = name;
        this.number = number;
    }
     
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
     
    public String getName() {
        return name;
    }
 
    public void setFirstName(String name) {
        this.name = name;
    }
 
    public int getNumber() {
        return number;
    }
 
    public void setNumber(int number) {
        this.number = number;
    }
}