import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Formatter;
import java.util.Properties;
import java.util.logging.*;

public class HelloWorld {

    static {
        setupLogger();
    }

    private static Logger LOGGER;

    public static void main(String[] args) {
        print(System.out);
    }

    public static void print(PrintStream out) {
        out.println("Hello, World!");
        LOGGER.setLevel(Level.INFO);
        LOGGER.warning("Hello, World log!");
    }

    public static void setupLogger() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            System.setProperty("java.util.logging.SimpleFormatter.format",
                    "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

            FileHandler handler = new FileHandler("test.log", 490000, 5);
            SimpleFormatter formatter = new SimpleFormatter();
            handler.setFormatter(new SimpleFormatter());
            LOGGER = Logger.getLogger(HelloWorld.class.getName());
            LOGGER.addHandler(handler);     // for your code..
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}