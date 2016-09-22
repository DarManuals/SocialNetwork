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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Bogdan Daragan on 22.09.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NetworkApplication.class)
@WebAppConfiguration
public class indexControllerTest {

    @Mock
    private indexController ic;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void indexTest(){
        String result = ic.index();
        when(ic.index()).thenReturn("index");
        verify(ic).index();
    }
}