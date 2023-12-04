package uitests.ecommerceamazon.tests;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import uitests.ecommerceamazon.base.BaseTestAmazon;

public class HomePageTests extends BaseTestAmazon {

    @Test
    public void homePageNavigatedTest() {

        homePageAmazon.navigateToPage();
        homePageAmazon.homePageAssertions().assertHomePageNavigated();

    }

    @Test
    public void searchBarVisibleAndClickableTest(){
        homePageAmazon.navigateToPage();
        homePageAmazon.clickOnEmptySearchbar();
        homePageAmazon.homePageAssertions().assertSearchBarVisibleAndClickable();
    }

}
