package com.pastwisko.controller;

import com.pastwisko.model.Tag;
import com.pastwisko.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TagController {

    private final TagService tagService;

    @GetMapping("api/tags")
    public ResponseEntity<?> getAllTags() {
        List<Tag> tags = tagService.listAll();
        return ResponseEntity.ok(tags);
    }

    @PostMapping("api/tags")
    public ResponseEntity<?> addTag(@RequestBody Tag tag) {

        if (tag == null)
            return ResponseEntity.badRequest().body("Tag is null");

        tagService.saveOrUpdate(tag);

        return ResponseEntity.ok(tag);
    }

}
