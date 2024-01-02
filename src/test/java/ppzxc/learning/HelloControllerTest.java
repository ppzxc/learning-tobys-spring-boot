package ppzxc.learning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import ppzxc.learning.controller.HelloController;

public class HelloControllerTest {

  @Test
  void should_return_echo() {
    HelloController helloController = new HelloController(name -> name);

    String actual = helloController.hello("World");

    assertThat(actual).isEqualTo("World");
  }

  @Test
  void should_return_exception_when_input_null() {
    HelloController helloController = new HelloController(name -> name);

    assertThatThrownBy(() -> helloController.hello(null))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_return_exception_when_input_empty() {
    HelloController helloController = new HelloController(name -> name);

    assertThatThrownBy(() -> helloController.hello(""))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_return_exception_when_input_blank() {
    HelloController helloController = new HelloController(name -> name);

    assertThatThrownBy(() -> helloController.hello("          "))
      .isInstanceOf(IllegalArgumentException.class);
  }
}
