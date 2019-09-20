import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Punto1 {
	
	
	/*
	 *  The Stream API allows data to be processed declaratively. It defines several operations that can be grouped 
	 *  into two categories: 
	 *  (i) intermediate operations such as filter, sorted and map;
	 *  (ii) terminal operations such as collect.
	 *  
	 *  The stream operations that can be connected to each other are called intermediate operations.
	 *  They can be chained because their output is of type Stream<T>.
	 * 
	 * 	Operations that close a stream process are called terminal operations. 
	 * 	From a stream they produce a result of type Collection, List, Set or Map.
	 * 
	 * 	In view of the above, stream is not a data structure instead it takes input from Collections, Arrays, Maps or I/O channels
	 * 	and perform a serie of intermediate operations (for this specific example a filtering by pattern)
	 * 	to finally by a terminal operation store the result in a data structure.
	 * 
	 */
	
	public List<String> filterList(List<String> list, String regex) {
	    return list.stream().filter(s -> s.matches(regex)).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		Punto1 app = new Punto1(); 
		String regex = "^(.+)@hotmail.com$";
		List<String> emails = Arrays.asList("alejita@hotmail.com", "alisson95@outlook.com",
	           								"lisof95@gmail.com", "konachan10@hotmail.com");
		app.filterList(emails, regex).forEach(System.out::println);
	}

}
