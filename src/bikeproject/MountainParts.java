package bikeproject;

public interface MountainParts {
    String TERRAIN = "off_road";
    
    void setSuspension(String newValue);
    void setType(String newValue);
    
    String getSuspension();
    String getType();
}
