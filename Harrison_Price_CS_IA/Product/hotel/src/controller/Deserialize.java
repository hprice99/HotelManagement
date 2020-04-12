package controller;
import model.*;

import java.util.LinkedList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialize {

	// Declare the linked list
	private LinkedList l;
	
	private static final long serialVersionUID = 1L;
	
	// Constructor
	public Deserialize(){
		
	}
	
	// Method to deserialize the list
	public LinkedList DeserializeList(String fileName){
		try{
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			l = (LinkedList)in.readObject();
			in.close();
			fileIn.close();
			
			System.out.println("Deserialized "  + fileName);
			
			// Return the list so that toString can be used
			return l;
		} catch(IOException i){
			i.printStackTrace();
			return l;
		} catch(ClassNotFoundException c){
			System.out.println("Class not found");
			c.printStackTrace();
			return null;
		}
	}
}
