package lab.model;

public interface Person {
    Person setName(String name);
    String getName ();

    default void sayHello(Person person) {
        System.out.printf("Hello, %s, I`m %s%n", person.getName(), getName());
    }
}