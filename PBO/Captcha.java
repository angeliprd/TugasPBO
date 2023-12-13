import java.util.Random;

public class Captcha {
     // Generate a random 6-character captcha
    public static String generateCaptcha() {
        Random random = new Random();
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            captcha.append((char) (random.nextInt(26) + 'a'));
        }
        return captcha.toString();
    }
}