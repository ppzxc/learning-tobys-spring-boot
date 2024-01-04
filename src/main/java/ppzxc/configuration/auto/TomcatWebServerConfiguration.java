package ppzxc.configuration.auto;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import ppzxc.configuration.ConditionalMyOnClass;
import ppzxc.configuration.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfiguration {

  @ConditionalOnMissingBean
  @Bean("tomcatWebServerFactory")
  public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
    TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    serverFactory.setContextPath(properties.getContextPath());
    serverFactory.setPort(properties.getPort());
    return serverFactory;
  }
}
