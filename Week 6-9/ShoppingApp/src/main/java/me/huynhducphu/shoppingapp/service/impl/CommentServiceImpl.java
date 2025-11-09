package me.huynhducphu.shoppingapp.service.impl;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.model.Comment;
import me.huynhducphu.shoppingapp.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Admin 11/9/2025
 *
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements me.huynhducphu.shoppingapp.service.CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment create(Comment comment) {
        comment.setId(null);
        return commentRepository.save(comment);
    }

    @Override
    public Comment getById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Comment not found: " + id));
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getByProductId(Long productId) {
        return commentRepository.findByProductId(productId);
    }

    @Override
    public Comment update(Long id, Comment request) {
        Comment existing = getById(id);
        existing.setText(request.getText());

        if (request.getProduct() != null && request.getProduct().getId() != null) {
            existing.setProduct(request.getProduct());
        }

        return commentRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Comment comment = getById(id);
        commentRepository.delete(comment);
    }

}
