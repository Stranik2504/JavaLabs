public class BoldDecorator extends TextDecorator {
    public BoldDecorator(Text text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.print("<b>");
        text.display();
        System.out.print("</b>");
    }
}
