package com.GeekBreins.HomeWork2;

public class HomeWorkApp {

    private static final int ARRAY_SIZE = 4;

    private static final String[][] CORRECT_DATA = new String[][]{
            {"28", "2", "4", "27"},
            {"13", "5", "67", "1"},
            {"1", "2", "4", "6"},
            {"1", "2", "3", "4"}
    };

    private static final String[][] INCORRECT_SIZE_DATA = new String[][]{
            {"28", "2", "4", "27"},
            {"13", "5", "1"},
            {"1", "2", "4", "6"},
            {"1", "2", "3", "4"}
    };

    private static final String[][] INCORRECT_MEANING_DATA = new String[][]{
            {"28", "2", "4", "27"},
            {"13", "5", "67", "1"},
            {"1", "2", "E4", "6"},
            {"1", "2", "3", "4"}
    };

    public static void main(String[] args) {
        try {
            int sum = sumArrayValues(INCORRECT_MEANING_DATA);
            System.out.println("Сумма = " + sum);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int sumArrayValues(String[][] data) {
        checkValues(data);

        int sumResult = 0;

        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
            String[] row = data[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                String stringValue = row[colIndex];
                try {
                    int intValue = Integer.parseInt(stringValue);
                    sumResult += intValue;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(stringValue, rowIndex, colIndex);
                }
            }
        }
        return sumResult;
    }

    private static void checkValues(String[][] data) {
        if (data.length != ARRAY_SIZE) {
            throw new MyArraySizeException();
        }

        for (String[] row : data) {
            if (row.length != ARRAY_SIZE) {
                throw new MyArraySizeException();
            }
        }
    }
}

