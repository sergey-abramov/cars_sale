package carsale.util;

import carsale.domain.Post;
import carsale.domain.User;

import java.time.ZoneId;
import java.util.TimeZone;

/**
 * Time zone conversion utility
 * @author Abramov Sergey
 */
public class TimeZoneConvert {

    public static void convert(Post post, User user) {
        if (user.getTimezone() == null) {
            user.setTimezone(TimeZone.getDefault().getID());
        }
        var time = post.getCreated()
                .atZone(ZoneId.of("UTC"))
                .withZoneSameInstant(ZoneId.of(user.getTimezone()))
                .toLocalDateTime();
        post.setCreated(time);
    }
}
