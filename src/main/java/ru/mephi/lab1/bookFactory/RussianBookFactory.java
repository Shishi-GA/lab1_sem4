package ru.mephi.lab1.bookFactory;

import com.github.javafaker.Faker;
import ru.mephi.lab1.books.FictionBook;
import ru.mephi.lab1.books.RussianFictionBook;
import ru.mephi.lab1.books.RussianStudentBook;
import ru.mephi.lab1.books.StudentBook;
import ru.mephi.lab1.fileReader.RussianBookReader;
import ru.mephi.lab1.fileReader.DisciplinesReader;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class RussianBookFactory extends BookFactory implements EnglishStudentBookFactory, EnglishFictionBookFactory {

    @Override
    public StudentBook buildStudentBook() {
        Faker faker = new Faker(new Locale("ru"));
        List<String> disciplines = DisciplinesReader.readDisciplines();
        String discipline = disciplines.get(new Random().nextInt(disciplines.size()));
        String ISBN = faker.bothify("###-#-##-#####-#");
        List<String> prefixes = List.of("Пособие", "Учебник", "Задачник");
        String prefix = prefixes.get(new Random().nextInt(prefixes.size()));
        String author = faker.name().fullName();
        return new RussianStudentBook(ISBN, discipline, author, prefix);
    }

    @Override
    public FictionBook buildFictionBook() {
        Faker faker = new Faker(new Locale("ru"));
        String ISBN = faker.bothify("###-#-##-#####-#");
        List<String[]> books = RussianBookReader.readBooks();
        String[] parts = books.get(new Random().nextInt(books.size()));
        return new RussianFictionBook(ISBN, parts[1].trim(), parts[0], Integer.parseInt(parts[2].trim()));
    }

}
