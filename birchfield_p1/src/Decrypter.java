public class Decrypter {

    private String code;

    public Decrypter() {
        this("");
    }
    public Decrypter(String code) {
        this.code = code;
    }

    public String decrypt(String code) {
        int digit1 = Character.getNumericValue(code.charAt(0));
        int digit2 = Character.getNumericValue(code.charAt(1));
        int digit3 = Character.getNumericValue(code.charAt(2));
        int digit4 = Character.getNumericValue(code.charAt(3));

        digit1 = reverseConvert(digit1);
        digit2 = reverseConvert(digit2);
        digit3 = reverseConvert(digit3);
        digit4 = reverseConvert(digit4);

        this.code = Integer.toString(digit3) + digit4 + digit1 + digit2;
        return this.code;
    }

    public static int reverseConvert(int digit) {
        digit += 3;
        digit %= 10;
        return digit;
    }

}
