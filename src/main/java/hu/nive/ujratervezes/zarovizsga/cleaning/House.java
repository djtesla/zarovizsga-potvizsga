package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable{

    private String address;
    private int floorSpace;

    public House(String address, int floorSpace) {
        this.address = address;
        this.floorSpace = floorSpace;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public int getFloorSpace() {
        return floorSpace;
    }

    @Override
    public int clean() {
        return floorSpace * 80;
    }

    @Override
    public boolean isOffice() {
        return false;
    }
}
