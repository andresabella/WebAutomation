import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Compra extends BaseTest{


    @Test
    public void Compra() throws InterruptedException {

        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement womenOption = driver.findElement(By.xpath("//a[@title='Women']"));
        if (womenOption.isDisplayed()) {
            womenOption.click();
            System.out.println("Ingreso correctamenbte a la pestaña Women");

        } else {
            System.out.println("No se encontró la pestaña Women");

        }


        Actions action1 = new Actions(driver);

        WebElement selectFirstItem = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img"));
        if (selectFirstItem.isDisplayed()) {
            Thread.sleep(2000);
            action1.moveToElement(selectFirstItem).moveToElement(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]"))).click().build().perform();
            System.out.println("Agregó correctamente el primer item");

        } else {
            System.out.println("No se agregó el primer item");

        }

        Thread.sleep(2000);

        WebElement closeItem1 = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span"));
        if (closeItem1.isDisplayed()) {
            closeItem1.click();
            System.out.println("Puede continuar agregando productos");
        } else {
            System.out.println("No se puede continuar agregando productos");

        }

        Actions action2 = new Actions(driver);

        WebElement selectSecondItem = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));
        if (selectSecondItem.isDisplayed()) {
            Thread.sleep(2000);
            action2.moveToElement(selectSecondItem).moveToElement(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]"))).click().build().perform();
            System.out.println("Agregó correctamente el segundo item");

        } else {
            System.out.println("No se agregó el segundo item");

        }

        Thread.sleep(2000);
        WebElement goToCheckOut = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
        if (goToCheckOut.isDisplayed()) {
            goToCheckOut.click();
            System.out.println("Ingresó correctamente al CheckOut");
        } else {
            System.out.println("No ingresó al CheckOut");

        }

        String shoppingCartSummary = driver.findElement(By.xpath("//*[@id=\"cart_summary\"]/tbody")).getText();
        System.out.println("Los Productos agregados son: " + shoppingCartSummary);

        WebElement loginOption = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        if (loginOption.isDisplayed()) {
            loginOption.click();
            System.out.println("Se encuentra en la página de Login");
        } else {
            System.out.println("No ingreso a la página de Login");

        }

    }

}