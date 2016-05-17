package com.shop.service;

import com.shop.dao.CommentDao;
import com.shop.dao.ProductDao;
import com.shop.dao.UserDao;
import com.shop.dto.CommentDto;
import com.shop.entity.Comment;
import com.shop.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public List<CommentDto> getComments(int productId) {
        return commentMapper.toDtoList(commentDao.getComments(productId));
    }

    @Override
    public void removeComment(int commentId) {
        commentDao.removeComment(commentId);
    }

    @Override
    public CommentDto addComment(CommentDto commentDto) {
        Comment comment = commentMapper.fromDto(commentDto);
        comment.setDate(new Date(System.currentTimeMillis()));
        comment.setProduct(productDao.getProduct(commentDto.getProductId()));
        comment.setUser(userDao.findByUserLogin(commentDto.getUsername()));
        commentDao.addComment(comment);

        return commentMapper.toDto(comment);
    }

    @Override
    public CommentDto getComment(int commentId) {
        return commentMapper.toDto(commentDao.getComment(commentId));
    }
}
