package TestNgFramework;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {

    @Test
    public void WebLoginHomeLoan() {
        System.out.println("Web Login Home Loan");
    }

    @Test
    public void Mobile1LoginHomeLoan() {
        System.out.println("Mobile Login Home Loan");
    }

    @Test(groups = {"Smoke"})
    public void SmokeTestCase3() {
        System.out.println("I belong to smoke test case 3");
    }

    @Test
    public void Mobile2LoginHomeLoan() {
        System.out.println("Mobile Login Home Loan");
    }

    @Test
    public void Mobile3LoginHomeLoan() {
        System.out.println("Mobile Login Home Loan 3");
    }

    @Test
    public void Mobile4LoginHomeLoan() {
        System.out.println("Mobile Login Home Loan");
    }

    @Test(dependsOnMethods = {"Mobile3LoginHomeLoan"})
    public void APILoginHomeLoan() {
        System.out.println("API Login Home Loan");
    }

    //We can use this to disable a test case from the report
    @Test(enabled = false)
    public void FalseMethod() {
        System.out.println("The code inside should not execute");
    }

    //To apply timeout for a particular test case, we can use timeOut attribute
    @Test(timeOut = 4000)
    public static void timeOutExample() {
        System.out.println("This will not fail till 4 seconds");
    }

    @Parameters({"URL"})
    @Test
    public static void ParameterTest(String url) {
        System.out.println(url);
    }
}
