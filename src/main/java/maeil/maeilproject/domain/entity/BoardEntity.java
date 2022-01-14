package maeil.maeilproject.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
}
