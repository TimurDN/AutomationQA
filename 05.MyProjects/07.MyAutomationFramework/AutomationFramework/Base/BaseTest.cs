using AutomationFramework.Helpers;
using NUnit.Framework;
using NUnit.Framework.Interfaces;
using OpenQA.Selenium;
using System;

namespace AutomationFramework
{
    [TestFixture]
    public abstract class BaseTest
    {
        // Allows access to the WebDriver instance in derived test classes
        protected IWebDriver Driver;

        // Provides base navigation and page-level interactions for derived test classes
        protected BasePage BasePage;

        [SetUp]
        public void Setup()
        {
            // Initialize WebDriver through DriverManager
            Driver = new DriverManager().GetDriver();
            Driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(ConfigManager.GetValue<int>("BrowserSettings:Timeout"));

            // Initialize BasePage with the driver
            BasePage = new BasePage(Driver);
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
                // Log the exception if screenshot capture fails
                Console.WriteLine($"Failed to capture screenshot: {ex.Message}");
            }
            finally
            {
                // Ensure the WebDriver is properly closed and disposed of
                if (Driver != null)
                {
                    Driver.Quit();
                    Driver.Dispose();
                }
            }
        }
    }
}
