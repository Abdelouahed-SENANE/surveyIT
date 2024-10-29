package ma.youcode.surveyit.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long id;

    @Column(name = "subject_title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Subject parent;

    @OneToMany(mappedBy = "parent" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private Set<Subject> subSubjects;

    @ManyToOne
    @JoinColumn(name = "survey_edition_id")
    private SurveyEdition surveyEdition;

    @OneToMany(mappedBy = "subject" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private Set<Question> questions;


}
