package utils;

import pages.HomePage;

public class Pages {
    private HomePage homePage;

    public Pages() {
        homePage = new HomePage();
    }

    public HomePage getHomePage() {return homePage;}
}
