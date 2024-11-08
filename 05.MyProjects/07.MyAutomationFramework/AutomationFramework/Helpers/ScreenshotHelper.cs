using OpenQA.Selenium;
using System;
using System.IO;

namespace AutomationFramework.Helpers
{
    public static class ScreenshotHelper
    {
        private static readonly string ScreenshotsDirectory = Path.Combine(Directory.GetCurrentDirectory(), "Screenshots");

        public static void CaptureScreenshot(IWebDriver driver, string testName)
        {
            try
            {
                // Ensure the driver supports taking screenshots
                if (driver is ITakesScreenshot screenshotDriver)
                {
                    var screenshot = screenshotDriver.GetScreenshot();
                    var filePath = GetScreenshotFilePath(testName);

                    screenshot.SaveAsFile(filePath);
                    Console.WriteLine($"Screenshot saved: {filePath}");
                }
                else
                {
                    Console.WriteLine("Driver does not support taking screenshots.");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Failed to capture screenshot: {ex.Message}");
            }
        }

        private static string GetScreenshotFilePath(string testName)
        {
            EnsureScreenshotDirectoryExists();
            string timestamp = DateTime.Now.ToString("yyyyMMdd_HHmmss");
            return Path.Combine(ScreenshotsDirectory, $"{testName}_{timestamp}.png");
        }

        private static void EnsureScreenshotDirectoryExists()
        {
            if (!Directory.Exists(ScreenshotsDirectory))
            {
                Directory.CreateDirectory(ScreenshotsDirectory);
            }
        }
    }
}
