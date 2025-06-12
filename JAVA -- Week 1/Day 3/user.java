public class user {
    private String name;
    private int age;
    private String email;

    private user(UserBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
    }

    public static class UserBuilder {
        private String name;
        private int age;
        private String email;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public user build() {
            return new user(this);
        }
    }

    public void printUser() {
        System.out.println(name + " - " + age + " - " + email);
    }
    public static void main(String[] args) {
        user us = new user.UserBuilder()
                .setName("Sachin")
                .setAge(21)
                .setEmail("sachin@gmail.com")
                .build();

        us.printUser();  // Output: John - 25 - john@example.com

    }

}

