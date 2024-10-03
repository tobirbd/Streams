import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        List<Weapon> list = new ArrayList<>();

        //Aufgabe 1.1
        list = Files.lines(new File("weapons.csv").toPath())
                .skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapon(s[0],
                        CombatType.valueOf(s[1]),
                        DamageType.valueOf(s[2]),
                        Integer.parseInt(s[3]),
                        Integer.parseInt(s[4]),
                        Integer.parseInt(s[5]),
                        Integer.parseInt(s[6])
                ))
                .collect(Collectors.toList());

        //Aufgabe 1.2
        list.sort((w1, w2) -> Integer.compare(w1.getDamage(),w2.getDamage()));

        //Aufgabe 1.3
        list.forEach(System.out::println);
        list.sort(Comparator.comparing(Weapon::getCombatType)
                .thenComparing(Weapon::getDamageType)
                .thenComparing(Weapon::getName)
        );

        //Aufgabe 1.4
        System.out.println();
        list.forEach(System.out::println);

        System.out.println("________________________________________________________");

        //Aufgabe 1.5
        Printable printable = list1 -> list1.forEach(System.out::println);
        printable.print(list);

        //Aufgabe 1.6
        Printable printable1 = list2 -> list2.forEach();

    }
}