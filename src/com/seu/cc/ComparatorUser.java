package com.seu.cc;
import java.util.Arrays;
import java.util.Comparator;


public class ComparatorUser implements Comparator<User>{

	public static void main(String[] args) {
		 User[] users = new User[] { new User("u1001", 25),  
	                new User("u1002", 20), new User("u1003", 21) };  
	        Arrays.sort(users, new ComparatorUser());  
	        for (int i = 0; i < users.length; i++) {  
	            User user = users[i];  
	            System.out.println(user.getId() + " " + user.getAge());  
	        }
	        float a = 1;
	        int b=1;
	        
	}

	public int compare(User o1, User o2) {
		
		return o1.getAge() - o2.getAge();  
	}

}
class User {

	private String id;
	private int age;

	public User(String id, int age) {
		this.id = id;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}