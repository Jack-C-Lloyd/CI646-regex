package ci646.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PhoneNumbers {

    // NB: backslashes are already "special" in java strings, so they need to be escaped twice in
    // regexes. Thus, the regex '\d' becomes '\\d' in Java. See
    // http://docs.oracle.com/javase/tutorial/essential/regex/ for details.

    private static final String local = "01\\d{3}\s*[1-9]\\d{5}";
    private static final String international = "\\+441\\d{3}[1-9]\\d{5}";

    private static final String regex = local + "|" + international; //modify this string to add your regex.
                                                 //You can of course make more string variables to hold regexes.
    private static final String prompt = "Enter a phone number or press return to end: ";

    public static void main(String[] args) {
        System.out.print(prompt);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String phoneNumber;
        try {
            phoneNumber = bufferedReader.readLine().trim();
            while(!phoneNumber.equals("")) {
                if(phoneNumber.matches(regex)) {
                    System.out.printf("%s is a valid UK landline number.\n", phoneNumber);
                } else {
                    System.out.printf("%s is not a valid UK landline number.\n", phoneNumber);
                }
                System.out.print(prompt);
                phoneNumber = bufferedReader.readLine().trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
