public class User {
    private String username;
    private String role; // "Student" or "Librarian"

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getRole() { return role; }

    public boolean isLibrarian() {
        return role.equalsIgnoreCase("Librarian");
    }
}
