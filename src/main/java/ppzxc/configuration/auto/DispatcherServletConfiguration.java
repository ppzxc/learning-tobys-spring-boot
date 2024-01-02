package ppzxc.configuration.auto;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import ppzxc.configuration.MyAutoConfiguration;

@MyAutoConfiguration
public class DispatcherServletConfiguration {

  @Bean
  public DispatcherServlet dispatcherServlet() {
    return new DispatcherServlet();
  }
}
