using Microsoft.Extensions.Configuration;
using System;
using System.IO;

namespace AutomationFramework.Helpers
{
    public static class ConfigManager
    {
        private static readonly Lazy<IConfiguration> _configuration = new Lazy<IConfiguration>(() => LoadConfig());

        private static IConfiguration LoadConfig()
        {
            try
            {
                string environment = Environment.GetEnvironmentVariable("ASPNETCORE_ENVIRONMENT") ?? "Production";

                return new ConfigurationBuilder()
                    .SetBasePath(Directory.GetCurrentDirectory())
                    .AddJsonFile("config.json", optional: false, reloadOnChange: true)
                    .AddJsonFile($"config.{environment}.json", optional: true)
                    .Build();
            }
            catch (FileNotFoundException ex)
            {
                throw new FileNotFoundException("Configuration file not found in the specified path.", ex);
            }
            catch (Exception ex)
            {
                throw new Exception("Error loading configuration", ex);
            }
        }

        public static T GetValue<T>(string key) => _configuration.Value.GetValue<T>(key);

        public static IConfiguration Configuration => _configuration.Value;
    }
}
