package by.it_academy.jd2.core;

public class Persona {
    private String firstName;
    private String secondName;
    private String age;

    public Persona(String firstName, String secondName, String middleName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public  void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "The Person is : \n" +
                getFirstName() + " " +
                getSecondName() + " " +
                getAge() + " years old";
    }
}

