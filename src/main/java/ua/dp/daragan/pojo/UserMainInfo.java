package ua.dp.daragan.pojo;

/**
 * Created by Bogdan Daragan on 01.10.16.
 */
public class UserMainInfo {
    private Long userId;
    private String username;

    public UserMainInfo(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public UserMainInfo() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
