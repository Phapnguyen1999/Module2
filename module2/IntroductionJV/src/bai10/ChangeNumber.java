package bai10;

import java.util.Scanner;

public class ChangeNumber {
    public static void main(String[] args) {
        int number;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number: ");
            number = scanner.nextInt();
            int situation = number < 0 ? 0 : number < 10 ? 1 : number < 20 ? 2 : number < 100 ? 3 : number < 1000 ? 4 : number;
            int firstDigit = number / 100;
            int secondDigit = number / 10 % 10;
            int thirdDigit = number % 10;
            String first = "";
            String second = "";
            String third = "";
            String special = "";
            switch (firstDigit) {
                case 1:
                    first = "One";
                    break;
                case 2:
                    first = "Two";
                    break;
                case 3:
                    first = "Three";
                    break;
                case 4:
                    first = "Four";
                    break;
                case 5:
                    first = "Five";
                    break;
                case 6:
                    first = "Six";
                    break;
                case 7:
                    first = "Seven";
                    break;
                case 8:
                    first = "Eight";
                    break;
                case 9:
                    first = "Nine";
                    break;
            }

            switch (secondDigit) {
                case 1:
                    switch (thirdDigit) {
                        case 0:
                            special = "Ten";
                            break;
                        case 1:
                            special = "Eleven";
                            break;
                        case 2:
                            special = "Twelve";
                            break;
                        case 3:
                            special = "Thirteen";
                            break;
                        case 4:
                            special = "Fourteen";
                            break;
                        case 5:
                            special = "Fifteen";
                            break;
                        case 6:
                            special = "Sixteen";
                            break;
                        case 7:
                            special = "Seventeen";
                            break;
                        case 8:
                            special = "Eighteen";
                            break;
                        case 9:
                            special = "Nineteen";
                            break;
                    }
                    break;
                case 2:
                    second = "Twenty";
                    break;
                case 3:
                    second = "Thirty";
                    break;
                case 4:
                    second = "Forty";
                    break;
                case 5:
                    second = "Fifty";
                    break;
                case 6:
                    second = "Sixty";
                    break;
                case 7:
                    second = "Seventy";
                    break;
                case 8:
                    second = "Eighty";
                    break;
                case 9:
                    second = "Ninety";
                    break;
            }

            switch (thirdDigit) {
                case 0:
                    third = "Zero";
                    break;
                case 1:
                    third = "One";
                    break;
                case 2:
                    third = "Two";
                    break;
                case 3:
                    third = "Three";
                    break;
                case 4:
                    third = "Four";
                    break;
                case 5:
                    third = "Five";
                    break;
                case 6:
                    third = "Six";
                    break;
                case 7:
                    third = "Seven";
                    break;
                case 8:
                    third = "Eight";
                    break;
                case 9:
                    third = "Nine";
                    break;
            }


            switch (situation) {
                case 1:
                    System.out.println(third);
                    break;

                case 2:
                    System.out.println(special);
                    break;

                case 3: {
                    if (thirdDigit == 0) {
                        third = "";
                    }
                    System.out.println(second + " " + third);
                }
                break;

                case 4: {
                    if (secondDigit == 0) {
                        if (thirdDigit == 0) {
                            System.out.println(first + " hundred");
                        } else {
                            System.out.println(first + " hundred " + third);
                        }
                    } else if (secondDigit == 1) {
                        System.out.println(first + " hundred " + special);
                    } else if (thirdDigit == 0) {
                        System.out.println(first + " hundred " + second);
                    } else {
                        System.out.println(first + " hundred " + second + " " + third);
                    }
                }
                break;

                case 0:
                default:
                    System.out.println("Sorry, out of our ability!");
                    break;
            }
        } while (number != -1);
    }
}