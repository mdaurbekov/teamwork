import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] products = {"Хлеб белый", "Хлеб черный", "Сахар 1 кг", "Масло сливочное 200гр", "Крупа гречневая 1 кг"};
        int[] prices = {40, 30, 100, 150, 100};
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

                if (productAmount == 0) {
                    basket[productCode] = 0;
                    continue;
                }

            } catch (NumberFormatException e) {

                System.out.println("Ошибка!Введены некорректные данные!");
                continue;
            }

            basket[productCode] += productAmount;
        }

        System.out.println("Ваша потребительская корзина:");
        for (int i = 0, j = 1; i < products.length; i++) {

            if (basket[i] != 0) {
                System.out.println(j + ") код " + (i + 1) + ". " + products[i] + ". Вы купили: "
                        + basket[i] + " ед. Цена: " + prices[i] + " руб. за ед.товара. Всего: "
                        + basket[i] * prices[i] + " руб.");
                basketSum += basket[i] * prices[i];
                j++;
            }
        }
        System.out.println("Итого " + basketSum + " руб.\nСпасибо за покупку!");
    }

}