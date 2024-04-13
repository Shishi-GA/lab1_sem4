package ru.mephi.lab1.human;

import ru.mephi.lab1.library.Subscription;

public class Teacher extends LibraryUser {

    private final String patronymic;
    private final String department;

    public Teacher(String name, String surname, Subscription subscription, String patronymic, String department) {
        super(name, surname, subscription);
        this.patronymic = patronymic;
        this.department = department;
    }
    @Override
    public boolean isStudent() {
        return false;
    }

    @Override
    public boolean isTeacher() {
        return true;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", subscription=" + subscription +
                '}';
    }

    @Override
    public String getFullName() {
        return surname + " " + name + " " + patronymic;
    }
}
