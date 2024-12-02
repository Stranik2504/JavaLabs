public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Chat();
        
        var u1 = new User("Биба", mediator);
        var u2 = new User("Боба", mediator);

        var admin = new AdminUser(mediator);
        
        u1.sendMessage("[join]");
        u2.sendMessage("[join]");
        admin.sendMessage("[join]");
        
        u1.sendMessage("Привет");
        u2.sendMessage("Привет");
        
        u1.sendMessage("Как дела?");
        u2.sendMessage("Хорошо");
        
        admin.sendMessage("Привет");
        
        u1.sendMessage("[leave]");
        u2.sendMessage("[leave]");
    }
}