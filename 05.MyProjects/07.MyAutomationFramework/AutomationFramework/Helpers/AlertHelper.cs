using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutomationFramework.Helpers
{
    public static class AlertHelper
    {
        public static void AcceptAlert(IWebDriver driver)
        {
            driver.SwitchTo().Alert().Accept();
        }

        public static void DismissAlert(IWebDriver driver)
        {
            driver.SwitchTo().Alert().Dismiss();
        }

        public static string GetAlertText(IWebDriver driver)
        {
            return driver.SwitchTo().Alert().Text;
        }
        public static void SendKeysToAlert(IWebDriver driver, string text)
        {
            driver.SwitchTo().Alert().SendKeys(text);
        }
    }
}