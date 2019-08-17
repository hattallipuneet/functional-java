package compare.fpij;

public class IterateString {

    private static final String STR = "w00t";

    public static void main(String[] args) {
        STR.chars()
                .forEach(System.out::println);

        STR.chars()
                .forEach(IterateString::printChar);

        STR.chars()
                .mapToObj(ch -> Character.valueOf((char) ch))
                .forEach(System.out::println);

        STR.chars()
                .filter(ch -> Character.isDigit(ch))
                .forEach(IterateString::printChar);

        STR.chars()
                .filter(Character::isDigit)
                .forEach(IterateString::printChar);
    }

    private static void printChar(int aChar) {
        System.out.println((char)aChar);
    }
}
