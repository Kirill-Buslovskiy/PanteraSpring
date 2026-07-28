package com.javarush.lesson22;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

class AUTDemoTest {

    public static final String HOME_PAGE = "http://localhost:8080";
    public static final String loginField = "//input[@id='login']";
    public static final String passwordField = "//input[@id='password']";
    public static final String buttonSubmit = "//button[@id='loginUser']";
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private static final String loginValue = "Carl";
    private static final String passwordValue = "admin";

    @BeforeEach
    void setUp() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false);
        browser = playwright.chromium().launch(launchOptions);
        BrowserContext context = browser.newContext(new Browser.NewContextOptions());
        page = context.newPage();
    }

    @Test
    @DisplayName("When user set login and password then see admin panel")
    void whenUserSetLoginAndPasswordThenSeeAdminPanel() {
        //given
        page.navigate(HOME_PAGE);
        page.waitForLoadState();
        //when
        Page.WaitForSelectorOptions timeout = new Page.WaitForSelectorOptions().setTimeout(5_000);
        page.waitForSelector(loginField, timeout).fill(loginValue);
        page.waitForSelector(passwordField).fill(passwordValue);
        page.waitForSelector(buttonSubmit).click();

        ElementHandle editLink = page.waitForSelector("//div/a[@href='/users/1']");
        String linkText = editLink.textContent();
        //then
        Assertions.assertEquals("Edit 1.", linkText);

        // ...... and so on ......

    }

    @AfterEach
    void tearDown() {
        browser.close();
        playwright.close();
    }
}