package com.weiger.yonyou.brower;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.HttpCommandExecutor;

public class WebAutoTestBaseClass {
	public static void main(String[] args) {
		WebAutoTestBaseClass autoTestBaseClass =new WebAutoTestBaseClass();
		
		
		try {
			autoTestBaseClass.testOpenedPageandBeginSpr();
			//autoTestBaseClass.wait();
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			//autoTestBaseClass.closeDriver();
			
		}
	
	}
	
	WebDriver driver;
	WebElement btn;
	
	public void testOpenedPageandBeginSpr(){

		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		System.out.println("chrome浏览器 自动化测试开始....");
		//ChromeDriverService chromeDriverService =new ChromeDriverService(new File("D:\\DeveloperKits\\selenium\\chromedriver.exe"), 9515, null, null);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

		driver=new ChromeDriver(options);
		
		
		
		
		
		driver.get("http://10.16.4.21:629/nccloud/resources/workbench/public/common/main/index.html#/ifr?ifr=%252Fnccloud%252Fresources%252Ffct%252Fbill%252Fap%252Fmain%252Findex.html%2523%252Flist&c=200401APM&p=200401APM_FCT1-01_list");
		//WebElement txtbox = driver.findElement(By.className("iconfont icon-luzhi1"));
		//txtbox.sendKeys("selenium javaffffff");
		WebElement btn =driver.findElement(By.className("icon-luzhi1"));
		btn.click();
		
		System.out.println("开始录制日志....");
		
		
		
		//btn.click();
		
		
		
		System.out.println("chrome浏览器 自动化测试结束！");
		
		
	}
	
	
	public void testOpenedPageandendSpr(){

		//System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		System.out.println("chrome浏览器 自动化测试开始....");
		//ChromeDriverService chromeDriverService =new ChromeDriverService(new File("D:\\DeveloperKits\\selenium\\chromedriver.exe"), 9515, null, null);
		
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

		//driver=new ChromeDriver(options);
		
		//driver.get("http://10.16.4.21:629/nccloud/resources/workbench/public/common/main/index.html#/ifr?ifr=%252Fnccloud%252Fresources%252Ffct%252Fbill%252Fap%252Fmain%252Findex.html%2523%252Flist&c=200401APM&p=200401APM_FCT1-01_list");
		//WebElement txtbox = driver.findElement(By.className("iconfont icon-luzhi1"));
		//txtbox.sendKeys("selenium javaffffff");
		//WebElement btn =driver.findElement(By.className("icon-luzhi1"));
		btn.click();
		
		System.out.println("停止录制日志....");
		
		//btn.click();
		//System.out.println("chrome浏览器 自动化测试结束！");
	}
	
	
	
	
	void testChrome() throws IOException, InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "D:/DeveloperKits/selenium/chromedriver.exe");
		System.out.println("chrome浏览器 自动化测试开始....");
		//ChromeDriverService chromeDriverService =new ChromeDriverService(new File("D:\\DeveloperKits\\selenium\\chromedriver.exe"), 9515, null, null);
		driver=new ChromeDriver();
		driver.get("http://www.baidu.com/");
		WebElement txtbox = driver.findElement(By.id("kw"));
		txtbox.sendKeys("selenium java");
		WebElement btn = driver.findElement(By.id("su"));
		btn.click();
		
		System.out.println("用户操作中....");
		
		
		
		
		
		
		
		System.out.println("chrome浏览器 自动化测试结束！");
	}
	
	
	public void notifyDriver(){
		
		driver.notify();
		
	}
	public void closeDriver(){
		
		driver.close();
		
	}
	
	
	
	
	void testFireFox(){
		System.out.println("srart selenium");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com/");
		WebElement txtbox = driver.findElement(By.id("kw"));
		txtbox.sendKeys("selenium java");
		WebElement btn = driver.findElement(By.id("su"));
		btn.click();
		driver.close();
		System.out.println("end selenium");
	}
	
	void testIE(){
		System.setProperty("webdriver.ie.driver", "D:/auto/public/selenium/webdriver/win64/IEDriverServer.exe");  
		  
        InternetExplorerDriver driver = new InternetExplorerDriver();  
          
        String sessionid = driver.getSessionId().toString();  
        System.out.println("session ID --->" + sessionid);  
          
        URL url = ((HttpCommandExecutor)(driver.getCommandExecutor())).getAddressOfRemoteServer();  
        System.out.println("url --->" + url.toString());  
          
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
        driver.get("http://www.google.com");  
          
          
        WebElement key =driver.findElement(By.id("lst-ib"));  
        key.sendKeys("abc");  
          
        Set set = driver.getWindowHandles();  
          
//      driver.getCommandExecutor().getAddressOfRemoteServer().toString();  
		
	}
	
}