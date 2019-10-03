package com.atmecs.helper;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.atmecs.utils.Constants;

public class BaseClassForGrid {


private static DesiredCapabilities getBrowserCapabilities(String browserType) {
switch (browserType) {

case "firefox":
DesiredCapabilities descapability= new DesiredCapabilities();
descapability.setCapability(CapabilityType.BROWSER_NAME, "firefox");
return descapability;


case "chrome":
 descapability= new DesiredCapabilities();
descapability.setCapability(CapabilityType.BROWSER_NAME, "chrome");
return descapability;


default:
 descapability= new DesiredCapabilities();
descapability.setCapability(CapabilityType.BROWSER_NAME, "ie");
return descapability;

}
}
public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
return new RemoteWebDriver(new URL(Constants.gridNodeURL), getBrowserCapabilities(browser));
}
}
