import java.util.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        Random random = new Random();

        Scanner scanner = new Scanner(System.in);

        logger.log("Просим пользователя ввести входные данные для списка");

        System.out.print("\nВведите размер списка N : ");
        int listSizeN = scanner.nextInt();
        logger.log("Введите размер списка N : " + listSizeN);

        System.out.print("\nВведите верхнюю границу значений элементов в списке M : ");
        int highBorderM = scanner.nextInt();
        logger.log("Введите верхнюю границу значений элементов в списке M : " + highBorderM);

        List<Integer> allValues = Arrays.asList(new Integer[listSizeN]);
        logger.log("Создаём и наполняем список");

        StringBuilder listAllValuesForLog = new StringBuilder();

        for (int i = 0; i < allValues.size(); i++) {
            int randomInt = random.nextInt(highBorderM);
            allValues.set(i, randomInt);
            listAllValuesForLog.append(randomInt).append(" ");
        }

        logger.log("Вот случайный список: " + listAllValuesForLog);

        logger.log("Просим пользователя ввести входные данные для фильтрации");

        System.out.print("\nВведите число f для фильтрации списка : ");
        int digitF = scanner.nextInt();
        logger.log("Введите число f для фильтрации списка : " + digitF);

        logger.log("Запускаем фильтрацию");

        Filter filter = new Filter(digitF);
        List<Integer> result = filter.filterOut(allValues);

        logger.log("Выводим результат на экран");
        StringBuilder listResultForLog = new StringBuilder();
        for (Integer res : result) {
            listResultForLog.append(res).append(" ");
        }
        logger.log("Отфильтрованный список: " + listResultForLog);

        System.out.print("\nОтфильтрованный список: ");
        result.forEach((n) -> System.out.print(n + " "));

        logger.log("Завершаем программу");
        System.out.println(System.lineSeparator());

        logger.showLog();

    }
}
