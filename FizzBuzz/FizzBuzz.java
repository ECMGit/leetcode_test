package FizzBuzz;

public class FizzBuzz {
    private int starter;
    private int end;

    public FizzBuzz(int starter, int end) {
        this.starter = starter;
        this.end = end;
    }

    public void FizzBuzzRunner() {
        for (int i = starter; i <= end; i++) {
            if (i == 0) {
                System.out.println(i);
                continue;
            }
            int fizz = i % 3 == 0 ? 0 : 1;
            int buzz = i % 5 == 0 ? 0 : 2;
            int sign = fizz + buzz;
            switch (sign) {
                case 0:
                    System.out.println("FizzBuzz!");
                    break;
                case 1:
                    System.out.println("Fizz!");
                    break;
                case 2:
                    System.out.println("Buzz!");
                    break;
                case 3:
                    System.out.println(i);
                    break;

            }
        }
    }
}
