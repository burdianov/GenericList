package main;

public class Main {

	public static void main(String[] args) {
		
		// exemplu cu stringuri
		MyList<String> myStringList = new MyList<>();
		
		myStringList.addElement("Curcan");
		myStringList.addElement("Sacal");
		myStringList.addElement("Ivanov nu-i acasa");
		
		for (int i = 0; i < myStringList.getElementCount(); i++) {
			System.out.println(myStringList.getElementByIndex(i));
		}
		
		// exemplu cu obiecte
		MyList<Cat> myCatList = new MyList<>();
		
		myCatList.addElement(new Cat("Pincer", 20));
		myCatList.addElement(new Cat("Meunica", 18));
		
		for (int i = 0; i < myCatList.getElementCount(); i++) {
			System.out.println("\n*****");
			System.out.println("Name: " + myCatList.getElementByIndex(i).getName());
			System.out.println("Name: " + myCatList.getElementByIndex(i).getAge());
		}
	}
}
