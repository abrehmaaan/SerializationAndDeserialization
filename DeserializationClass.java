import java.io.*;
public class DeserializationClass {
	public static void main(String [] args) throws IOException, ClassNotFoundException{
		Person p = null;
		try {
			FileInputStream fileIn = new FileInputStream("person.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			p = (Person) in.readObject();
			in.close();
			fileIn.close();
		}
		finally {
			System.out.println("Object has been deserialized");
			p.display();
		}
	}
}
