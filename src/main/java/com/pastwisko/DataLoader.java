package com.pastwisko;

import com.pastwisko.model.User;
import com.pastwisko.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final CommentService commentService;
    private final CopyPastaService copyPastaService;
    private final RatingService ratingService;
    private final RatingValueService ratingValueService;
    private final TagService tagService;
    private final UserService userService;

    @Autowired
    public DataLoader(CommentService commentService, CopyPastaService copyPastaService, RatingService ratingService, RatingValueService ratingValueService, TagService tagService, UserService userService) {
        this.commentService = commentService;
        this.copyPastaService = copyPastaService;
        this.ratingService = ratingService;
        this.ratingValueService = ratingValueService;
        this.tagService = tagService;
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        User[] users = {
                new User("miki95", "jp2gmd", "mikolaj@gmail.com"),
                new User("kamil_komenda", "fifjsdlkfj", "kamil@gmail.com"),
                new User("radzix5000", "djjj123", "tomek@gmail.com"),
                new User("fredr0", "fredr0000xx", "fredro@gmail.com"),
                new User("tami", "aq12rf3", "tami@gmail.com"),
                new User("olo2137", "1488hh", "olaf_sniezek@gmail.com"),
                new User("paulinka_winkowska", "hubertlove", "paulina@gmail.com")
        };

        for (User user : users) {
            userService.saveOrUpdate(user);
        }
    }
}
