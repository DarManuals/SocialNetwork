package ua.dp.daragan.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.dp.daragan.NetworkApplication;
import ua.dp.daragan.entity.Posts;
import ua.dp.daragan.entity.User;
import ua.dp.daragan.repository.PostsRepository;
import ua.dp.daragan.repository.UserRepository;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Bogdan Daragan on 22.09.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NetworkApplication.class)
@WebAppConfiguration
public class postsControllerTest {

    @Mock
    private UserRepository userRepo;

    @Mock
    private PostsRepository postRepo;

    @Mock
    private postsController pc;

    @Before
    public void setUp() throws Exception {
        System.out.print("Running " + this.getClass().getName() + ": " );
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void makePost() throws Exception {
        System.out.println("makePost();");
        String username = "admin";
        User u = new User(username, "");
        when(userRepo.findByUsername(username)).thenReturn(u);
        userRepo.findByUsername(username);

        String postMsg = "post msg";
        Date date = new Date();
        Posts posts = new Posts(u, postMsg, date );

        when(postRepo.save(posts)).thenReturn(posts);
        postRepo.save(posts);

        when(pc.makePost(postMsg)).thenReturn("redirect:/profile");
        String res = pc.makePost(postMsg);

        assertEquals("redirect:/profile", res);

        verify(userRepo).findByUsername(username);
        verify(postRepo).save(posts);
        verify(pc).makePost(postMsg);
    }

    @Test
    public void delPost() throws Exception {

    }

}