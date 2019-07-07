package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterface {

	public static void main(String[] args) {

		//Declare a set interface

		Set<String> numbers = new HashSet<String>();
		numbers.add("One");
		numbers.add("Two");
		numbers.add("One");
		numbers.add("Three");
		System.out.println(numbers);


		//Declare a set interface

		Set<String> numbersTree = new LinkedHashSet<String>();
		numbersTree.add("One");
		numbersTree.add("Two");
		numbersTree.add("One");
		numbersTree.add("Three");
		System.out.println(numbersTree);
	}

}
