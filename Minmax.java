import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

class Minmax {

  private static List<Integer> numbers;

  public static void main(String[] args) {
    while(true) {
      showMenu();
      Option myOption = scanOption();

      if (myOption.equals(Option.QUIT)) {
        return;
      }

      evaluateInputs(myOption);
      numbers.clear();
    }
  }

  private static void evaluateInputs(Option myOption) {
    numbers = new ArrayList<Integer>();
    while (true) {
      Scanner scanner = new Scanner(System.in);
      int number = 0;
      try {
        System.out.println("Enter a number");
        number = scanner.nextInt();
      } catch (InputMismatchException ex) {
        System.out.println("ignoring invalid number");
        continue;
      }

      if (number == -1000) {
        if (numbers.size() == 0) {
          return;
        }
        System.out.println(
          String.format(
            "%s is: %d",
            myOption,
            myOption.equals(myOption.SMALLEST)
              ? Collections.min(numbers)
              : Collections.max(numbers)
          )
        );
        return;
      }
      numbers.add(number);
    }
  }

  private static void showMenu() {
    System.out.println("1. Find Smallest");
    System.out.println("2. Find Largest");
    System.out.println("3. Quit");
  }

  private static Option scanOption() {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    return Option.getOption(input);
  }
}

enum Option {
  SMALLEST,
  LARGEST,
  QUIT,
  UNKNOWN;

  public static Option getOption(String option) {
    // this will refer to the object SMALL
    switch (option) {
      case "1":
        return SMALLEST;
      case "2":
        return LARGEST;
      case "3":
        return QUIT;
      default:
        return UNKNOWN;
    }
  }
}
