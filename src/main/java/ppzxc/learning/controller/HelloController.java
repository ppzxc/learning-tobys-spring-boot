package ppzxc.learning.controller;

import java.util.Objects;
import ppzxc.learning.service.HelloService;

public class HelloController {

  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  public String hello(String name) {
    return helloService.sayHello(Objects.requireNonNull(name));
  }
}
