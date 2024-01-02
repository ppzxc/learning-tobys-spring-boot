package ppzxc.configuration;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigurationImportSelector implements DeferredImportSelector {

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[]{
      "ppzxc.configuration.auto.DispatcherServletConfiguration",
      "ppzxc.configuration.auto.TomcatWebServerConfiguration",
    };
  }
}