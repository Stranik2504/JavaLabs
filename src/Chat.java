import java.util.ArrayList;

public class Chat implements Mediator {
    private final ArrayList<User> _users = new ArrayList<>();
    
    @Override
    public void sendMessage(User user, String message) {
        if (message.equals("[join]")) {
            _users.add(user);
            
            if (user instanceof AdminUser) 
                return;
            
            System.out.println(user.getName() + " joined the chat");
            return;
        }
        
        if (message.equals("[leave]")) {
            _users.remove(user);
            
            if (user instanceof AdminUser) 
                return;
            
            System.out.println(user.getName() + " left the chat");
            return;
        }
        
        if (user instanceof AdminUser) {
            System.out.println("Message: " + message + ". Broadcast for all");
            return;
        }
        
        for (var u : _users) {
            if (!u.equals(user) && !(u instanceof AdminUser))
                System.out.println(u.getName() + " received: " + message + "(from: " + user.getName() + ")");
        }
    }
}
