package swagLabs.utils;

public class TestData {
    public static final String VALID_USER = "standard_user";
    public static final String VALID_PASSWORD = "secret_sauce";

    // Method to generate a random zip code for checkout
    public static String getRandomZipCode() {
        return String.valueOf((int)(Math.random() * 90000) + 10000);
    }
}
