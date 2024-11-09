using AutomationFramework.Helpers;
using NUnit.Framework;
using OpenQA.Selenium;

namespace AutomationFramework.Tests
{
    public class Tests : BaseTest
    {
        //[SetUp]
        //public void TestSetup()
        //{
        //    BrowserHelper.ClearCookies(Driver);
        //    BrowserHelper.ClearCache(Driver);
        //}
    
        [Test, Retry(3)]
        public void VerifyHomePageTitle()
        {
            BasePage.NavigateToURL();  // Uses the base URL
            string actualTitle = Driver.Title;
            Assert.AreEqual("Google", actualTitle, "The page title does not match the expected value.");
        }

        [Test]
        public void NavigateToCustomUrlAndVerifyTitle()
        {
            BasePage.NavigateToURL("https://example.com");  // Navigates to a custom URL
            Console.WriteLine($"Current URL after navigation: {Driver.Url}");  // Confirm the actual URL
            Assert.AreEqual("Example Domain", Driver.Title, "The page title does not match the expected value for Example Domain.");
        }
    }
}
