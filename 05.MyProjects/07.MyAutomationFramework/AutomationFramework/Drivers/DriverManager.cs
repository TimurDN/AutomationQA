using AutomationFramework.Helpers;
using AutomationFramework.Interfaces;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using OpenQA.Selenium.Firefox;
using System;

namespace AutomationFramework
{
    internal class DriverManager : IDisposable
    {
        private readonly IConfigManager _configManager;
        private IWebDriver _driver;

        // Constructor to inject IConfigManager
        public DriverManager(IConfigManager configManager)
        {
            _configManager = configManager;
        }

        public IWebDriver GetDriver()
        {
            if (_driver != null) return _driver; // Reuse driver if already created

            string browser = _configManager.GetValue<string>("BrowserSettings:Browser")?.ToLower() ?? "chrome";
            bool headless = _configManager.GetValue<bool>("BrowserSettings:Headless");

            _driver = browser switch
            {
                "chrome" => CreateChromeDriver(headless),
                "firefox" => CreateFirefoxDriver(headless),
                "edge" => CreateEdgeDriver(headless),
                _ => throw new NotSupportedException($"Browser '{browser}' is not supported")
            };

            ConfigureDriver(_driver);
            return _driver;
        }

        private void ConfigureDriver(IWebDriver driver)
        {
            driver.Manage().Window.Maximize();
            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(_configManager.GetValue<int>("BrowserSettings:Timeout"));
        }

        private IWebDriver CreateChromeDriver(bool headless)
        {
            var options = new ChromeOptions();
            if (headless) options.AddArgument("headless");
            return new ChromeDriver(options);
        }

        private IWebDriver CreateFirefoxDriver(bool headless)
        {
            var options = new FirefoxOptions();
            if (headless) options.AddArgument("--headless");
            return new FirefoxDriver(options);
        }

        private IWebDriver CreateEdgeDriver(bool headless)
        {
            var options = new EdgeOptions();
            if (headless) options.AddArgument("headless");
            return new EdgeDriver(options);
        }

        public void Dispose()
        {
            if (_driver != null)
            {
                _driver.Quit();
                _driver.Dispose();
                _driver = null;
            }
        }
    }
}
