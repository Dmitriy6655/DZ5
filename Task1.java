// Реализуйте структуру телефонной книги с помощью HashMap, 
// учитывая, что 1 человек может иметь несколько телефонов.

import java.util.HashMap;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {

        Map<String, String> pB = new HashMap<String, String>();

        pB.put("Иванов В А", "89526336521; 85265236611");
        pB.put("Семенов К Г", "8947854121; 852369851");

        // System.out.println(pB.get("Семенов К Г"));
        // System.out.println(pB.get("Иванов В А"));

        boolean flag = true;
        while (flag) {
            System.out.println("add -добавление; del -удаление; sh - поиск; all - вывод всего; exit- выход.");
            System.out.println("Введите команду: ");
            String str = System.console().readLine().replace(" ", "");

            if (str.compareTo("exit") == 0) {

                System.out.println("До скорой встречи!");
                flag = false;
                System.exit(0);
                ;

            } else if (str.compareTo("add") == 0) {

                add(pB);
            } else if (str.compareTo("del") == 0) {

                del(pB);
            } else if (str.compareTo("all") == 0) {

                all(pB);
            } else if (str.compareTo("sh") == 0) {

                search(pB);
            }

        }

    }

    public static Map<String, String> add(Map<String, String> pB) {

        System.out.println("Введите ФИО в формате Иванов А М ");
        String name = System.console().readLine();
        System.out.println("Введите телефон 1,2...n через разделитель ';'");
        String phone = System.console().readLine();
        // добавление в коллекцию если такого ключа нет
        pB.putIfAbsent(name, phone);
        System.out.println("Абонент "+name+" добавлен");

        return pB;

    }

    public static Map<String, String> del(Map<String, String> pB) {

        System.out.println("Введите ФИО в формате Иванов А М ");
        String name = System.console().readLine();

        if (pB.get(name) != null) {

            System.out.println(pB.get(name));
            System.out.println("Удалить абонент? yes/no");
            String delAbon = System.console().readLine();
            if (delAbon.compareTo("yes") == 0) {

                pB.remove(name);
                System.out.println("Абонент удален");

            } else {
                return pB;
            }

        } else {
            System.out.println("Абонент не найден.");

        }

        return pB;

    }

    /**
     * @param pB
     */
    public static void all(Map<String, String> pB) {

        System.out.println((pB) + "\n");

    }

    public static void search(Map<String, String> pB) {

        System.out.println("Введите ФИО в формате Иванов А М ");
        String name = System.console().readLine();

        if (pB.get(name) != null) {

            System.out.println(name + " "+ pB.get(name));                     

        } 
        else {
            System.out.println("Абонент не найден.");
            
        }


       

    }

}
