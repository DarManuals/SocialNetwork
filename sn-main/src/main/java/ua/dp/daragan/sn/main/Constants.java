package ua.dp.daragan.sn.main;

import java.util.regex.Pattern;

/**
 * Created by bogdan on 17.09.16.
 */
public interface Constants {

    Pattern NAME_PATTERN = Pattern.compile ("[a-zA-Z0-9_-]{4,32}" );
    Pattern SEARCH_NAME_PATTERN = Pattern.compile ("[a-zA-Z0-9_-]{1,32}" );
    Pattern PASS_PATTERN = Pattern.compile ("[a-zA-Z0-9+*_-]{4,32}" );
    int POSTS_PER_PAGE = 5;
    int USERS_PER_PAGE = 10;
}