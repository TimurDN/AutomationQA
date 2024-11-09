using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutomationFramework.Interfaces
{
    public interface IConfigManager
    {
        T GetValue<T>(string key);
        IConfiguration Configuration { get; }
    }
}
