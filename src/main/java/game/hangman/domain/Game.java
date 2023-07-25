package game.hangman.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "game")
    private List<Round> roundList = new ArrayList<>();

    private LocalDateTime createAt;

    public void setUser(User user){
        this.user = user;
        user.getGameList().add(this);
    }

    public void addRound(Round round){
        roundList.add(round);
        round.setGame(this);
    }
}
