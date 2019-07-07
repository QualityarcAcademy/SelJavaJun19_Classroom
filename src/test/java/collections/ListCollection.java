package collections;

import java.util.ArrayList;
import java.util.List;

public class ListCollection {

	public static void main(String[] args) {

		//Declare a list
		List<String> numbers = new ArrayList<String>();
		
		//Adding elements
		numbers.add("One");
		numbers.add("Two");
		numbers.add("One");
		
		System.out.println(numbers);
		
		//iterate
		for (String number : numbers) {
			System.out.println(number);
			
		}
		
		System.out.println(numbers.contains("two"));

	}

}
