package ua.dp.daragan;

import java.util.regex.Pattern;

/**
 *
 * @author bogdan
 */
public interface GlobalConfig {
    Pattern NAME_PATTERN = Pattern.compile ("[a-zA-Z0-9_-]{4,32}" );
    Pattern PASS_PATTERN = Pattern.compile ("[a-zA-Z0-9+*_-]{4,32}" );
}