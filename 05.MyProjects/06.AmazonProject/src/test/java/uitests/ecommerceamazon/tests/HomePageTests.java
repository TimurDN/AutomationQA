package uitests.ecommerceamazon.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommerceamazon.base.BaseTestAmazon;

public class HomePageTests extends BaseTestAmazon {

    @BeforeEach
    public void setupForTests(){
        homePageAmazon.navigateToPage();
    }

    @Test
    public void homePageNavigatedTest() {
        homePageAmazon.homePageAssertions().assertHomePageNavigated();

    }

    @Test
    public void searchBarVisibleAndClickableTest(){
        homePageAmazon.clickOnEmptySearchbar();
        homePageAmazon.homePageAssertions().assertSearchBarVisibleAndClickable();
    }

    @Test
    public void homePageAmazonLogoVisibleTest(){
        homePageAmazon.homePageAssertions().assertHomePageLogo();
    }

    @Test
    public void todayDealsButtonVisibleTest(){
        homePageAmazon.homePageAssertions().assertTodaysDealsButton("Today's Deals");
    }

    @Test
    public void registryButtonVisibleTest(){
        homePageAmazon.homePageAssertions().assertTodaysDealsButton("Registry");
    }

    @Test
    public void customerServiceButtonVisibleTest(){
        homePageAmazon.homePageAssertions().assertTodaysDealsButton("Customer Service");
    }

    @Test
    public void giftCardsButtonVisibleTest(){
        homePageAmazon.homePageAssertions().assertTodaysDealsButton("Customer Service");
    }

    @Test
    public void sellButtonVisibleTest(){
        homePageAmazon.homePageAssertions().assertTodaysDealsButton("Sell");
    }

    @Test
    public void accountButtonVisibleTest(){
        homePageAmazon.homePageAssertions().assertHomeAccountButton();
    }

    @Test
    public void ordersButtonVisibleTest(){
        homePageAmazon.homePageAssertions().assertOrdersButton();
    }

    @Test
    public void shoppingCartButtonVisibleTest(){
        homePageAmazon.homePageAssertions().assertShoppingCartButton();
    }

    @Test
    public void languageButtonVisibleTest(){
        homePageAmazon.homePageAssertions().assertHomeLanguageButton();
    }

    @Test
    public void defaultLanguageVisibleTest(){
        homePageAmazon.homePageAssertions().assertHomeDefaultLanguage("EN");
    }

}
