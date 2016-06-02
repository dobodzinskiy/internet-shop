package com.shop.dao;

import com.shop.entity.Comment;

import java.util.List;

public interface CommentDao {

    List<Comment> getComments(int productId);

    void removeComment(int commentId);

    void addComment(Comment comment);

    Comment getComment(int id);
}
