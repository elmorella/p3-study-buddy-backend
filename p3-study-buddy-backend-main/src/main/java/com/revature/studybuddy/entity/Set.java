package com.revature.studybuddy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CARDSETS")
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long setId;

    private String title;
    private String description;
}
