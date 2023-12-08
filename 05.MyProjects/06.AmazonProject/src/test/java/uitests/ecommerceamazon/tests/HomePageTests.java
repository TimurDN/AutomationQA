package uitests.ecommerceamazon.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommerceamazon.base.BaseTestAmazon;

import java.io.IOException;

import static ecommerceamazon.HomePage.HomePageAmazon.*;

public class HomePageTests extends BaseTestAmazon {

    @BeforeEach
    public void setupForTests() {
        homePageAmazon.navigateToPage();
        homePageAmazon.refreshPage();

    }

    @Test
    public void siteCrawlShopByDepartment() throws InterruptedException {
        ///will move clicks from here to pages
        homePageAmazon.homePageElements().hamburgerMenuButton().click();
        homePageAmazon.homePageElements().seeAllButtonInHamburgerMenu().click();

        homePageAmazon.brokenLinks();
        closeFileWriter();
    }

}
