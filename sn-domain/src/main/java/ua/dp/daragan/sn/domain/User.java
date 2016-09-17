package ua.dp.daragan.sn.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by bogdan on 17.09.16.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user") // ПОЛЕ user в класе Posts
    @ElementCollection
    protected List<Posts> posts;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user") // ПОЛЕ user в класе UserDetails
    protected UserDetails userDetails;

    @ManyToMany
    @JoinTable(name = "friendship",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "read_user_id", referencedColumnName = "user_id", nullable = false))
    private Set<User> friends;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public User(String username, String password, List<Posts> posts) {
        this.username = username;
        this.password = password;
        this.posts = posts;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}