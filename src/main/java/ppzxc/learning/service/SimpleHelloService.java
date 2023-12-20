package ppzxc.learning.service;

public class SimpleHelloService implements HelloService {

  @Override
  public String sayHello(String name) {
    return "Hello %s".formatted(name);
  }
}
