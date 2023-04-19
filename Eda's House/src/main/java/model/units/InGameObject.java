package model.units;

public abstract class InGameObject {
    private int[] coordinates;
    private String imageURL;
    private int actionCode;

    public int[] getCoordinates() {
        return this.coordinates;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public int getActionCode() {
        return this.actionCode;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setCoordinates(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setCoordinates(int actionCode) {
        this.actionCode = actionCode;
    }
}
