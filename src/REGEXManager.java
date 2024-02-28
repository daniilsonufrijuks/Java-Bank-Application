static class REGEXManager {

    public boolean NameRegex(String name) {
        String expression = "^[a-zA-Z\\s]+"; // "^([A-Z][a-z]*((\s)))+[A-Z][a-z]*$"
        return name.matches(expression);
    }

    public boolean PersoncodeRegex(int pcode) {

    }

    public boolean EmailRegex(String email) {
        String expression = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(expression);
    } 
}