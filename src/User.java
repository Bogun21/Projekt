public class User {
    private static int currentMaxId = 0;

    private int id;
    private String firstName;
    private String lastName;

    private User(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Użytkownik{" +
                "id=" + id +
                ", imię='" + firstName + '\'' +
                ", nazwisko='" + lastName + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;

        public Builder() {
            this.id = ++User.currentMaxId;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
