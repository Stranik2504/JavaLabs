public class UnderlinedDecorator extends TextDecorator {
    public UnderlinedDecorator(Text text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.print("<u>");
        text.display();
        System.out.print("</u>");
    }
}
