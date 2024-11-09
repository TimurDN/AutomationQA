using AutomationFramework.Interfaces;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Logging;
using System;
using System.IO;

namespace AutomationFramework.Helpers
{
    public class ConfigManager : IConfigManager
    {
        private readonly IConfiguration _configuration;
        private readonly ILogger<ConfigManager> _logger;

        public ConfigManager(ILogger<ConfigManager> logger = null)
        {
            _logger = logger;
            _configuration = LoadConfig();
        }

        private IConfiguration LoadConfig()
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
                _logger?.LogError(ex, "Configuration file not found in the specified path.");
                throw new FileNotFoundException("Configuration file not found in the specified path.", ex);
            }
            catch (Exception ex)
            {
                _logger?.LogError(ex, "Error loading configuration.");
                throw new Exception("Error loading configuration", ex);
            }
        }

        public T GetValue<T>(string key)
        {
            try
            {
                return _configuration.GetValue<T>(key);
            }
            catch (Exception ex)
            {
                _logger?.LogError(ex, $"Failed to retrieve configuration value for key: {key}");
                throw;
            }
        }

        public IConfiguration Configuration => _configuration;
    }
}
