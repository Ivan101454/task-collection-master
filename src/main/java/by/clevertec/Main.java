package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
//        task8();
//        task9();
//        task10();
//        task11();
//        task12();
//        task13();
//        task14();
//        task15();
//        task16();
//        task17();
//        task18();
//        task19();
        task20();
//        task21();
//        task22();
    }

    public static void task1() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> (animal.getAge() >= 10 && animal.getAge() < 20))
                .sorted(Comparator.comparing(Animal::getAge))
                .skip(14).limit(7)
                .forEach(System.out::println);
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();
        List<String> result = animals.stream()
                .filter(animal -> Objects.equals(animal.getOrigin(), "Japanese"))
                .map(animal -> {
                    String s = animal.getGender().equals("Female") ?
                            animal.getBread().toUpperCase().toString()
                            : animal.getBread().toString();
                    return s;
                })
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();
        Set<String> country = animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .filter(animal -> animal.getOrigin().substring(0, 1).equalsIgnoreCase("a"))
                .map(animal -> animal.getOrigin())
                .collect(Collectors.toSet());
        country.forEach(System.out::println);
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
        long female = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
        System.out.println(female);
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();
        boolean size = animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .filter(animal -> Objects.equals(animal.getOrigin(), "Hungarian"))
                .toList().isEmpty();
        System.out.println("Есть ли среди нах хоть один из страны Венгрия (Hungarian): %b ".formatted(!size));
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();
        boolean count = animals.stream()
                .filter(animal -> animal.getGender() != "Male" && animal.getGender() != "Female")
                .collect(Collectors.toSet()).isEmpty();
        System.out.println(String.format("Все ли они пола Male и Female ? Answer: %b", !count));
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();
        boolean oceania = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Oceania"))
                .collect(Collectors.toSet())
                .isEmpty();
        System.out.println("Узнать что ни одно из них не имеет страну происхождения Oceania. Ответ: " + oceania);
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();
        Optional<Animal> oldest = animals.stream()
                .sorted((a1, a2) -> a1.getBread().compareToIgnoreCase(a2.getBread()))
                .limit(100)
                .max(Comparator.comparingInt(Animal::getAge));
        oldest.ifPresent(System.out::println);
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();
        char[] first = animals.stream()
                .map(a -> a.getBread().toCharArray())
                .sorted(Comparator.comparing(ch -> Integer.valueOf(ch.length)))
                .collect(Collectors.toList())
                .getFirst();
        System.out.println("длину самого короткого массива " + first.length);
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
        int sum = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();
        System.out.println("суммарный возраст всех животных " + sum);
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
        double indonesian = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .summaryStatistics()
                .getAverage();
        System.out.println("средний возраст всех животных из индонезии " + indonesian + " лет");
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();

        List<Person> male = persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> ((ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) >= 18) &&
                                   (ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) <= 27)))
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup))
                .limit(200)
                .collect(Collectors.toList());
        System.out.println("Взять на обучение академия может только: ");
        male.forEach(System.out::println);
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
//        houses.stream().
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
        List<String> studentList = students.stream()
                .filter(student -> student.getAge() <= 18)
                .sorted((s1, s2) -> s1.getSurname().compareToIgnoreCase(s2.getSurname()))
                .flatMap(stud -> Stream.of(String.format("имя %s возвраст %d", stud.getSurname(),
                        stud.getAge())))
                .collect(Collectors.toList());
        studentList.forEach(System.out::println);
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
        students.stream()
                .map(student -> student.getGroup())
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        Map<String, Double> collectByFaculty = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingDouble(Student::getAge)));
        collectByFaculty.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(e ->
                System.out.println("Faculty " + e.getKey() + "average of students " + e.getValue()));
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        String group;
        System.out.println("Введите номер группы, например M-2");
        try (Scanner scanner = new Scanner(System.in)) {
            group = scanner.nextLine().trim();
        }
        Map<Integer, Integer> collectStudents = examinations.stream().filter(s -> s.getExam3() > 4).collect(
                Collectors.toMap(Examination::getStudentId, Examination::getExam3));
        students.stream().filter(s -> s.getGroup().equals(group))
                .filter(s -> collectStudents.containsKey(s.getId()))
                .forEach(System.out::println);
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        Map<Integer, Integer> valueStudents = examinations.stream()
                .collect(Collectors.toMap(Examination::getStudentId,
                                Examination::getExam1));
        Map<String, IntSummaryStatistics> collect = students.stream()
                .filter(x -> valueStudents.containsKey(x.getId()))
                .collect(Collectors.groupingBy(Student::getGroup,
                        Collectors.summarizingInt(x -> valueStudents.get(x.getId()))));
        Optional<Map.Entry<String, IntSummaryStatistics>> max = collect.entrySet()
                .stream()
                .max((d1, d2) -> {
                            if (d1.getValue().getAverage() > d2.getValue().getAverage()) return (int) d1.getValue().getAverage();
                            return (int) d2.getValue().getAverage();
                        }
                );
        System.out.println("Группа с макс средним баллом номер - " + max
                .orElseThrow().getKey()
                + " и он равняется =" + max.orElseThrow().getValue().getAverage());
    }


    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
