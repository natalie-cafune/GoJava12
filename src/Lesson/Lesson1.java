package Lesson;

import java.util.Scanner;

public class Lesson1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name : ");
        String name = sc.nextLine();

        System.out.print("Enter your city : ");
        String city = sc.nextLine();

        System.out.print("Enter your age : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter your hobby : ");
        String hobby = sc.nextLine();
        System.out.print(" Name: " + name + "\n " + "City: " +  city + "\n "
                 + "Age: " + age + "\n " + "Hobby: " + hobby  );

    }
}
