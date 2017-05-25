package com.pastwisko.service.impl;

import com.pastwisko.model.Comment;
import com.pastwisko.repository.CommentRepository;
import com.pastwisko.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> listAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getById(int id) {
        return commentRepository.findOne(id);
    }

    @Override
    public Comment saveOrUpdate(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(int id) {
        commentRepository.delete(id);
    }
}
