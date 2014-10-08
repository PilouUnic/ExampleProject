/**
 * 
 */
package com.application.example.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author admin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext-test.xml" })
public class ConfigurationLoaderTest {

	static Logger logger = LoggerFactory.getLogger(ConfigurationLoaderTest.class);

	@Autowired
	private ConfigurationLoader configurationLoader; 


	/**
	 * 
	 */
	public ConfigurationLoaderTest() {
	}

	@Test
	public void loadConfigurationPropertiesOneTime() {			
		boolean isLoadingOk = true;
		logger.trace("Launching 'loadConfigurationPropertiesOneTime' test method in 'ConfigurationLoaderTest.java' class");
		String applicationName;
		String userManualFrench;
		String userManualEnglish;
		try {			
			applicationName = configurationLoader.getApplicationName();
			isLoadingOk = (applicationName != null && !applicationName.isEmpty());
			logger.debug("applicationName value is: " + applicationName);

			userManualFrench = configurationLoader.getUserManualPathFr();
			if(isLoadingOk) {
				isLoadingOk = (userManualFrench != null && !userManualFrench.isEmpty());
				logger.debug("userManualFrench value is: " + userManualFrench);
			}

			userManualEnglish = configurationLoader.getUserManualPathEn();
			if(isLoadingOk) {
				isLoadingOk = (userManualEnglish != null && !userManualEnglish.isEmpty());
				logger.debug("userManualEnglish value is: " + userManualEnglish);
			}

		} catch (ConfigurationLoaderException ex) {
			logger.error("Error during loading configuration file. Please contact support.", ex);
			isLoadingOk = false;
		} finally {				
			Assert.assertTrue(isLoadingOk);
			logger.trace("End of 'loadConfigurationPropertiesOneTime' test method in 'ConfigurationLoaderTest.java' class");
		}
	}

	@Test
	public void loadConfigurationPropertiesManyTimeWith() throws InterruptedException {	
		boolean isLoadingOk = true;
		logger.trace("Launching 'loadConfigurationPropertiesManyTimeWith' test method in 'ConfigurationLoaderTest.java' class");
		String applicationName;
		String userManualFrench;
		String userManualEnglish;
		try {				
			applicationName = configurationLoader.getApplicationName();
			isLoadingOk = (applicationName != null && !applicationName.isEmpty());
			logger.debug("applicationName value is: " + applicationName);

			userManualFrench = configurationLoader.getUserManualPathFr();
			if(isLoadingOk) {
				isLoadingOk = (userManualFrench != null && !userManualFrench.isEmpty());
				logger.debug("userManualFrench value is: " + userManualFrench);
			}

			userManualEnglish = configurationLoader.getUserManualPathEn();
			if(isLoadingOk) {
				isLoadingOk = (userManualEnglish != null && !userManualEnglish.isEmpty());
				logger.debug("userManualEnglish value is: " + userManualEnglish);
			}

			Thread.sleep(10000);
			
			applicationName = configurationLoader.getApplicationName();
			isLoadingOk = (applicationName != null && !applicationName.isEmpty());
			logger.debug("applicationName value is: " + applicationName);

			userManualFrench = configurationLoader.getUserManualPathFr();
			if(isLoadingOk) {
				isLoadingOk = (userManualFrench != null && !userManualFrench.isEmpty());
				logger.debug("userManualFrench value is: " + userManualFrench);
			}

			userManualEnglish = configurationLoader.getUserManualPathEn();
			if(isLoadingOk) {
				isLoadingOk = (userManualEnglish != null && !userManualEnglish.isEmpty());
				logger.debug("userManualEnglish value is: " + userManualEnglish);
			}
		} catch (ConfigurationLoaderException ex) {
			logger.error("Error during loading configuration file. Please contact support.", ex);
			isLoadingOk = false;
		} finally {				
			Assert.assertTrue(isLoadingOk);
			logger.trace("End of 'loadConfigurationPropertiesManyTimeWith' test method in 'ConfigurationLoaderTest.java' class");
		}
	}

}
