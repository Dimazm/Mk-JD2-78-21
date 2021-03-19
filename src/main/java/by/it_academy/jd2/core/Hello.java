package by.it_academy.jd2.core;
import by.it_academy.jd2.core.utils.ApacheCommonsLang3;

public class Hello {
    /**
     * the first method for all Junior Developers
     *
     * @param args is String with samples to test
     *
     * @return {@code true} if only contains lowercase characters, and is non-null
     */
    public static void main(String[] args) {

        for (String arg:args) {
            if (ApacheCommonsLang3.isAllLowerCase(arg)){
                System.out.println(arg);
            }
        }
    }
}
