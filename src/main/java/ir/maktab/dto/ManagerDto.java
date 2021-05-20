package ir.maktab.dto;


public class ManagerDto {
    private Integer id;
    private String userName;
    private String password;

    public Integer getId() {
        return id;
    }

    public ManagerDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ManagerDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ManagerDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
