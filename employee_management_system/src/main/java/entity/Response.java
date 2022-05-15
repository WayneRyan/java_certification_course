package entity;

import javax.persistence.*;

@Entity
public class Response {
    private int id;
    private byte consent;
    private String comment;
    private Regulation regulation;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "consent")
    public byte getConsent() {
        return consent;
    }

    public void setConsent(byte consent) {
        this.consent = consent;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        if (id != response.id) return false;
        if (consent != response.consent) return false;
        if (comment != null ? !comment.equals(response.comment) : response.comment != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) consent;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "regulation", referencedColumnName = "id", nullable = false)
    public Regulation getRegulation() {
        return regulation;
    }

    public void setRegulation(Regulation regulationByRegulation) {
        this.regulation = regulationByRegulation;
    }
}
