package TestNgFramework;

import org.testng.Assert;
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
    public void AfterMethodExample() {
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
    public void SmokeTestCase2() {
        System.out.println("I belong to smoke test case 2");
    }

    @Test(dataProvider = "setData")
    public static void voidUsingDataProvider(String userName, String password) {
        System.out.println(userName);
        System.out.println(password);
    }

    @DataProvider
    public static Object[][] setData() {
        /*Suppose we have 3 data sets to check a test case:
        1st combination - username, password, good credit history
        2nd combination - username, password, no credit history
        3rd combination - username, password, bad credit history
         */

        /*With DataProvider annotation we always create an object[][], the dimension of the object
        is decided as follows:
        Total number of data sets will be our row, in this case 3
        Total number of values will be our column, in this case 2
         */

        Object[][] data = new Object[3][2];

        //1st combination
        data[0][0] = "firstUserName";
        data[0][1] = "firstPassword";

        //2nd combination
        data[1][0] = "secondUserName";
        data[1][1] = "secondPassword";

        //3rd combination
        data[2][0] = "thirdUserName";
        data[2][1] = "thirdPassword";

        return data;
    }
}
