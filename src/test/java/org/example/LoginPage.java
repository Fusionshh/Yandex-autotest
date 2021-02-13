package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /**
     * Конструктор класса, занимающийся инициализацикй полей класса
     */

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Определение локатора поля ввода логина
     */
    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginField;
    /**
     * Определение локатора кнопки входа в аккаунт
     */
    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginBtn;
    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwdField;

    /**
     * Метод для ввода логина
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    /**
     * Метод для ввода пароля
     */
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    /**
     * Метод для осуществелния нажатия кнопки входа
     */
    public void clickLoginBtn() {
        loginBtn.click();
    }
}

