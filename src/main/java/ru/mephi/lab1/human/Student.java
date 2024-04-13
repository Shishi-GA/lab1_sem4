package ru.mephi.lab1.human;

import ru.mephi.lab1.library.Subscription;

public class Student extends LibraryUser {

    private final int course;
    private final String group;

    public Student(String name, String surname, Subscription subscription, int course, String group) {
        super(name, surname, subscription);
        this.course = course;
        this.group = group;
    }
    @Override
    public boolean isStudent() {
        return true;
    }

    @Override
    public boolean isTeacher() {
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", subscription=" + subscription +
                '}';
    }

}
