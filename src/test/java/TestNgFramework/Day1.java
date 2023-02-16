package TestNgFramework;

import org.testng.annotations.*;

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

    @BeforeMethod
    public void BeforeMethodExample() {
        System.out.println("I will run before every method in Day1 class");
    }

    @AfterMethod
    public void AfterMethodExample(){
        System.out.println("I will run after every method in Day1 class");
    }

    @BeforeClass
    public void BeforeClassExample() {
        System.out.println("I will run before day1 class execution is started");
    }

    @AfterClass
    public void AfterClassExample() {
        System.out.println("I will run after day1 class execution is completed");
    }

    @Test(groups = {"Smoke"})
    public void SmokeTestCase2(){
        System.out.println("I belong to smoke test case 2");
    }
}
