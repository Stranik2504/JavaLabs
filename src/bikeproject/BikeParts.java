package bikeproject;

public interface BikeParts {
    String NameCompany = "Apple";
    
    void setHandleBars(String newValue);
    void setFrame(String newValue);
    void setTyres(String newValue);
    void setSeatType(String newValue);
    
    String getHandleBars();
    String getFrame();
    String getTyres();
    String getSeatType();
}
