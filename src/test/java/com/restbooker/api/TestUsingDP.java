package com.restbooker.api;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
public class TestUsingDP {



    @DataProvider(name = "loginData")
    public Object[][] getData(){
        Object[][] data = {{"ganesh","test"},{"ramesh","test1"},{"jaswin","test"}};
        return data;
    }
}

