# High-level Test Case Automation Strategy

**Note:**
- Test cases marked with (*) are to be automated for the interview.

## Priority Summary

- **Highest Priority Test Cases:** 45
  - Automated: 17 (completed in 5 days)
  - Pending: 28

- **High Priority Test Cases:** 13
  - Pending for Manual & Automation

- **Medium Priority Test Cases:** 19
  - Pending Manual

## Estimated Timeline

- **Estimated remaining time for completion of all tasks:** 10-12 business days

## Test Case Overview

## Total Cases: 77

------

### HomePage

#### General Tests
- `homePageNavigatedTest(Highest)*`
- `imagesInHomePageVisibleTest(Highest)`
- `scrollBarFunctionalityToSpecificElementTest(Highest)`

#### Search Bar Functionalities
- `searchExistingProductTest(Highest)*`
- `productSuggestionDisplaysWhenLetterTypedTest(Medium)`
- `searchWithCategoryAndProductTest(Highest)`
- `allTypesDisplayedWhenAllCategorySelectedTest(High)`
- `selectedCategoryFromSearchDisplaysRespectiveItemsTest(Highest)`

#### HomePage Buttons Visibilities & Functionalities (Manually to be tested)
- `Shop By Category button(Medium)`
- `Home button(Medium)`
- `Special button(Medium)`
- `Blog button(Medium)`
- `Mega Menu button(High)`
- `AddOns button(High)`
- `My Account button(High)`
    - `Login button(Highest)(Automated)`
        - `loginFormDisplayedWhenLoginButtonClicked(Highest)`
    - `Register button(Highest)(Automated)`
        - `registerFormDisplayedWhenRegisterButtonClicked(Highest)`
- `Compare(Medium)`
- `Wishlist(Medium)`
    - `Wishlist number increases when product added(Medium)`
    - `Wishlist number decreases when product removed(Medium)`
- `Cart(Medium)`
    - `Cart number increases when product added(Medium)`
    - `Cart number decreases when product removed(Medium)`

### Register Page

- `registerFormAccessTest(Highest)*`
- `registerAccountWithMandatoryFieldsTest(Highest)*`
- `registerAccountWithAllFieldsWithNewsletterNoTest(Highest)`
- `errorMessagesForFieldsTest(Highest)*`
- `registerUserWithExistingEmailTest(Highest)*`
- `registerUserWithAlphaNumericPhoneNumberTest(Medium)`
- `registerUserWithoutClickingOnAgreePrivacyPolicyButtonTest(Highest)`

### Login Page

- `loginFormAccessTest(Highest)*`
- `loginWithValidCredentialsTest(Highest)*`
- `loginWithInvalidCredentialsTest(Highest)*`
    - `loginWithIncorrectPasswordTest(Highest)`
    - `loginWithInvalidUsernameAndValidPasswordTest(Highest)`
    - `loginWithInvalidUsernameAndPasswordTest(Highest)`
- `forgotPasswordLinkTest(Medium)`
- `loginWithEmptyFieldsTest(High)`
- `loginWithChangedPasswordTest(High)`

### Products Page

- `productsHavePriceAndNameTest(Highest)(asserted in homepage search test)`
- `sortByNameA-ZFunctionalityTest(Medium)`
- `sortByPriceLow-HighFunctionalityTest(High)`
- `addToCartButtonAddsProductToCartTest(Highest)*`
- `purchaseProductWithoutAddingToCartTest(Highest)`
- `wishListButtonAddsProductToWishListTest(Highest)*`
- `quickViewButtonShowsMoreDetailsTest(High)`
- `compareTwoProductsComparesSelectedProductsCorrectlyTest(Highest)*`
- `showNextPhotosOfProductTest(High)`
- `availabilityStatusIsDisplayedTest(Highest)`
- `defaultQuantityOfProductTest(Highest)`

### ShoppingCart Page

- `addItemToTheShoppingCartTest(Highest)*`
- `removeItemFromShoppingCardTest(Highest)*`
- `userCanAccessCheckOutPageFromShoppingCartTest(Highest)*`
- `updateShoppingCartProductQuantityTest(Medium)`
    - `updateShoppingCartWith0ProductsTest(Medium)`
    - `updateShoppingCartWith9999ProductsTest(Medium)`
- `imageNameModelQuantityUnitPriceTotalTest(Highest)`
- `homePageNavigationAfterClickContinueShoppingButtonTest(Medium)`
- `confirmVatTaxForEuCountryTest(Highest)`
- `flatShippingRateRecalculatedBasedOnSizeTest(Highest)`
- `termsAndConditionsCheckButtonTest(Highest)`

### CheckOut Page

- `phoneNumberMatchesUsersNumberTest(Highest)`
- `billingAddressDropDownAllowsSelectDifferentAddressTest(Highest)`
- `billingAddressToEqualUserAddressWhenBoxCheckedTest(Highest)`
- `newAddressCheckBoxProvidesNewAddressFieldsTest(High)`
- `checkOutWithValidAddressDetailsAndFieldsTest(Highest)*`

### Confirm Order Page

- `productNameModelQuantityPriceTotalTest(Highest)`
- `shippingAddressMatchUserAddressTest(Highest)`
- `shippingMethodTest(Highest)`
- `editButtonNavigatesToPreviousPageTest(Highest)`
- `successMessageAfterConfirmOrderTest(Highest)*`
