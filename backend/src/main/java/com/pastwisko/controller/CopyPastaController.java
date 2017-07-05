package com.pastwisko.controller;

import com.pastwisko.model.Comment;
import com.pastwisko.model.CopyPasta;
import com.pastwisko.model.Rating;
import com.pastwisko.model.Tag;
import com.pastwisko.service.CommentService;
import com.pastwisko.service.CopyPastaService;
import com.pastwisko.service.RatingService;
import com.pastwisko.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CopyPastaController {

    private final CopyPastaService copyPastaService;
    private final CommentService commentService;
    private final RatingService ratingService;
    private final TagService tagService;

    @GetMapping("api/pastas")
    @ResponseBody
    public List<CopyPasta> getAllCopyPastas() {
        return copyPastaService.listAll();
    }

    @GetMapping("api/pastas/{id}")
    @ResponseBody
    public CopyPasta getAllCopyPastas(@PathVariable int id) {
        return copyPastaService.getById(id);
    }

    @PostMapping("api/pastas/{id}/comment")
    public ResponseEntity<?> addComment(@PathVariable int id, @RequestBody Comment comment) {

        if (comment == null) {
            return ResponseEntity.badRequest().body("Comment is null");
        }

        CopyPasta copyPasta = copyPastaService.getById(id);

        copyPasta.add(comment);
        comment.setPasta(copyPasta);

        commentService.saveOrUpdate(comment);

        return ResponseEntity.ok(copyPasta);
    }

    @PostMapping("api/pastas/{id}/rating")
    public ResponseEntity<?> addRating(@PathVariable int id, @RequestBody Rating rating) {

        if (rating == null) {
            return ResponseEntity.badRequest().body("Rating is null");
        }

        CopyPasta copyPasta = copyPastaService.getById(id);

        copyPasta.add(rating);
        rating.setPasta(copyPasta);

        ratingService.saveOrUpdate(rating);

        return ResponseEntity.ok(copyPasta);
    }

    @PostMapping("api/pastas/{id}/tag")
    public ResponseEntity<?> addTag(@PathVariable int id, @RequestBody Tag tag) {

        if (tag == null) {
            return ResponseEntity.badRequest().body("Tag is null");
        }

        CopyPasta copyPasta = copyPastaService.getById(id);
        copyPasta.add(tag);

        tagService.saveOrUpdate(tag);

        return ResponseEntity.ok(copyPasta);
    }

}
