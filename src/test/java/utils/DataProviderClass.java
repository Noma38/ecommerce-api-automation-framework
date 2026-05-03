package utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return ExcelUtil.getData();
    }
}