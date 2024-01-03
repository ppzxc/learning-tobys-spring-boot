package ppzxc.configuration.auto;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import ppzxc.configuration.ConditionalOnClass;
import ppzxc.configuration.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfiguration {

  @Bean("tomcatWebServerFactory")
  public ServletWebServerFactory servletWebServerFactory() {
    return new TomcatServletWebServerFactory();
  }
}
