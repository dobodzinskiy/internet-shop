package com.shop.mapper;

import com.shop.dto.CommentDto;
import com.shop.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("commentMapper")
public class CommentMapper implements Mapper<Comment, CommentDto> {

    @Override
    public Comment fromDto(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setRate(commentDto.getRate());
        comment.setDate(new Date(System.currentTimeMillis()));
        comment.setText(commentDto.getText());
        return comment;
    }

    @Override
    public CommentDto toDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setUsername(comment.getUser().getLogin());
        commentDto.setRate(comment.getRate());
        commentDto.setText(comment.getText());
        commentDto.setDate(comment.getDate().toLocaleString());
        commentDto.setProductId(comment.getProduct().getId());
        return commentDto;
    }

    @Override
    public List<CommentDto> toDtoList(List<Comment> comments) {
        List<CommentDto> commentDtoList = new ArrayList<>();

        for (Comment comment : comments) {
            commentDtoList.add(this.toDto(comment));
        }

        return commentDtoList;
    }

    @Override
    public List<Comment> fromDtoList(List<CommentDto> commentDtos) {
        List<Comment> comments = new ArrayList<>();

        for (CommentDto commentDto : commentDtos) {
            comments.add(this.fromDto(commentDto));
        }

        return comments;
    }
}
