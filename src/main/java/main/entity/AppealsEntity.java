package main.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

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

    private String appeal;

    @Column(name = "useridentifier")
    private String userIdentifier;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CitiesEntity city;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private AppealsStatusEntity appealsStatus;

    @Column(name = "resolved_at")
    private Timestamp resolvedAt;

}
