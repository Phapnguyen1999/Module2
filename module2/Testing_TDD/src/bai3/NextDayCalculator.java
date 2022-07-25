package bai3;

public class NextDayCalculator {
    private int day;
    private int month;
    private int year;

    public NextDayCalculator(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean checkYear(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }

    public static String nextDay(int day, int month, int year) {
        if (checkYear(year)) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                    if (day > 0 && day < 31)
                        return (day + 1) + "/" + month + "/" + year;
                    if (day == 31)
                        return 1 + "/" + (month + 1) + "/" + year;
                case 2:
                    if (day > 0 && day < 29)
                        return (day + 1) + "/" + month + "/" + year;
                    if (day == 29)
                        return 1 + "/" + (month + 1) + "/" + year;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day > 0 && day < 30)
                        return (day + 1) + "/" + month + "/" + year;
                    else if (day == 30)
                        return 1 + "/" + (month + 1) + "/" + year;
                case 12:
                    if (day > 0 && day < 31)
                        return (day + 1) + "/" + month + "/" + year;
                    else if (day == 31)
                        return 1 + "/" + 1 + "/" + (year + 1);
            }
        } else
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                    if (day > 0 && day < 31)
                        return (day + 1) + "/" + month + "/" + year;
                    if (day == 31)
                        return 1 + "/" + (month + 1) + "/" + year;
                case 2:
                    if (day > 0 && day < 28)
                        return (day + 1) + "/" + month + "/" + year;
                    if (day == 28)
                        return 1 + "/" + (month + 1) + "/" + year;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day > 0 && day < 30)
                        return (day + 1) + "/" + month + "/" + year;
                    if (day == 30)
                        return 1 + "/" + (month + 1) + "/" + year;
                case 12:
                    if (day > 0 && day < 31)
                        return (day + 1) + "/" + month + "/" + year;
                    if (day == 31)
                        return 1 + "/" + 1 + "/" + (year + 1);
            }
        return "Nhap lai ngay";
    }
}

