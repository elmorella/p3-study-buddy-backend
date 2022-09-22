package com.revature.studybuddy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CARD")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    private String term;
    private String definition;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="setId",referencedColumnName = "setId")
    private Set set;
}
