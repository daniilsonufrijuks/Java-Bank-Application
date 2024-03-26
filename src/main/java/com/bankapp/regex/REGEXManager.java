package regex;


public class REGEXManager {

    // regex for name/last name
    public static boolean NameRegex(String name) {
        String expression = "^[a-zA-Z\\s]+"; // "^([A-Z][a-z]*((\s)))+[A-Z][a-z]*$"
        return name.matches(expression); // return if the name matches the expression
    }

    // regex for personal code
    public static boolean PersoncodeRegex(String pcode) {
        String expression = "^\\d{6}-\\d{5}$";
        return pcode.matches(expression); // return if the personal code matches the expression
    }

    // regex for email
    public static boolean EmailRegex(String email) {
        String expression = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(expression); // return if the email matches the expression
    } 

    public static boolean isValidFloat(String input) {
        return input.matches("^\\d+(\\.\\d{1,2})?$");
    }
}