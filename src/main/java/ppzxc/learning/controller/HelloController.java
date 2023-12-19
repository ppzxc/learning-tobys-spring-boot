package ppzxc.learning.controller;

import java.util.Objects;
import ppzxc.learning.service.SimpleHelloService;

public class HelloController {

  public String hello(String name) {
    SimpleHelloService helloService = new SimpleHelloService();
    return helloService.sayHello(Objects.requireNonNull(name));
  }
}
