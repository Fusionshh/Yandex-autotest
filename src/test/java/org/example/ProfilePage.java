package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора меню пользователя
     */
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/a[1]/span[1]")
    private WebElement userMenu;
    /**
     * определение локатора кнопки выхода из аккаунта
     */
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/ul/ul/li[6]/a/span")
    private WebElement logoutBtn;

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[1]" +
                "/div[2]/div/div/div[1]/div/div[1]/div[2]/div")));
        return userMenu.getText();
    }

    /**
     * метод для нажатия кнопки меню пользователя
     */
    public void entryMenu() {
        userMenu.click();
    }

    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        logoutBtn.click();
    }
}

