import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("Użytkownik został dodany: " + user);
    }

    public void removeUser(int id) {
        users.removeIf(user -> user.getId() == id);
        System.out.println("User with ID " + id + " removed.");
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
