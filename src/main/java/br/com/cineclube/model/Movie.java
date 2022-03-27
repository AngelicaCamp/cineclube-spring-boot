package br.com.cineclube.model;


import java.math.BigDecimal;

public class Movie {

    private Long id;
    private String title;
    private String overview;
    private String release_date;
    private BigDecimal vote_average;
    private BigDecimal vote_count;


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

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public BigDecimal getVote_average() {
        return vote_average;
    }

    public void setVote_average(BigDecimal vote_average) {
        this.vote_average = vote_average;
    }

    public BigDecimal getVote_count() {
        return vote_count;
    }

    public void setVote_count(BigDecimal vote_count) {
        this.vote_count = vote_count;
    }
}
