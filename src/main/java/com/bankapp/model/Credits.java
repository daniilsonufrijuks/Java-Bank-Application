package model;

public class Credits {
    private float total;
    private float peryeartaxes;
    private String description;
    // Constructor
    public Credits(float NewTotal, float NewPeryaertaxes, String Newdescription) {
        this.total = NewTotal;
        this.peryeartaxes= NewPeryaertaxes;
        this.description = Newdescription;
    }

    // Getters and Setters

    public float getTotal() {
        return total;
    }

    public void setTotal(float NewTotal) {
        this.total = NewTotal;
    }

    public float getPeryeartaxes() {
        return peryeartaxes;
    }

    public void setPeryeartaxes(float NewPeryaertaxes) {
        this.peryeartaxes = NewPeryaertaxes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Newdescription) {
        this.description = Newdescription;
    }

    
}