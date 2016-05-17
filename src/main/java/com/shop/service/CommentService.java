package com.shop.service;

import com.shop.dto.CommentDto;

import java.util.List;

/**
 * Created by dobodzinskiy on 02.04.2016.
 */
public interface CommentService {
    List<CommentDto> getComments(int productId);
    void removeComment(int commentId);
    CommentDto addComment(CommentDto commentDto);
    CommentDto getComment(int commentId);
}
