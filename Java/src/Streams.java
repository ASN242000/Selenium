import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
	public static void main(String args[]) {
		List <String> a = new ArrayList<String>();
		a.add("Ankitha");
		a.add("Nagendra");
		a.add("Sudha");
		a.add("Anusha");
		
		//Printing the count of names starting with "A" by converting list to stream
		long b = a.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(b);
		
		//Doing same as above by directly using streams
		long z = Stream.of("Ankitha", "Nagendra", "Sudha","Anusha").filter(v -> v.startsWith("A")).count();
		
		System.out.println(z);
		
		a.stream().filter(s -> s.length() > 6).forEach(s -> System.out.println(s));
		
		a.stream().filter(s -> s.startsWith("A")).limit(1).forEach(s -> System.out.println(s));
		
		//print names ending with "a" in uppercase
		
		Stream.of("Ankitha", "Nagendra", "Sudha","Anusha", "Unknown").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		
		Stream.of("Ankitha", "Nagendra", "Sudha","Anusha", "Unknown").filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).sorted().forEach(s -> System.out.println(s));
		
		//To merge 2 streams
		
		List <String> n = new ArrayList<String>();
		n.add("He He");
		n.add("Smile");
		n.add("Happy");
		n.add("He");
		
		Stream <String> merged = Stream.concat(a.stream(), n.stream());
		merged.sorted().forEach(s -> System.out.println(s));
		
		Stream <String> newS = Stream.of("Apple", "Mango", "Grapes", "Watermelon");
		
		boolean flag = newS.anyMatch(s -> s.equalsIgnoreCase("Apple"));
		
		System.out.println(flag);
		
		//Create list, convert into stream and perform operations and then convert the results of the stream into list
		
		List <String> convert = Stream.of("Ankitha", "Nagendra", "Sudha","Anusha", "Unknown").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println("*********************");
		System.out.println(convert);
		
		System.out.println("***********************");
		//print unique number from array and sort it and get the value at 2th index
		
		List <Integer> values = Arrays.asList(3,5,2,5,2,6,8,6,1,5,7,9,2,0);
		
		List <Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(1));
		System.out.println("*****************");
		System.out.println(li);
	}
}
