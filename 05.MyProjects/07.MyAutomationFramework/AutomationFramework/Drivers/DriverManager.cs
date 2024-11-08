using AutomationFramework.Helpers;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;
using System;

namespace AutomationFramework
{
    internal class DriverManager
    {
        // Public method to retrieve a configured WebDriver instance based on configuration
        public IWebDriver GetDriver()
        {
            string browser = ConfigManager.GetValue<string>("BrowserSettings:Browser")?.ToLower() ?? "chrome";
            bool headless = ConfigManager.GetValue<bool>("BrowserSettings:Headless");

            IWebDriver driver = browser switch
            {
                "chrome" => CreateChromeDriver(headless),
                "firefox" => CreateFirefoxDriver(headless),
                _ => throw new NotSupportedException($"Browser '{browser}' is not supported")
            };

            driver.Manage().Window.Maximize();
            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(ConfigManager.GetValue<int>("BrowserSettings:Timeout"));
            return driver;
        }

        // Private method to create a ChromeDriver with options, including headless mode if specified
        private IWebDriver CreateChromeDriver(bool headless)
        {
            var options = new ChromeOptions();
            if (headless) options.AddArgument("headless");
            return new ChromeDriver(options);
        }

        // Private method to create a FirefoxDriver with options, including headless mode if specified
        private IWebDriver CreateFirefoxDriver(bool headless)
        {
            var options = new FirefoxOptions();
            if (headless) options.AddArgument("--headless");
            return new FirefoxDriver(options);
        }
    }
}
