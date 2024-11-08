using AutomationFramework.Helpers;
using OpenQA.Selenium;

namespace AutomationFramework
{
    public class BasePage
    {
        // Keeps WebDriver encapsulated within BasePage
        private readonly IWebDriver _driver;

        // Holds the default URL from configuration, not exposed to outside classes
        private readonly string _defaultUrl = ConfigManager.GetValue<string>("Application:BaseUrl");

        // Constructor is public to allow instantiation of BasePage by other parts of the framework
        public BasePage(IWebDriver driver)
        {
            _driver = driver;
        }

        // Public methods to allow navigation to the default or a specific URL
        public BasePage NavigateToURL()
        {
            _driver.Navigate().GoToUrl(_defaultUrl);
            return this;
        }

        public BasePage NavigateToURL(string url)
        {
            _driver.Navigate().GoToUrl(url);
            return this;
        }

        // Public method to dismiss a pop-up, accessible to other classes
        public BasePage DismissPopUp()
        {
            // Code to handle pop-up if needed
            return this;
        }
    }
}
