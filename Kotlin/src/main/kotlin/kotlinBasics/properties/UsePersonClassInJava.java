package kotlinBasics.properties;

public class UsePersonClassInJava {

    /**
     * Пример исользования котлин класса в джава коде
     */
    public static void main(String[] args) {
        PersonKotlin person = new PersonKotlin("Bob", true);
        System.out.println(person.getName());
        // Bob
        System.out.println(person.isStudent());
        // true
        person.setStudent(false); // Graduation!
        System.out.println(person.isStudent());
        // false
    }
}