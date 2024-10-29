package ma.youcode.surveyit.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "survey_editions")
public class SurveyEdition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_edition_id")
    private Long id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "year_edition")
    private LocalDateTime yean;

    @OneToMany(mappedBy = "surveyedition")
    private Set<Subject> subjects;

}
