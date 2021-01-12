package mysql.hotel;

import java.io.Serializable;

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;	 
    private int id;
    private String name;
    private int age;
    
    public Client(){ }
    
    public Client(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Client(int id, String name, int age){
         
        this.id = id;
        this.name = name;
        this.age = age;
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
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
}