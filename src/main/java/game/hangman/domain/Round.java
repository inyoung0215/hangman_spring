package game.hangman.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "round")
public class Round {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "round_id")
    private Long id;

    private Integer life;

    @Enumerated(EnumType.STRING)
    private Answer answers;

    @Enumerated(EnumType.STRING)
    private ResultStatus result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

    private LocalDateTime createAt;
}
