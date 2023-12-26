package com.sparta.trello.card.comment.entity;

import com.sparta.trello.card.comment.DTO.CommentCreateRequestDTO;
import com.sparta.trello.card.entity.Card;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "comments")
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    private String text;

    @Builder
    private Comment(CommentCreateRequestDTO commentCreateRequestDTO,Card card){
        this.text=commentCreateRequestDTO.getText();
        this.card=card;
    }

}
