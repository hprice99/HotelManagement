package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Serialize {

	private static final long serialVersionUID = 1L;
	
	public Serialize(LinkedList z, String fileName){
	
		// Serialize the data
				try{
					FileOutputStream fileOut = new FileOutputStream(fileName);
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(z);
					out.close();
					fileOut.close();
					
					// Return to show that the data has been saved
					System.out.println("Data saved");
				} catch(IOException i){
					i.printStackTrace();
				}
	}
}
