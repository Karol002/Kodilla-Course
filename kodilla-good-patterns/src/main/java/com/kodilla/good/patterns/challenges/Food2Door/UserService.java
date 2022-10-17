package com.kodilla.good.patterns.challenges.Food2Door;

import com.kodilla.good.patterns.challenges.Food2Door.Suplliers.Supplier;

import java.util.List;
import java.util.Scanner;

public class UserService {
    private final Scanner scanner = new Scanner(System.in);

    public void showShopInformation(List<Supplier> suppliers) {
        for (int i=0; i<suppliers.size(); i++) {
            System.out.println((i + 1) + ". " + suppliers.get(i).toString());
        }
        System.out.println();
    }

    public int choseSupplier() {
        System.out.print("Chose supplier: ");
        int chose = scanner.nextInt();

        return chose - 1;
    }

    public int scanProductQuantity() {
        System.out.print("Chose product quantity: ");
        return scanner.nextInt();
    }

    public void orderInformation(OrderDto orderDto) {
        System.out.println(orderDto);
    }
}
