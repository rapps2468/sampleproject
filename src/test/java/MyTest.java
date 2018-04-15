import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MyTest {

    @Test
    public void testName() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        HelloWorld.print(new PrintStream(out));
        java.lang.String s = out.toString();
        Assert.assertEquals("Hello", s);
    }

}
