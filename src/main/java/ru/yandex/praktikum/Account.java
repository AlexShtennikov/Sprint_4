package ru.yandex.praktikum;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        //Проверка длины
        if (name.length() < 3 && name.length() > 19) {
            return false;
        }

        //Проверка одного пробела
        if (name.indexOf(" ") != name.lastIndexOf(" ")) {
            return false;
        }

        //Проверка, что пробел не в начале строки
        if (name.indexOf(" ",0) == 0) {
            return false;

        }

        //Проверка, что пробел не в конце строки
        if (name.lastIndexOf(" ", name.length()) == name.length() - 1) {
            return false;
        }

        return true;
    }

}
