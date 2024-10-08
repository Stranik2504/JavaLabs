package bikeproject;

public interface RoadParts {
    String terrain = "track_racing";
    
    void setTyreWidth(String newValue);
    void setPostHeight(String newValue);
    
    String getTyreWidth();
    String getPostHeight();
}
