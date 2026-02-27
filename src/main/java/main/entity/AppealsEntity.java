package main.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "appeals")
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class AppealsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String appeal;

    @Column(name = "useridentifier")
    String userIdentifier;


}
