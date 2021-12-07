import java.util.*;

public class Main {


    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> newList = new ArrayList<>(intList);


        printConsol(sortTwo(sortOne(newList)));


        System.out.println("Использование Stream API:");
        StreamMain.streamSorted(intList);
    }

    public static List<Integer> sortOne(List<Integer> newList) {
        Iterator<Integer> iterator = newList.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (value <= 0 || value % 2 != 0) {
                iterator.remove();
            }
        }
        return newList;
    }

    public static List<Integer> sortTwo(List<Integer> newList) {
        Integer[] sorted = new Integer[newList.size()];
        for (int i = 0; i < newList.size(); i++) {
            sorted[i] = newList.get(i);
        }

        for (int i = sorted.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                int a = sorted[i];
                if (a < sorted[j]) {
                    int x = sorted[j];
                    sorted[i] = x;
                    sorted[j] = a;
                }
            }
        }
        newList = Arrays.asList(sorted);
        return newList;
    }


    public static void printConsol(List<Integer> newList) {
        System.out.println("Результат без использования Stream API:");
        for (int i = 0; i < newList.size(); i++) {//вывод на экран
            System.out.println(newList.get(i));
        }
    }
}









