package main.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="appeals_status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppealsStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "status_name")
    private String statusName;
}
