import java.io.*;
public class Person implements Serializable {
	private String name;
	private String address;
	private int phone;
	
	public Person(String n, String a, int p) {
		name = n;
		address = a;
		phone = p;
	}
	
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Phone: " + phone);
	}
	
	public static void serialize(){
		Person persons[] = new Person[3];
		persons[0] = new Person("Ahmad", "Almarwah", 12356);
		persons[1] = new Person("Ali", "Alsafah", 12357);
		persons[2] = new Person("Aziz", "Almakkah", 12358);
		for(Person p : persons) {
			System.out.println("Object Info:");
			p.display();
		}
		try {
			FileOutputStream fileOut = new FileOutputStream("person.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(persons);
			out.close();
			fileOut.close();
			System.out.println("Array has been serialized");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deserialize() throws IOException, ClassNotFoundException{
		Person persons[] = new Person[3];
		try {
			FileInputStream fileIn = new FileInputStream("person.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			persons = (Person[]) in.readObject();
			in.close();
			fileIn.close();
		}
		finally {
			System.out.println("Array has been deserialized");
			for(Person p : persons) {
				p.display();
			}
		}
	}
	
	public static void main(String []args)  throws IOException, ClassNotFoundException{
		serialize();
		System.out.println("------------------------------");
		deserialize();
	}
}
