package ppzxc.configuration;

import java.util.stream.StreamSupport;
import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigurationImportSelector implements DeferredImportSelector {

  private final ClassLoader classLoader;

  public MyAutoConfigurationImportSelector(ClassLoader classLoader) {
    this.classLoader = classLoader;
  }

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return StreamSupport.stream(ImportCandidates.load(MyAutoConfiguration.class, classLoader).spliterator(), false)
      .toArray(String[]::new);
  }
}