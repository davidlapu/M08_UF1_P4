package cat.itb.m08_uf1_p4.models;

public class Character {
    private String name;
    private int waepon, element;

    public Character(String name, int waepon, int element) {
        this.name = name;
        this.waepon = waepon;
        this.element = element;
    }

    public String getName() {
        return name;
    }
}
