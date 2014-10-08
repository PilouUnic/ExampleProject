/**
 * 
 */
package com.application.example.configuration;
	

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * @author admin
 *
 */
@Component
public class ConfigurationLoader {
	
	@Resource(name = "configurationBeanLoader")
	private Properties configurationPropertiesLoader;
	
	private final String applicationNameKey = "example.application.name";
	private final String userManualPathFrKey = "example.application.user.manual.fr.path";
	private final String userManualPathEnKey = "example.application.user.manual.en.path";
	
	private String applicationName;
	private String userManualPathFr;
	private String userManualPathEn;

	/**
	 * Default constructor.
	 */
	public ConfigurationLoader() {
	}

	
	public String getApplicationName() throws ConfigurationLoaderException {	
		applicationName = configurationPropertiesLoader.getProperty(applicationNameKey);
		if(applicationName == null || "".equals(applicationName)) {
			throw new ConfigurationLoaderException("Error during recovering configuration properties. "
					+ "The property 'example.application.name' is not parameterized correctly");
		}
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}


	public String getUserManualPathFr() throws ConfigurationLoaderException {
		userManualPathFr = configurationPropertiesLoader.getProperty(userManualPathFrKey);
		if(userManualPathFr == null || "".equals(userManualPathFr)) {
			throw new ConfigurationLoaderException("Error during recovering configuration properties. "
					+ "The property 'example.application.user.manual.fr.path' is not parameterized correctly");
		}
		return userManualPathFr;
	}


	public void setUserManualPathFr(String userManualPathFr) {
		this.userManualPathFr = userManualPathFr;
	}


	public String getUserManualPathEn() throws ConfigurationLoaderException {
		userManualPathEn = configurationPropertiesLoader.getProperty(userManualPathEnKey);
		if(userManualPathEn == null || "".equals(userManualPathEn)) {
			throw new ConfigurationLoaderException("Error during recovering configuration properties. "
					+ "The property 'example.application.user.manual.en.path' is not parameterized correctly");
		}
		return userManualPathEn;
	}


	public void setUserManualPathEn(String userManualPathEn) {
		this.userManualPathEn = userManualPathEn;
	}	
	
}
