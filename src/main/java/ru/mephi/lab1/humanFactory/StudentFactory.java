package ru.mephi.lab1.humanFactory;

import com.github.javafaker.Faker;
import ru.mephi.lab1.human.LibraryUser;
import ru.mephi.lab1.human.Student;
import ru.mephi.lab1.library.Subscription;

import java.util.Locale;
import java.util.Random;

public class StudentFactory extends LibraryUserFactory {

    @Override
    public LibraryUser build() {
        Faker faker = new Faker(new Locale("ru"));
        String fullName = faker.name().fullName();
        String[] fullNameParts = fullName.split(" ");
        String surname = fullNameParts[0];
        String name = fullNameParts[1];
        int course = new Random().nextInt(4) + 1;
        String group = faker.bothify("?##-###");
        Student student = new Student(name, surname, null, course, group);
        Subscription subscription = new Subscription(student);
        student.setSubscription(subscription);
        return student;
    }

}
