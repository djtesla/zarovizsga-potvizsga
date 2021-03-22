package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable{

    private String address;
    private int floorSpace;
    private int levels;

    public Office(String address, int floorSpace, int levels) {
        this.address = address;
        this.floorSpace = floorSpace;
        this.levels = levels;
    }

    public String getAddress() {
        return address;
    }

    public int getFloorSpace() {
        return floorSpace;
    }

    public int getLevels() {
        return levels;
    }

    @Override
    public int clean() {
        return floorSpace * levels * 100;
    }

    @Override
    public boolean isOffice() {
        return true;
    }
}
