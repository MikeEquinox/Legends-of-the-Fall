package tmv_serializable_package;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Utils {

	byte[] byteArray = new byte[0];
	private Object obj;

	//method is serializing object and returning its copy
	byte[] copyObject(Object obj) {	
		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			System.out.println("Serializing succeded: " + obj);
			
			byteArray = baos.toByteArray();
			System.out.println("Serializing sequence: ");
			System.out.println(Arrays.toString(byteArray));
			System.out.println("Serializing length: ");
			System.out.println(byteArray.length);
			
		} catch (IOException e) {
			System.out.println("Serializing Error: " + e);
			//e.printStackTrace();
		}
		
		return byteArray;
		}
	
}
