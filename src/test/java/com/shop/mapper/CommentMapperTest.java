package com.shop.mapper;

import com.shop.dto.CommentDto;
import com.shop.entity.Comment;
import com.shop.entity.Product;
import com.shop.entity.User;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by dobodzinskiy on 08.04.2016.
 */
public class CommentMapperTest {

    private static final int ID = 1;
    private static final int RATE = 1;
    private static final String USERNAME = "user";
    private static final int PRODUCT_ID = 1;
    private static final Date DATE = new Date(10, 10, 10);
    private static final String TEXT = "comment";

    @InjectMocks
    private CommentMapper commentMapper = new CommentMapper();

    @Test
    public void testFromDto() {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(ID);
        commentDto.setUsername(USERNAME);
        commentDto.setProductId(PRODUCT_ID);
        commentDto.setDate("DATE");
        commentDto.setRate(RATE);
        commentDto.setText(TEXT);

        Comment comment = commentMapper.fromDto(commentDto);
        assertEquals(ID, comment.getId());
        assertEquals(RATE, comment.getRate());
        assertEquals(TEXT, comment.getText());
    }

    @Test
    public void testToDto() {
        Comment comment = new Comment();
        User user = new User();
        user.setLogin(USERNAME);
        Product product = new Product();
        product.setId(PRODUCT_ID);
        comment.setUser(user);
        comment.setProduct(product);
        comment.setId(ID);
        comment.setDate(DATE);
        comment.setRate(RATE);
        comment.setText(TEXT);

        CommentDto commentDto = commentMapper.toDto(comment);
        assertEquals(ID, commentDto.getId());
        assertEquals(USERNAME, commentDto.getUsername());
        assertEquals(PRODUCT_ID, commentDto.getProductId());
        assertEquals(DATE.toLocaleString(), commentDto.getDate());
        assertEquals(RATE, commentDto.getRate());
        assertEquals(TEXT, commentDto.getText());

    }
}
