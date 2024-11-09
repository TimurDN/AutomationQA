using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutomationFramework.Helpers
{
    public static class BrowserHelper
    {
        // Clears all cookies from the browser
        public static void ClearCookies(IWebDriver driver)
        {
            driver.Manage().Cookies.DeleteAllCookies();
            driver.Navigate().Refresh();  // Refresh to apply cookie changes
        }

        // Clears the local storage and session storage (if supported by the browser)
        public static void ClearCache(IWebDriver driver)
        {
            var jsExecutor = (IJavaScriptExecutor)driver;

            // Clear Local Storage
            jsExecutor.ExecuteScript("window.localStorage.clear();");

            // Clear Session Storage
            jsExecutor.ExecuteScript("window.sessionStorage.clear();");

            // Optionally refresh to ensure cache is cleared
            driver.Navigate().Refresh();
        }

        // Method to clear both cookies and cache for full cleanup
        public static void ClearBrowserData(IWebDriver driver)
        {
            ClearCookies(driver);
            ClearCache(driver);
        }
    }
}