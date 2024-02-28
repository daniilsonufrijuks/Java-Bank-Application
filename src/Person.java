public class Person {
    private String name;
    private String lastname;
    private String personcode;
    private String email;
    private String nickname;


    // setters 
    public void SetName(String Newname) {
        this.name = Newname;
    }

    public void SetLastName(String Newlastname) {
        this.lastname = Newlastname;
    }

    public void SetPersonCode(String Newpersoncode) {
        this.personcode = Newpersoncode;
    }

    public void SetEmail(String Newemail) {
        this.email = Newemail;
    }

    public void SetNickName(String Newnickname) {
        this.nickname = Newnickname;
    }

    // getters
    public String GetName() {
        return this.name;
    }

    public String GetLastName() {
        return this.lastname;
    }

    public String GetPersonCode() {
        return this.personcode;
    }

    public String GetEmail() {
        return this.email;
    }

    public String GetNickName() {
        return this.nickname;
    }
}