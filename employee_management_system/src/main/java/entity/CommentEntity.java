package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Comment", schema = "employeemanagementsystem")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "regulation")
    private RegulationEntity regulation;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

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

    public RegulationEntity getRegulation() {
        return regulation;
    }

    public void setRegulation(RegulationEntity regulation) {
        this.regulation = regulation;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", regulation=" + regulation +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity that = (CommentEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
