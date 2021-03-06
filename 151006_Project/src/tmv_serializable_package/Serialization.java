package tmv_serializable_package;

/**
 * @author teleginmv
 * package shows serialization and deserialization
 * 
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public class Serialization {

	static class SerializationRejected {
		int strange = 7;
	}

	static class SerializationGranted implements Serializable {

		int real = 7;
		double real2 = 4.0;
		transient int notreal = 9;

		void printr(int number) {
			System.out.println(number);
			real = 19;
		}

	}

	public static void main(String[] args) {

		byte[] byteArray = new byte[0];

		System.out.println("Example of serializable object:");
		SerializationGranted sg = new SerializationGranted();
		SerializationGranted restored = new SerializationGranted();
		Utils utils = new Utils();
		// write object
		byteArray = utils.copyObject(sg);

		// restore object
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);

		try {
			ObjectInputStream ois = new ObjectInputStream(bais);
			restored = (SerializationGranted) ois.readObject();
			System.out.println("Deserializing succeded: " + restored);

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Deserializing Error: " + e);
			// e.printStackTrace();
		}
		System.out.println("Printing variables and executing method...");
		System.out.println("real: " + restored.real);
		System.out.println("real2: " + restored.real2);
		System.out.println("notreal(transient): " + restored.notreal);
		restored.printr(5);
		System.out.println("real: " + restored.real);

		System.out.println("Example of non-serializable object:");
		SerializationRejected sr = new SerializationRejected();
		utils.copyObject(sr);
		// System.out.println("The End");

	}
}

/*
 * import java.io.ByteArrayInputStream; import java.io.ByteArrayOutputStream;
 * import java.io.IOException; import java.io.ObjectInputStream; import
 * java.io.ObjectOutputStream; import java.io.Serializable; import
 * java.util.Arrays;
 * 
 * public class IOStreams {
 * 
 * static class B implements Serializable {
 * 
 * }
 * 
 * static class A implements Serializable {
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * String x = "Hello"; B b = new B();
 * 
 * }
 * 
 * public static void main(String[] args) {
 * 
 * ByteArrayOutputStream baos = new ByteArrayOutputStream();
 * 
 * byte[] byteArray = new byte[0];
 * 
 * try { ObjectOutputStream oos = new ObjectOutputStream(baos);
 * 
 * A a = new A();
 * 
 * oos.writeObject(a);
 * 
 * byteArray = baos.toByteArray();
 * 
 * System.out.println(Arrays.toString(byteArray));
 * System.out.println(byteArray.length);
 * 
 * for (byte b : byteArray) { char c = (char) b; System.out.print(c); }
 * System.out.println();
 * 
 * } catch (IOException e) { e.printStackTrace(); }
 * 
 * ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
 * 
 * try { ObjectInputStream ois = new ObjectInputStream(bais);
 * 
 * A a = (A) ois.readObject();
 * 
 * System.out.println(a.x);
 * 
 * } catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 * 
 * }
 */
