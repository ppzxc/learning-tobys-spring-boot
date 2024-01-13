package ppzxc.learning;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Test;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Test
@interface UnitTest {

}

public class HelloServiceTest {

  @FastUnitTest
  void should_return_Hello() {
    SimpleHelloService service = new SimpleHelloService(new HelloRepository() {
      @Override
      public Hello findHello(String name) {
        return null;
      }

      @Override
      public void increase(String name) {

      }
    });

    String actual = service.sayHello("Test");

    assertThat(actual).isEqualTo("Hello Test");
  }

  @UnitTest
  void should_return_decorate() {
    HelloDecorator decorator = new HelloDecorator(name -> name);

    String actual = decorator.sayHello("Test");

    assertThat(actual).isEqualTo("*Test*");
  }
}
