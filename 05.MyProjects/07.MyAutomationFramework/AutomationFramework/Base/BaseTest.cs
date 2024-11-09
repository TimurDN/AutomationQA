using AutomationFramework.Helpers;
using AutomationFramework.Interfaces;
using NUnit.Framework;
using NUnit.Framework.Interfaces;
using OpenQA.Selenium;
using System;

namespace AutomationFramework
{
    [TestFixture]
    public abstract class BaseTest
    {
        protected IWebDriver Driver;           // Allows access to the WebDriver instance in derived test classes
        protected BasePage BasePage;           // Provides base navigation and page-level interactions
        private readonly IConfigManager ConfigManager; // Configuration manager instance

        public BaseTest()
        {
            ConfigManager = new ConfigManager(); // Initialize ConfigManager
        }

        [SetUp]
        public void Setup()
        {
            // Initialize WebDriver through DriverManager
            var driverManager = new DriverManager(ConfigManager);
            Driver = driverManager.GetDriver();
            Driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(ConfigManager.GetValue<int>("BrowserSettings:Timeout"));

            // Retrieve the URL directly from ConfigManager for BasePage
            string baseUrl = ConfigManager.GetValue<string>("Application:BaseUrl");
            BasePage = new BasePage(Driver, baseUrl);
        }

        [TearDown]
        public void Teardown()
        {
            try
            {
                if (TestContext.CurrentContext.Result.Outcome.Status == TestStatus.Failed)
                {
                    ScreenshotHelper.CaptureScreenshot(Driver, TestContext.CurrentContext.Test.Name);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Failed to capture screenshot: {ex.Message}");
            }
            finally
            {
                if (Driver != null)
                {
                    Driver.Quit();
                    Driver.Dispose();
                }
            }
        }
    }
}
