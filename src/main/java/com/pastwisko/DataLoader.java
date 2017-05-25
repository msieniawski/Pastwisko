package com.pastwisko;

import com.pastwisko.model.*;
import com.pastwisko.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    private final CommentService commentService;
    private final CopyPastaService copyPastaService;
    private final RatingService ratingService;
    private final TagService tagService;
    private final UserService userService;

    @Autowired
    public DataLoader(CommentService commentService, CopyPastaService copyPastaService, UserService userService,
                      RatingService ratingService, TagService tagService) {
        this.commentService = commentService;
        this.copyPastaService = copyPastaService;
        this.userService = userService;
        this.ratingService = ratingService;
        this.tagService = tagService;
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

        Tag[] tags = {
                new Tag("#pasta"),
                new Tag("#bk"),
                new Tag("#przegryw"),
                new Tag("#wygryw"),
                new Tag("#klasyk")
        };

        CopyPasta[] pastas = {
                new CopyPasta("cejrowski", "cejrowski", Date.valueOf(LocalDate.now()), users[0]),
                new CopyPasta("krawczyk", "krawczyk", Date.valueOf(LocalDate.now()), users[1]),
                new CopyPasta("wedkarz", "wedkarz", Date.valueOf(LocalDate.now()), users[1]),
                new CopyPasta("rigcz", "rigcz", Date.valueOf(LocalDate.now()), users[2])
        };

        pastas[0].getTags().add(tags[0]);
        tags[0].getPastaList().add(pastas[0]);

        pastas[0].getTags().add(tags[1]);
        tags[1].getPastaList().add(pastas[0]);

        pastas[0].getTags().add(tags[2]);
        tags[2].getPastaList().add(pastas[0]);

        pastas[0].getTags().add(tags[3]);
        tags[3].getPastaList().add(pastas[0]);

        pastas[1].getTags().add(tags[3]);
        tags[3].getPastaList().add(pastas[1]);

        pastas[1].getTags().add(tags[0]);
        tags[0].getPastaList().add(pastas[1]);

        for (CopyPasta pasta : pastas) {
            copyPastaService.saveOrUpdate(pasta);
        }

        Comment[] comments = {
                new Comment("świetna pasta", users[5], pastas[3]),
                new Comment("ujdzie", users[5], pastas[3]),
                new Comment("hehe", users[3], pastas[2]),
                new Comment("złoto xD", users[3], pastas[1]),
                new Comment("MODEEE", users[2], pastas[0]),
                new Comment(".", users[1], pastas[0])
        };

        for (Comment comment : comments) {
            commentService.saveOrUpdate(comment);
        }

        Rating[] ratings = {
                new Rating(5, users[3], pastas[0]),
                new Rating(4, users[2], pastas[0]),
                new Rating(4, users[1], pastas[3]),
                new Rating(1, users[6], pastas[2]),
                new Rating(2, users[4], pastas[1])
        };

        for (Rating rating : ratings) {
            ratingService.saveOrUpdate(rating);
        }

        for (Tag tag : tags) {
            tagService.saveOrUpdate(tag);
        }


    }
}
