package com.company;

import java.util.Scanner;

public class Main {
    /**
    + На консоль пользователь должен сначала ввести числа от 1 до 5. Затем компилятор попросит ввести состояние. Так можно будет чередовать.
     */

    public static void main(String[] args) throws Exception {

        AutoBase.autoBase();
        AutoDriver.autoDriver();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Выберите трак от 1 до 5");
            String input = sc.nextLine();
            int id = 5;
            //int id = Integer.parseInt(input);
            switch (id) {
                case 1:
                    System.out.println("N: " + 1);
                    System.out.println("Bus: " + "RENAULT_MAGNUM");
                    System.out.println("Driver: " + "Petr");
                    System.out.println("Bus State: " + State.BASE);
                    break;
                case 2:
                    System.out.println("N: " + 2);
                    System.out.println("Bus: " + "BMV");
                    System.out.println("Driver: " + "Vova");
                    System.out.println("Bus State: " + State.BASE);
                    break;
                case 3:
                    System.out.println("N: " + 3);
                    System.out.println("Bus: " + "DAF_XT");
                    System.out.println("Driver: " + "Sasha");
                    System.out.println("Bus State: " + State.BASE);
                    break;
                case 4:
                    System.out.println("N: " + 4);
                    System.out.println("Bus: " + "TOYOTA");
                    System.out.println("Driver: " + "Toma");
                    System.out.println("Bus State: " + State.BASE);
                    break;
                case 5:
                    System.out.println("N: " + 5);
                    System.out.println("Bus: " + "VOLVO");
                    System.out.println("Driver: " + "Misha");
                    System.out.println("Bus State: " + State.BASE);
                    break;

                default:
                    System.out.println("Неверный id");
            }
            try {
                Truck truck = new Truck();
                System.out.println("Введите новое состояние трака (BASE, ROUT, REPAIR)");
                String state = sc.nextLine();
                truck.changeState(state);
                truck.changeDriver();
                truck.startDriving();
                truck.startRepair();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}