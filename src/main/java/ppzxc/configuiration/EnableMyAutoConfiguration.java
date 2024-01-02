package ppzxc.configuiration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
import ppzxc.configuiration.auto.DispatcherServletConfiguration;
import ppzxc.configuiration.auto.TomcatWebServerConfiguration;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({TomcatWebServerConfiguration.class, DispatcherServletConfiguration.class})
public @interface EnableMyAutoConfiguration {

}
