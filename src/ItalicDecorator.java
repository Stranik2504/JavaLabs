public class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(Text text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.print("<i>");
        text.display();
        System.out.print("</i>");
    }
}
