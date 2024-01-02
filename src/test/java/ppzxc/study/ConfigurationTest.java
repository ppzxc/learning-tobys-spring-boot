package ppzxc.study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {

  @Test
  void should_not_equals_when_without_spring() {
    TestConfiguration testConfiguration = new TestConfiguration();

    Bean1 bean1 = testConfiguration.bean1();
    Bean2 bean2 = testConfiguration.bean2();

    assertThat(bean1.common).isNotSameAs(bean2.common);
  }

  @Test
  void should_equals_when_with_spring() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(TestConfiguration.class);
    context.refresh();

    Bean1 bean1 = context.getBean(Bean1.class);
    Bean2 bean2 = context.getBean(Bean2.class);

    assertThat(bean1.common).isSameAs(bean2.common);
  }

  @Test
  void should_equals_when_without_spring() {
    TestConfigurationProxy proxy = new TestConfigurationProxy();

    Bean1 bean1 = proxy.bean1();
    Bean2 bean2 = proxy.bean2();

    assertThat(bean1.common).isSameAs(bean2.common);
  }

  static class TestConfigurationProxy extends TestConfiguration {

    private Common common;

    @Override
    Common common() {
      if (this.common == null) {
        this.common = super.common();
      }
      return this.common;
    }
  }

  @Configuration
  static class TestConfiguration {

    @Bean
    Common common() {
      return new Common();
    }

    @Bean
    Bean1 bean1() {
      return new Bean1(common());
    }

    @Bean
    Bean2 bean2() {
      return new Bean2(common());
    }
  }

  // example1 Common is Singleton
  // Bean1 <-- Common
  // Bean2 <-- Common

  static class Bean1 {

    private final Common common;

    Bean1(Common common) {
      this.common = common;
    }
  }

  static class Bean2 {

    private final Common common;

    Bean2(Common common) {
      this.common = common;
    }
  }

  private static class Common {

  }
}
