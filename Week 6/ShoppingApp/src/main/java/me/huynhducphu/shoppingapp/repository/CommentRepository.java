package me.huynhducphu.shoppingapp.repository;

import me.huynhducphu.shoppingapp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Admin 10/7/2025
 *
 **/
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
