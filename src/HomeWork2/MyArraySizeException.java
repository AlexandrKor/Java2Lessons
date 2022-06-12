package HomeWork2;

public class MyArraySizeException extends IllegalArgumentException{

    public MyArraySizeException() {
        super("Ошибка !!! Неверный размер массива, должно быть 4 х 4 .");
    }
}
