package br.com.cineclube.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull        // não aceita valor null
    private String title;


    @JsonIgnore
    @NotNull
    @Past(message = "nao aceita data futura") // nao aceita data futura
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate release;

    @NotNull
    private Category category;

    @Min(message = "deve ser >=0", value = 0)
    @Max(message ="deve ser <= 10", value = 10)
    @javax.validation.constraints.NotNull
    private BigDecimal score;

    public Filme() { }

    public Filme(String title, LocalDate release, Category cat, BigDecimal score){
        this.title = title;
        this.release = release;
        this.category = cat;
        this.score = score;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", release=" + release +
                ", category=" + category +
                ", score=" + score +
                '}';
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }


    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}