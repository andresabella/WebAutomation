import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {

        WebDriver driver;
        @BeforeClass
        public static void setupClass() {
            WebDriverManager.chromedriver().setup();
        }

        @Before
        public void setupTest() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        @After
        public void teardown(){

            if (driver != null) {
                driver.quit();

                }
            else {
                System.out.println("No se finalizó la sesión correctamente");
            }
        }

    }





