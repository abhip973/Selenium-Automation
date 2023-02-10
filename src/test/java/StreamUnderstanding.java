import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamUnderstanding {
    public static void main(String[] args) {

        StreamUnderstanding streamUnderstanding = new StreamUnderstanding();
        List<String> names = new ArrayList<String>();
        names.add("Ansh");
        names.add("Ishan");
        names.add("Sanya");
        names.add("Abhishek");
        names.add("Gaurav");

        streamUnderstanding.MergeLists(names);

        //We can directly create a stream and start working on it
        System.out.println("Directly creating a stream and printing in lowercase");
        Stream.of("RIDDHI", "KARTIK", "ANJU").forEach(s -> System.out.println(s.toLowerCase()));

        Long namesCount = StreamFilter(names);
        StreamNames(names);
        StreamMap();
        System.out.println("Number of names starting with alphabet A are " + namesCount);
    }

    public static Long StreamFilter(List<String> names) {

        //Print the count of number of names starting with A
        Long namesCount = names.stream().filter(s -> s.startsWith("A")).count();
        return namesCount;
    }

    public static void StreamNames(List<String> names) {

        //Print each name with length greater than 4
        System.out.println("name with length greater than 4 are:");
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

        //Print single name with length greater than 4 characters
        System.out.println("single name with length greater than 4 characters:");
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

    }

    public static void StreamMap() {
        //Print names which have last character as a and print in uppercase
        System.out.println("Names which have last character as a and print in uppercase");
        Stream.of("Abhishek", "Sanya", "Rajesh", "Anju", "Tripta").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //Print names which have first letter as a with uppercase and sorted
        System.out.println("Names which have first letter as a with uppercase and sorted");
        String[] namesArray = {"Anju", "Sanya", "Rajesh", "Abhishek", "Tripta"};
        List<String> names = Arrays.asList(namesArray);
        names.stream().filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).sorted().forEach(s -> System.out.println(s));
    }

    public void MergeLists(List<String> names) {

        //Merge two different lists and print their output in sorted order
        String[] schoolFriendsArray = {"Ekansh", "Vinayak", "Kartik", "Nirbhay"};

        Stream<String> schoolFriendsStream = Arrays.stream(schoolFriendsArray);

        Stream<String> namesMerged = (Stream.concat(schoolFriendsStream, names.stream()));

        System.out.println("After streams are merged, names in sorted order is as follows");
//        namesMerged.sorted().forEach(s -> System.out.println(s));

        //Verify if any given name is present in our stream
        Boolean flag = namesMerged.anyMatch(s -> s.equalsIgnoreCase("Nirbhay"));
        System.out.println(flag);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(flag);
        softAssert.assertAll();

    }
}
