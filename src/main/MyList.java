package main;

public class MyList<T> {
	
	// cream un masiv de obiecte generice, dar o sa-l initializam in addElement
	private T[] elements;
	// pastram lungimea masivului in proprietatea length
	// pe care o initializam cu zero
	private int length = 0;

	// deoarece o sa facem casting din obiecte de tip Object in generic T, 
	// folosim @SuppressWarnings("unchecked") ca sa nu ne enerveze warning-ul
	// care o sa apara mereu in ochi, insa programa o sa lucreze si fara aceasta anotatie
	@SuppressWarnings("unchecked")
	// cream metoda addElement, care primeste ca argument un obiect generic
	// si il adaugam in masivul elements ce contine obiecte generice
	public void addElement(T element) {
		// incrementam length
		length++;
		// in cazul cand masivul cu generice (adica elements) are numai un element,
		// initializam masivul; totodata ii dam lungimea de 1
		// si-i aplicam acestui element valoarea argumentului (element)
		if (length == 1) {
			// initializam masivul elements; aici la prima vedere se pare ca se
			// poate de initializat asa: elements = new T[length];
			// insa cu genericile asa truc nu merge, deaceea suntem nevoiti
			// cream un masiv de obiecte cu lungimea length (in cazul dat length == 1)
			// si dupa aceea facem casting din masiv de Object in masiv de T
			// adica din masiv de Object in masiv de generice, dupa cum ne trebuie
			// astfel obtinem un masiv de generice cu lungimea de 1
			// si valoarea acestui element este null
			elements = (T[]) new Object[length];
			// mai departe, deoarece masivul elements e deja initializat cu un element
			// (care initial are valoarea null), putem sa-i acordam acestui
			// element valoarea argumentului; astfel masivul nostru de generice
			// in cazul dat o sa aiba un element care vine din argument
			elements[length - 1] = element;
		} else {
			// Acum straduie-te sa te concentrezi la logica actiunilor
			// care vrem sa le luam:
			// * masivul nostru de baza se numeste elements;
			// * initial noi l-am creat cu un element
			// * cu parere de rau, nu se poate de adaugat elemente la masive primitive
			// * deaceea trebuies sa recurgem la metode din categoria 
			// * cum spun rusii "Танцы с бубнами":
			// * cream alt masiv temporar care o sa contina 
			// * cu un element mai mult decat masivul elements
			// * acum parca e bun, avem un masiv cu un element in plus, insa
			// * toate elementele acestui masiv temporar o sa fie egale cu null 
			// * deci, am ajuns la urmatoarele:
			// * avem doua masive - unul care contine elementele corecte, insa
			// * la care nu se poate de adaugat nici un element in plus
			// * si alt masiv care are deja un extra element, insa toate elementele
			// * lui is egale cu null. acum trebuie cumva sa le combinam.
			// * procedam astfel: setam valoarea ultimului element a
			// * masivului temporar cu elementul primit ca argument al metodei
			// * dupa aceea intr-un loop copiem toate elementele masivului elements
			// * in masivul temporar.
			// * astfel, masivul temporar o sa contina tot ce trebuie
			// * si la urma copiem referinta obiectului temporar in elements
			// * astfel elements o sa contina toate elementele adaugate pana acum

			// cream masivul temporar cu numarul de elemente == length (toate null)
			T[] tempElements = (T[]) new Object[length];
			// ultimului element a masivului ii dam valoarea argumentului
			tempElements[length - 1] = element;
			// copiem toate elementele din elements in tempElements
			for (int i = 0; i < length - 1; i++) {
				tempElements[i] = elements[i];
			}
			// schimbam referinta lui elements cu tempElements
			// adica elements deja o sa contina toate elementele
			elements = tempElements;
		}
	}
	// aici deja e elementar, intoarcem elementul dupa index
	// insa ii facem cast in generic
	public T getElementByIndex(int index) {
		return (T) elements[index];
	}
	
	// aici e inca mai simplu, intoarcem lungimea masivului nostru
	public int getElementCount() {
		return elements.length;
	}
}
