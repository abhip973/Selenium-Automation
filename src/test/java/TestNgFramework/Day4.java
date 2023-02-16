package TestNgFramework;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Day4 {
    @Test
    public void WebLoginPersonalLoan() {
        System.out.println("Web Login Personal Loan");
    }

    @Test
    public void MobileLoginPersonalLoan() {
        System.out.println("Mobile Login Personal Loan");
    }

    @Test
    public void APILoginPersonalLoan() {
        System.out.println("API Login Personal Loan");
    }

    @BeforeSuite
    public void BeforeSuiteExample() {
        System.out.println("I will run before the suite is run");
    }
    @AfterSuite
    public void AfterSuiteExample() {
        System.out.println("I will run after the suite is run");
    }
}
