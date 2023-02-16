package TestNgFramework;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {

    @Test
    public void Demo() {
        System.out.println("Hello Again");
    }

    @BeforeTest
    public void BeforeTestExample() {
        System.out.println("I will run at the beginning");
    }


    @Test
    public void FailTestCase() {
        Assert.assertTrue(false);
        System.out.println("Hi");
    }

    @AfterTest
    public void AfterTestExample() {
        System.out.println("I will run at the end of the folder scope");
    }

    @Test(groups = {"Smoke"})
    public void SmokeTestCase1() {
        System.out.println("I belong to smoke test case 1");
    }


}
