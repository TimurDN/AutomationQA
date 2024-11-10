using AutomationFramework.Helpers;
using AutomationFramework.Interfaces;
using OpenQA.Selenium;

namespace AutomationFramework
{
    public class BasePage
    {
        private readonly IWebDriver _driver;
        private readonly string _defaultUrl;


        public BasePage(IWebDriver driver, string defaultUrl)
        {
            _driver = driver;
            _defaultUrl = defaultUrl;
        }
        protected IWebDriver Driver => _driver;

        public BasePage NavigateToURL(string url = null)
        {
            _driver.Navigate().GoToUrl(url ?? _defaultUrl);
            return this;
        }

        public BasePage DismissPopUp()
        {
            // Code to handle pop-up if needed
            return this;
        }
    }
}