package me.huynhducphu.shoppingapp.service;

import me.huynhducphu.shoppingapp.model.Comment;

import java.util.List;

/**
 * Admin 11/9/2025
 *
 **/
public interface CommentService {
    Comment create(Comment comment);

    Comment getById(Long id);

    List<Comment> getAll();

    List<Comment> getByProductId(Long productId);

    Comment update(Long id, Comment request);

    void delete(Long id);
}
