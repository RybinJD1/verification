package io.manco.task.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question", schema = "task")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "question")
    private List<Answer> listAnswers = new ArrayList<>();


    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answer> getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(List<Answer> listAnswers) {
        this.listAnswers = listAnswers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
