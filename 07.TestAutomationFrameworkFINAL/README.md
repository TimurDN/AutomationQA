# High-level Test Case Automation Strategy

---

- Note: An asterisk "*" indicates test cases to be automated for the interview.

---

### Highest Priority Test Cases (44)
- Automated: 19
- Pending: 24

### High Priority Test Cases (16)
- Pending for Manual & Automation

### Medium Priority Test Cases (16)
- Pending Manual

---------------------------------------------------------------------------
HomePage

	->homePageNavigatedTest(Highest)*
	->imagesInHomePageVisibleTest(Highest)
	->scrollBarFunctionalityToSpecificElementTest(Highest)

	-Search Bar Functionalities

		->searchExistingProductTest(Highest)*
		->productSuggestionDisplaysWhenLetterTypedTest(Medium)
		->searchWithCategoryAndProductTest(Highest)
		->allTypesDisplayedWhenAllCategorySelectedTest(High)
		->selectedCategoryFromSearchDisplaysRespectiveItemsTest(Highest)

	-HomePage Buttons Visibilities & Functionalities (Manually to be tested)

		-Shop By Category button(Medium)
		-Home button(Medium)
		-Special button(Medium)
		-Blog button(Medium)
		-Mega Menu button(High)
		-AddOns button(High)
		-My Account button(High)
			-Login button(Highest)(Automated)
				->loginFormDisplayedWhenLoginButtonClicked(Highest)
			-Register button(Highest)(Automated)
				->registerFormDisplayedWhenRegisterButtonClicked(Highest)
		-Compare(Medium)
		-Wishlist(Medium)
			->Wishlist number increases when product added(Medium)
			->Wishlist number decreases when product removed(Medium)
		-Cart(Medium)
			->Cart number increases when product added(Medium)
			->Cart number decreases when product removed(Medium)

Register Page

	-testRegisterFormAccessTest(Highest)*
	-testRegisterAccountWithMandatoryFields(Highest)*
	-testRegisterAccountWithAllFields(Highest)*
	-testErrorMessagesForFields(Highest)*
	-testRegisterUserWithExistingEmail(High)
	-testRegisterUserWithAlphaNumericPhoneNumber(Medium)
	-testRegisterUserWithoutClickingOnAgreePrivacyPolicyButton(Highest)

Login Page

	-testLoginFormAccess(Highest)*
	-testLoginWithValidCredentials(Highest)*
	-testLoginWithInvalidCredentials(Highest)*
		-loginWithIncorrectPasswordTest(Highest)
		-loginWithInvalidUsernameAndValidPasswordTest(Highest)
		-loginWithInvalidUsernameAndPasswordTest(Highest)
	-forgotPasswordLinkTest(Medium)
	-testLoginWithEmptyFieldsTest(High)
	-loginWithChangedPasswordTest(High)

Products Page

	-productsHavePriceAndNameTest(Highest)*(tested in search)
	-sortByNameA-ZFunctionalityTest(Medium)
	-sortByPriceLow-HighFunctionalityTest(High)
	-addToCartButtonAddsProductToCartTest(Highest)*
	-purchaseProductWithoutAddingToCartTest(Highest)
	-wishListButtonAddsProductToWishListTest(High)
	-quickViewButtonShowsMoreDetailsTest(High)
	-compareTwoProductsComparesSelectedProductsCorrectlyTest(Highest)*
	-showNextPhotosOfProductTest(Highest)*
	-availabilityStatusIsDisplayedTest(Highest)
	-defaultQuantityOfProductTest(Highest)


ShoppingCart Page

	-addItemToTheShoppingCartTest(Highest)*
	-removeItemFromShoppingCardTest(Highest)*
	-updateShoppingCartProductQuantityTest(Highest)*
		-updateShoppingCartWith0ProductsTest(High)
		-updateShoppingCartWith9999ProductsTest(High)
	-imageNameModelQuantityUnitPriceTotalTest(Highest)*
	-homePageNavigationAfterClickContinueShoppingButtonTest(Medium)
	-confirmVatTaxForEuCountryTest(Highest)
	-flatShippingRateRecalculatedBasedOnSize(Highest)
	-termsAndConditionsCheckButtonTest(Highest)

CheckOut Page

	-phoneNumberMatchesUsersNumberTest(Highest)
	-bilingAddressDropDownAllowsSelectDifferentAddressTest(Highest)
	-billingAddressToEqualUserAddressWhenBoxCheckedTest(Highest)
	-newAddressCheckBoxProvidesNewAddressFields(High)
	-checkOutWithValidAddressDetailsAndFieldsTest(Highest)*

Confirm Order Page

	-productNameModelQuantityPriceTotalTest(Highest)
	-shippingAddressMatchUserAddressTest(Highest)
	-shippingMethodTest(Highest)
	-editButtonNavigatesToPreviousPageTest(Highest)
	-successMessageAfterConfirmOrderTest(Highest)*




