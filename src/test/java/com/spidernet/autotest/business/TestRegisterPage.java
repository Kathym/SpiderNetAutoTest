package com.spidernet.autotest.business;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.spidernet.autotest.business.IBusiness;
import com.spidernet.autotest.business.LoginNormal;
import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class TestRegisterPage {
	
	static WebDriver driver = null;
	
	@BeforeClass
	public static void createDriver()  {
		try{
			driver = CommonUtils.createDriver(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@AfterClass
	public static void closeDriver() {
		CommonUtils.closeDriver(driver);		
	}

	@Test
	public void testRegisterExceptionMessage() {
		try{
			IBusiness loginNormal = new LoginNormal();
		    IBusiness registerExceptionMessage = new RegisterExceptionMessage();
			IBusiness logOff = new LogOff();
				
			
			List<IBusiness> list = new ArrayList<IBusiness>();

			list.add(loginNormal);
			list.add(registerExceptionMessage);
			list.add(logOff);
							
			for(IBusiness object:list){
				boolean result = object.excute(driver);
				if(result){
					ConfigFile.appendContentToLogFile("******* Case Pass :) ******* ");
					Assert.assertTrue(result);
				}
				else
				{
					ConfigFile.appendContentToLogFile("******* Case Fail :( ******* ");
				}	
				Thread.sleep(1000);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
