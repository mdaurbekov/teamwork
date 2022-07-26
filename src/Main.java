import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] products = {"Нарзан 0.5 л.", "Шоколад 100 гр.", "Йогурт", "Сырок глазированный", "Пломбир"};
        int[] prices = {80, 100, 50, 30, 70};
        int[] basket = new int[products.length];
        int basketSum = 0;
        int productCode;
        int productAmount;

        System.out.println("Список возможных товаров для покупки:");

        for (int i = 0; i < products.length; i++)
            System.out.println(i + 1 + ". " + products[i] + " - " + prices[i] + " руб.за единицу товара.");

        while (true) {

            System.out.println("Введите код товара и кол-во через пробел. End -выход.");
            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");

            if (parts.length != 2) {
                System.out.println("Ошибка! Нужно ввести 2 числа.");
                continue;
            }

            try {
                productCode = Integer.parseInt(parts[0]) - 1;

                if (productCode < 0 || productCode > products.length - 1) {
                    System.out.println("Ошибка!Код товара д.б. от 1 до " + products.length);
                    continue;
                }

            } catch (NumberFormatException e) {

                System.out.println("Ошибка!Введены некорректные данные!");
                continue;
            }

            try {

                productAmount = Integer.parseInt(parts[1]);

            } catch (NumberFormatException e) {

                System.out.println("Ошибка!Введены некорректные данные!");
                continue;
            }

            if (productAmount == 0) {

                basket[productCode] = 0;

            } else {

                basket[productCode] += productAmount;

            }
        }

        System.out.println("Ваша потребительская корзина:");
        for (int i = 0, j = 1; i < products.length; i++) {

            if (basket[i] > 0) {

                int actionSum = ((basket[i] - basket[i] % 3) * prices[i] * 2) / 3 + basket[i] % 3 * prices[i];

                System.out.println(j + ") код " + (i + 1) + ". " + products[i] + ". Вы купили: "
                        + basket[i] + " ед. Цена: " + prices[i] + " руб. за ед.товара. Всего: "
                        + actionSum + " руб.");
                basketSum += actionSum;
                j++;
            }
        }
        System.out.println("Итого " + basketSum + " руб.\nСпасибо за покупку!");
    }

}