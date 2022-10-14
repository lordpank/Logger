import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
       Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Введите входные данные для списка");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Введите размер списка: ");
            int arraySize = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Введите верхнюю границу для значений: ");
            int topBorder = Integer.parseInt(bufferedReader.readLine());
            logger.log("Создаём и наполняем список");

            List<Integer> numbers = getRandomNumbers(arraySize, topBorder);

            System.out.println("Вот случайный список: " + Arrays.toString(numbers.toArray()));
            logger.log("Просим пользователя ввести входные данные для фильтрации");

            System.out.println("Введите порог для фильтра: ");
            int filterLimit = Integer.parseInt(bufferedReader.readLine());

            Filter filter = new Filter(filterLimit);
            List<Integer> filteredNumbers = filter.filterOut(numbers);

            logger.log("Выводим результат на экран");

            System.out.println("Отфильтрованный список: " + Arrays.toString(filteredNumbers.toArray()));
            logger.log("Завершаем программу");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Integer> getRandomNumbers(int arraySize, int topBorder) {
        ArrayList<Integer> result = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            result.add(random.nextInt(topBorder));
        }

        return result;
    }
}
