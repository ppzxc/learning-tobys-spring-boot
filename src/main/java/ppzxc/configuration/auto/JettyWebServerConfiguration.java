package ppzxc.configuration.auto;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import ppzxc.configuration.ConditionalOnClass;
import ppzxc.configuration.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfiguration {

  @Bean("jettyWebServerFactory")
  public ServletWebServerFactory servletWebServerFactory() {
    return new JettyServletWebServerFactory();
  }
}
