public class User {
    protected final Mediator _mediator;
    protected final String _name;
    
    public User(String name, Mediator mediator) {
        _name = name;
        _mediator = mediator;
    }
    
    public String getName() {
        return _name;
    }
    
    public void sendMessage(String message) {
        _mediator.sendMessage(this, message);
    }
}
