package com.GeekBreins.HomeWork2;

public class MyArrayDataException extends RuntimeException{

    public MyArrayDataException( String cellMeaning, int rowIndex, int colIndex) {
        super(String.format(" Ошибка!!! Неверное значение '%s' в ячейке [%d][%d]", cellMeaning, rowIndex, colIndex));

    }
}
