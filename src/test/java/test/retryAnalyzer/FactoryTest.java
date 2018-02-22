package test.retryAnalyzer;

import org.testng.ITest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.fail;

public class FactoryTest implements ITest {
    public static int m_count = 0;

    private String name;

    public FactoryTest(String name) {
        this.name = name;
    }

    @Override
    public String getTestName() {
        return name;
    }

    @Test(retryAnalyzer = MyRetry.class)
    public void someTest1(Method method) {
        System.out.println(method.getName() + " Called : " + this.name);
        if (name.contains("5")) {
            m_count++;
            fail();
        }
    }
}
