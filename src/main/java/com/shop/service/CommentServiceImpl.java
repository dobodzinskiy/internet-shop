package com.shop.service;

import com.shop.dao.CommentDao;
import com.shop.dao.ProductDao;
import com.shop.dao.UserDao;
import com.shop.dto.CommentDto;
import com.shop.entity.Comment;
import com.shop.entity.User;
import com.shop.entity.UserRoles;
import com.shop.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CommentDto> getComments(int productId) {
        return commentMapper.toDtoList(commentDao.getComments(productId));
    }

    @Override
    @Transactional(readOnly = true)
    public CommentDto getComment(int commentId) {
        return commentMapper.toDto(commentDao.getComment(commentId));
    }

    @Override
    public void removeComment(int commentId) {
        Comment comment = commentDao.getComment(commentId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.findByUserLogin(authentication.getName());
        if (user.getUserRoles().contains(UserRoles.ROLE_ADMIN)) {
            commentDao.removeComment(commentId);
        } else if (user.getId() == comment.getUser().getId()) {
            commentDao.removeComment(commentId);
        }
    }

    @Override
    public CommentDto addComment(CommentDto commentDto) {
        Comment comment = commentMapper.fromDto(commentDto);
        comment.setProduct(productDao.getProduct(commentDto.getProductId()));
        comment.setUser(userDao.findByUserLogin(commentDto.getUsername()));
        commentDao.addComment(comment);
        return commentMapper.toDto(comment);
    }
}
