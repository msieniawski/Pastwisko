package com.pastwisko.controller;

import com.pastwisko.model.Comment;
import com.pastwisko.model.CopyPasta;
import com.pastwisko.service.CommentService;
import com.pastwisko.service.CopyPastaService;
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

        copyPasta.addComment(comment);
        comment.setPasta(copyPasta);

        commentService.saveOrUpdate(comment);

        return ResponseEntity.ok(copyPasta);
    }

}
