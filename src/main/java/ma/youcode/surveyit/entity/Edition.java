package ma.youcode.surveyit.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "editions")
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edition_id")
    private Long id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "edition_yean")
    private LocalDateTime year;

    @OneToMany(mappedBy = "edition")
    private Set<Subject> subjects;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

}
