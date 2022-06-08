package servlet;

public class ClassFind {

    private int id;

    @Override
    public String toString() {
        return "ClassFind{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", man='" + man + '\'' +
                '}';
    }

    public ClassFind(int id, String username, String address, String man) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.man = man;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    private String username;
    private String address;
    private String man;


}
