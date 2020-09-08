public class Encrypter {

    private String code;

    public Encrypter() {
        this("");
    }
    public Encrypter(String code) {
        this.code = code;
    }

    public String encrypt(String code) {
        int digit1 = Character.getNumericValue(code.charAt(0));
        int digit2 = Character.getNumericValue(code.charAt(1));
        int digit3 = Character.getNumericValue(code.charAt(2));
        int digit4 = Character.getNumericValue(code.charAt(3));

        digit1 = convert(digit1);
        digit2 = convert(digit2);
        digit3 = convert(digit3);
        digit4 = convert(digit4);

        this.code = Integer.toString(digit3) + digit4 + digit1 + digit2;
        return this.code;
    }

    public static int convert(int digit) {
        digit += 7;
        digit %= 10;
        return digit;
    }

}
