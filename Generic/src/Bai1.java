import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Boolean: ");
        Boolean bool = sc.nextBoolean();
        System.out.printf("Integer: ");
        int integer = sc.nextInt();
        System.out.printf("Long: ");
        long longNumber = sc.nextLong();
        System.out.printf("Byte: ");
        byte byteNumber = sc.nextByte();
        System.out.printf("Short: ");
        short shortNumber = sc.nextShort();
        System.out.printf("Double: ");
        double doubleNumber = sc.nextDouble();
        System.out.printf("Char: ");
        String character = sc.next();

        System.out.println();
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                bool,integer,longNumber,byteNumber,shortNumber,doubleNumber,character);
    }
}
