package com.shop.service;

import com.shop.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getComments(int productId);

    void removeComment(int commentId);

    CommentDto addComment(CommentDto commentDto);

    CommentDto getComment(int commentId);
}
