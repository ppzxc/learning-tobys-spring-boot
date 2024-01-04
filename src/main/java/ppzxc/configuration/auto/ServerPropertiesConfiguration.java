package ppzxc.configuration.auto;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import ppzxc.configuration.MyAutoConfiguration;

@MyAutoConfiguration
public class ServerPropertiesConfiguration {

  @Bean
  public ServerProperties serverProperties(Environment env) {
    return Binder.get(env).bind("", ServerProperties.class).get();
  }
}
