package lab.model;

public interface Person {
    Person setName(String name);
    String getName ();

    default void sayHello(Person person) {
        System.out.printf("Hello, %s%n", person.getName());
    }
}