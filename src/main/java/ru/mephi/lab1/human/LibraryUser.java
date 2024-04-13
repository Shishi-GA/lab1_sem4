package ru.mephi.lab1.human;

import ru.mephi.lab1.library.Subscription;

public abstract class LibraryUser implements Human {

    protected String name;
    protected String surname;
    protected Subscription subscription;

    public LibraryUser(String name, String surname, Subscription subscription) {
        this.name = name;
        this.surname = surname;
        this.subscription = subscription;
    }

    public String getFullName() {
        return surname + " " + name;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public abstract boolean isStudent();

    public abstract boolean isTeacher();

}
