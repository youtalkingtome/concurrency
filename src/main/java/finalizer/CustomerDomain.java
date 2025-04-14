package finalizer;

class CustomerDomain {
    private final int id;
    private final String email;
    private final String name;

    public CustomerDomain(int id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}