package ppzxc.learning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@HelloBootTest
public class SimpleHelloServiceCountTest {

  @Autowired
  private HelloService helloService;
  @Autowired
  private HelloRepository helloRepository;

  @Test
  public void sayHelloIncreaseCount() {
    IntStream.rangeClosed(1, 10).forEach(count -> {
      helloService.sayHello("Toby");
      assertThat(helloRepository.countOf("Toby")).isEqualTo(count);
    });
  }
}
