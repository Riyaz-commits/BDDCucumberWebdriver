package web.cucumber.helpers;

public class TestContext {
    private DriverManager driverManager;
    private PageObjectManager pageObjectManager;
    private ConfigManager configManager;

    public DriverManager getDriverManager(){
        if(driverManager==null)
            driverManager=new DriverManager();
        return driverManager;
    }

    public PageObjectManager getPageObjectManager(){
        if(pageObjectManager==null)
            pageObjectManager=new PageObjectManager(driverManager.getDriver());
        return pageObjectManager;
    }

    public ConfigManager getConfigManager(){
        if(configManager==null)
            configManager=new ConfigManager();
        return configManager;
    }
}
