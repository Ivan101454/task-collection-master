package by.clevertec;

import by.clevertec.model.Person;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task8test() {

//        assert Main.task8();
    }

    @Test
    void task12() {
        List<Person> persons = Util.getPersons();
        Person first = persons.get(1);
        boolean b = ChronoUnit.YEARS.between(first.getDateOfBirth(), LocalDate.now() ) >= 18;
        System.out.println(b);
        List<Person> male = persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> ((ChronoUnit.YEARS.between(LocalDate.now(), person.getDateOfBirth()) >= 18)))
//                                   (ChronoUnit.YEARS.between(LocalDate.now(), person.getDateOfBirth()) <= 27)))
                .collect(Collectors.toList());
        male.forEach(System.out::println);
    }

    @Test
    void task18Test() {
        Main.task18();
    }
}