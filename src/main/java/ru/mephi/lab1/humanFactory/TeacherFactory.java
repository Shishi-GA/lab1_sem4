package ru.mephi.lab1.humanFactory;

import com.github.javafaker.Faker;
import ru.mephi.lab1.fileReader.DepartmentsReader;
import ru.mephi.lab1.human.LibraryUser;
import ru.mephi.lab1.human.Teacher;
import ru.mephi.lab1.library.Subscription;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TeacherFactory extends LibraryUserFactory {

    @Override
    public LibraryUser build() {
        Faker faker = new Faker(new Locale("ru"));
        String fullName;
        while (true) {
            fullName = faker.name().fullName();
            if (fullName.split(" ").length == 3) {
                break;
            }
        }
        String[] fullNameParts = fullName.split(" ");
        String surname = fullNameParts[0];
        String name = fullNameParts[1];
        String patronymic = fullNameParts[2];
        List<String> departments = DepartmentsReader.readDepartments();
        String department = departments.get(new Random().nextInt(departments.size()));
        Teacher teacher = new Teacher(name, surname, null, patronymic, department);
        Subscription subscription = new Subscription(teacher);
        teacher.setSubscription(subscription);
        return teacher;
    }

}
