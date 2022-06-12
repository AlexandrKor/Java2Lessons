package HomeWork3;

import java.util.Set;

public class PhoneBookApp {
    public static void main(String[] args){
        PhonebookSet phonebook = new PhonebookSet();
        phonebook.add("Иванов", "8911");
        phonebook.add("Петров", "8921");
        phonebook.add("Сидоров", "8813");
        phonebook.add("Иванов", "8911");
        phonebook.add("Корнеев", "258");
        phonebook.add("Панов", "7998");
        phonebook.add("Иванов", "8911771");

        Set<String> allSurname = phonebook.getAllSurname();
        for (String surname : allSurname) {
            System.out.printf("Абонент %s имеет номер(а) телефона %s %n", surname, phonebook.get(surname));
        }

    }

}
