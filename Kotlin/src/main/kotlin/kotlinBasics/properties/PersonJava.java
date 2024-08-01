package kotlinBasics.properties;

public class PersonJava {

    private final String name;
    private Boolean isStudent;

    public PersonJava(String name, Boolean isStudent) {
        this.name = name;
        this.isStudent = isStudent;
    }

    public String getName() {
        return name;
    }

    public Boolean isStudent() {
        return isStudent;
    }

    public void setStudent(Boolean value){
        this.isStudent = isStudent;
    }
}
