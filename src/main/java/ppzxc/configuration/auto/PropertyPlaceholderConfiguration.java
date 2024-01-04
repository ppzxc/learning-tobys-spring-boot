package ppzxc.configuration.auto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ppzxc.configuration.MyAutoConfiguration;

@MyAutoConfiguration
public class PropertyPlaceholderConfiguration {

  @Bean
  public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }
}
