public class Main {
    public static void main(String[] args) {
        var text = new BaseText("Hello, World!");
        var underlinedText = new UnderlinedDecorator(text);
        var boldText = new BoldDecorator(underlinedText);
        var italicText = new ItalicDecorator(boldText);
        
        text.display();
        System.out.println();
        italicText.display();
        System.out.println();
    }
}