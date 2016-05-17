package com.shop.dao;

import com.shop.entity.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("commentDao")
@Transactional
public class CommentDaoImpl implements CommentDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Comment> getComments(int productId) {
        TypedQuery<Comment> getComments = entityManager.createNamedQuery("getComments", Comment.class);
        return getComments.setParameter("id", productId).getResultList();
    }

    @Override
    public void removeComment(int commentId) {
        Comment comment = entityManager.find(Comment.class, commentId);
        entityManager.remove(comment);
    }

    @Override
    public void addComment(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public Comment getComment(int id) {
        Comment comment = entityManager.find(Comment.class, id);
        return comment;
    }
}
