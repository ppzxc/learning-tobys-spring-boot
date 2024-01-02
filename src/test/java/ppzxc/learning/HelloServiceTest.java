package ppzxc.learning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ppzxc.learning.service.SimpleHelloService;

public class HelloServiceTest {

  @Test
  void should_return_Hello() {
    SimpleHelloService service = new SimpleHelloService();

    String actual = service.sayHello("Test");

    assertThat(actual).isEqualTo("Hello Test");
  }
}
