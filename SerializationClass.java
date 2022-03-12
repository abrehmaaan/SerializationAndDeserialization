import java.io.*;
public class SerializationClass {
	public static void main(String[] main) {
		Person p = new Person("Ahmad", "Almarwah", 12356);
		System.out.println("Object Info:");
		p.display();
		try {
			FileOutputStream fileOut = new FileOutputStream("person.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(p);
			out.close();
			fileOut.close();
			System.out.println("Object has been serialized");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
