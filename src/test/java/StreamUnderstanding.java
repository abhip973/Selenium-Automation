import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamUnderstanding {
    public static void main(String[] args) {

        List<String> names = new ArrayList<String>();
        names.add("Ansh");
        names.add("Ishan");
        names.add("Sanya");
        names.add("Abhishek");
        names.add("Gaurav");

        //We can directly create a stream and start working on it
        Stream.of("RIDDHI", "KARTIK", "ANJU").forEach(s -> System.out.println(s.toLowerCase()));

        Long namesCount = StreamFilter(names);
        StreamNames(names);
        System.out.println("Number of names starting with alphabet A are " + namesCount);
    }

    public static Long StreamFilter(List<String> names) {

        //Print the count of number of names starting with A
        Long namesCount = names.stream().filter(s -> s.startsWith("A")).count();
        return namesCount;
    }

    public static void StreamNames(List<String> names) {

        //Print each name with length greater than 4
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

    }
}
