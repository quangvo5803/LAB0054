package Common;

import java.util.Scanner;

public class Validation {
    static final Scanner sc = new Scanner(System.in);
    private static final String PHONE_VALID1 = "^[0-9]{10}$";
    private static final String PHONE_VALID2 = "^[0-9]{3}-[0-9]{3}-[0-9]{4}$";
    private static final String PHONE_VALID3 = "^^[0-9]{3}.[0-9]{3}.[0-9]{4}$";
    private static final String PHONE_VALID4 = "^^[0-9]{3} [0-9]{3} [0-9]{4}$";
    private static final String PHONE_VALID5 = "^^[0-9]{3}-[0-9]{3}-[0-9]{4} (x|ext)[0-9]{4}$";
    private static final String PHONE_VALID6 = "^\\([0-9]{3}\\)-[0-9]{3}-[0-9]{4}$";

    public static String getString(String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();
        while (s.isEmpty()) {
            System.out.print("Enter again(Can not blank): ");
            s = sc.nextLine();
        }
        return s;
    }

    public static int getInt(String prompt) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }

    public static int getInt(String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(prompt);
            if (i < min)
                System.out.println("Error! Number must be greater than " + min + ".");
            else if (i > max) {
                System.out.println("Error! Number must be less than " + max + ".");
            } else
                isValid = true;
        }
        return i;
    }

    public static String getYesNo(String str) {
        String result = "";
        boolean check = true;
        do {
            System.out.print(str);
            String tmp = sc.nextLine();
            if (!tmp.isEmpty() && (tmp.equalsIgnoreCase("Y") || tmp.equalsIgnoreCase("N"))) {
                result = tmp;
                check = false;
            } else {
                System.out.println("Enter the wrong type, please re-enter (Y/N)!");
            }

        } while (check);
        return result;
    }

    public static String getPhone() {
        while (true) {
            String result = getString("Enter phone number: ");
            // check user input phone valid
            if (result.matches(PHONE_VALID1) || result.matches(PHONE_VALID2) ||
                result.matches(PHONE_VALID3) || result.matches(PHONE_VALID4) ||
                result.matches(PHONE_VALID5) || result.matches(PHONE_VALID6)) {
                return result;
            } else {
                System.out.printf("Please input Iphone follow\n"
               + "•	1234567890\n"
               + "•	123-456-7890\n"
               + "•	123-456-7890 x1234\n"
               + "•	123-456-7890 ext1234\n"
               + "•	(123)-456-7890\n"
               + "•	123.456.7890\n"
               + "•	123 456 7890\n");
            }
        }
    }
}
