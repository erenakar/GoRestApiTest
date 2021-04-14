package in.co.gorest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {
    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @AfterMethod
    public void spaceAfter() {
        System.out.println("");
    }
}
