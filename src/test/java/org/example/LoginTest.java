package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;


    /**
     * Осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {

        // Определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        // Окно разворачивается на полный экран
        driver.manage().window().maximize();
        // Задержка на выполнение теста 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));

    }

    @Test
    public void loginTest() {
        //Ввод логина
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //Нажимаем по кнопке входа
        loginPage.clickLoginBtn();
        //Ввод пароля
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //Нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемый логин
        String user = profilePage.getUserName();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), user.toLowerCase());
    }


    @AfterClass
    public static void tearDown() {
        //Открываем меню пользователя
        profilePage.entryMenu();
        //Нажимаем кнопку "выйти"
        profilePage.userLogout();
        //закрываем браузер
        driver.quit();
    }
}
