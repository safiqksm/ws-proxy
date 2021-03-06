package be.error.wsproxy.configuration.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import be.error.wsproxy.configuration.profiles.Local;

/**
 * When this module needs to communicate with a forward in order to reach the target service you can specify them here.
 * This will normally only be used for accessing external services (external outbound). Internally hosted services are
 * normally directly reachable by this module. However, if for some reason internal services needs to be accessed via a
 * forward proxy you can specify them here as well.
 * <p/>
 * The target service for which the configuration is used is identified by the payload root element and its namespace.
 * The proxy information is in format host:port. Eg. "{http://service.error.be}localPart=proxyHost:proxyPort". Multiple
 * entries are comma separated.
 * 
 * @author Koen Serneels
 */
@Configuration
public class ForwardProxy {

	@Local
	public static class LocalConfiguration {

		@Value("${forward.proxy}")
		private String forwardProxy;

		@Bean
		public String httpForwardProxy() {
			return forwardProxy;
		}
	}
}
