# High-level Test Case Automation Strategy

**Note:**
- Test cases marked with (*) are to be automated for the interview.

## Priority Summary

- **Highest Priority Test Cases:** 86
  - Creating Strategy & Automated Tests*: 17 (completed in 5 days(2 days planning, 3 days automating))
  - (See surefire report in target/site)
  - Pending for manual and automation: 69

- **High Priority Test Cases:** 27
  - Pending for Manual & Automation: 27

- **Medium&Low Priority Test Cases:** 48 / 16
  - Pending Manual: 64

## Estimated Timeline

- **Estimated remaining time for completion of all tasks:** 14-16 business days

## Test Case Overview

## Total Cases: 177

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
- `refreshButtonTest(High)`
- `shoppingCartPageMaxCartItemTest(Medium)`
- `useCouponCodePlusButtonTest(Medium)`
- `useCouponCodeValidCouponTest(Medium)`
- `useCouponCodeInvalidCouponTest(Medium)`
- `useCouponCodeMaxCharacterTest(Medium)`
- `useGiftCertificateValidCouponTest(Medium)`
- `useGiftCertificateInvalidCouponTest(Medium)`
- `useGiftCertificateMaxCharacterTest(Medium)`
- `useGiftCertificateWithCouponCodeTest(Medium)`
- `countryDropDownShowsSupportedCountriesTest(Highest)`
- `regionStateDisplaysByCountryTest(High)`
- `getQuotesRequiresFillingRequiredFieldsTest(Highest)`
- `postCodeLowerBoundaryTest(Highest)`
- `postCodeHigherBoundaryTest(Highest)`
- `postCodeInvalidCharsTest(Medium)`
- `getQuotesPopUpTitleTest(Highest)`
- `flatRateCalculationTest(Highest)`
- `cancelFlatRateDoesNotApplyTaxTest(Highest)`
- `applyShippingTaxWhenApplyButtonClickedTest(Highest)`
- `displayedFlatShippingRateAmountAddedToSubTotalTest(Highest)`
- `successMessageAfterAddingFlatShippingRateTest(Medium)`
- `continueShoppingButtonTest(Medium)`

### CheckOut Page

- `phoneNumberMatchesUsersNumberTest (Priority: Highest)`
- `billingAddressDropDownAllowsSelectDifferentAddressTest (Priority: Highest)`
- `billingAddressToEqualUserAddressWhenBoxCheckedTest (Priority: Highest)`
- `newAddressCheckBoxProvidesNewAddressFieldsTest (Priority: High)`
- `checkOutWithValidAddressDetailsAndFieldsTest (Priority: Highest)*`
- `checkOutWithLoggedInUserTest(Highest)`
- `checkOutWithGuestAccountTest(Highest)`
- `registerAccountThroughCheckoutPageAndCheckOutTest(Medium)`
- `loginThroughCheckoutPageAndCheckOutTest(Medium)`
- `yourPersonalDetailsFormTests(Highest)`
  - `validFirstNameLowestBoundaryTest(Highest)`
  - `validFirstNameHighestBoundaryTest(Highest)`
  - `invalidFirstNameTest(Medium)`
  - `validLastNameLowestBoundaryTest(Highest)`
  - `validLastNameHighestBoundaryTest(Highest)`
  - `invalidLastNameTest(Medium)`
  - `validPhoneNumberLowestBoundaryTest(Highest)`
  - `validPhoneNumberHighestBoundaryTest(Highest)`
  - `invalidPhoneNumberTest(Medium)`
  - `alphaNumericPhoneNumberTest(High)`
  - `validPassword&ConfirmPasswordLowestBoundaryTest(Highest)`
  - `validPassword&ConfirmPasswordHighestBoundaryTest(Highest)`
  - `invalidLongPassword&ConfirmPasswordTest(Highest)`
  - `password&ConfirmPasswordIsNotVisibleTest(Highest)`
  - `wrongConfirmPasswordTypedTest(High)`
- `billingAddressTests(Highest)`
  - `validCompanyLowestBoundaryTest(Medium)`
  - `validCompanyHighestBoundaryTest(Medium)`
  - `invalidCompanyErrorMessageTest(Medium)`
  - `validAddressLowestBoundaryTest(Highest)`
  - `validAddressHighestBoundaryTest(Highest)`
  - `invalidAddressErrorMessageTest(Highest)`
  - `validCityLowestBoundaryTest(High)`
  - `validCityHighestBoundaryTest(High)`
  - `invalidCityErrorMessageTest(High)`
  - `validPostCodeLowestBoundaryTest(High)`
  - `validPostCodeHighestBoundaryTest(High)`
  - `invalidPostCodeErrorMessageTest(Medium)`
  - `countryDropDownDisplaysAllSupportedCountriesTest(High)`
  - `regionStateDisplayedByCountryTest(High)`
- `shippingAddressFormDisplayedWhenMyDeliverAndBillingAddressSameCheckBoxUncheckedTest(High)`
- `cashOnDeliveryOptionTest(Highest)`
- `flatShippingRateAppliedAsPerCountryTest(Highest)`
- `imageProductNameQuantityUnitPriceTotalDisplayedCorrectlyTest(Highest)`
- `quantityRefreshButtonTest(High)`
- `checkingOutWithMultipleSameItemsTest(High)`
- `checkingOutWithMultipleDifferentItemsTest(High)`
- `unitAndTotalPriceUpdatedWhenQuantityUpdatedTest(Highest)`
- `useCouponCodePlusButtonTest(Medium)`
- `useCouponCodeValidCouponTest(Medium)`
- `useCouponCodeInvalidCouponTest(Medium)`
- `useCouponCodeMaxCharacterTest(Medium)`
- `useGiftCertificateValidCouponTest(Medium)`
- `useGiftCertificateInvalidCouponTest(Medium)`
- `useGiftCertificateMaxCharacterTest(Medium)`
- `useGiftCertificateWithCouponCodeTest(Medium)`
- `flatShippingRateDisplaysCorrectWhenAppliedTest(Highest)`
- `vatTaxCalculatedCorrectlyAsPerCountryTest(Highest)`
- `addingValidCommentLowestBoundaryTest(Low)`
- `addingValidCommentLowestBoundaryTest(Low)`
- `addingInvalidCommentTest(Low)`
- `proceedCheckOutWithoutAgreeTermsAndPrivacyPolicyTest(Highest)`

### Confirm Order Page

- `productNameModelQuantityPriceTotalTest(Highest)`
- `shippingAddressMatchUserAddressTest(Highest)`
- `shippingMethodTest(Highest)`
- `editButtonNavigatesToPreviousPageTest(Highest)`
- `successMessageAfterConfirmOrderTest(Highest)*`
