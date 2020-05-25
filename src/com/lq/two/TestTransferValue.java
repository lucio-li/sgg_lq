package com.lq.two;

/**
 * @author liqiao
 * 2020/1/18
 */
class  Person{
    private String personName;

    Person() {
        personName = "";
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
public class TestTransferValue {
    public void changeValue1(int age) {
        age = 30;
    }
    public void changeValue2(Person person) {
        person.setPersonName("xxx");
    }
    public void changeValue3(String str) {
        str = "XXX";
    }

    public static void main(String[] args) {
        TestTransferValue test = new TestTransferValue();
        int age = 20;
        test.changeValue1(20);
        System.out.println("age: " + age);

        Person person = new Person();
        person.setPersonName("abc");
        test.changeValue2(person);
        System.out.println("personName:" + person.getPersonName());

        String str = "abc";
        test.changeValue3(str);
        System.out.println("String:" + str);

    }

}
