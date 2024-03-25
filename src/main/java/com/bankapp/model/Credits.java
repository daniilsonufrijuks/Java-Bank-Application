package model;

public class Credits {
    private float total;
    private float peryeartaxes;
    private String description;

    public Credits(float NewTotal, float NewPeryaertaxes, String Newdescription) {
        this.total = NewTotal;
        this.peryeartaxes= NewPeryaertaxes;
        this.description = Newdescription;
    }
}
