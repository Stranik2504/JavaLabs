public class BaseText implements Text {
    private final String text;

    public BaseText(String text) {
        this.text = text;
    }

    public void display() {
        System.out.print(text);
    }
}
