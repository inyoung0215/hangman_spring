package game.hangman;

import game.hangman.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {
    @PersistenceContext
    EntityManager em;
    public Long save(User user) {
        em.persist(user);
        return user.getId();
    }
    public User find(Long id) {
        return em.find(User.class, id);
    } }