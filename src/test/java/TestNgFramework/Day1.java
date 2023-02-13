package TestNgFramework;

import org.testng.annotations.Test;

public class Day1 {

    //@Test annotation helps us to run test without java compiler
    @Test
    public void FirstTest() {
        System.out.println("Hello World");
    }

    @Test
    public void SecondTest() {
        System.out.println("Bye World");
    }
}
