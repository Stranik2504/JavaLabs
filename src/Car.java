import java.time.LocalDateTime;
import java.util.Date;

public class Car {
    private String _model;
    private String _license;
    private String _color;
    private int _year;
    
    public String getModel() { return _model; }
    public void setModel(String model) { _model = model; }
    
    public String getLicense() { return _license; }
    public void setLicense(String license) { _license = license; }
    
    public String getColor() { return _color; }
    public void setColor(String color) { _color = color; }
    
    public int getYear() { return _year; }
    public void setYear(int year) { _year = year; }
    
    public Car(String model, String license, String color, int year)
    {
        _model = model;
        _license = license;
        _color = color;
        _year = year;
    }
    
    public Car() {
        _model = "BMW";
        _license = "1";
        _color = "Red";
        _year = 2004;
    }
    
    public Car(String model, int year) {
        _model = model;
        _license = "1";
        _color = "Blue-labydi-labuda";
        _year = year;
    }
    
    public void To_String() {
        System.out.printf("Model: %s, License: %s, Color: %s, Year: %d%n", _model, _license, _color, _year);
    }
    
    public int getAge() {
        return LocalDateTime.now().getYear() - _year;
    }
}
