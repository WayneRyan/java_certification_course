package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AssignmentPK.class)
public class Assignment {
    private int department;
    private int regulation;

    @Id
    @Column(name = "department")
    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Id
    @Column(name = "regulation")
    public int getRegulation() {
        return regulation;
    }

    public void setRegulation(int regulation) {
        this.regulation = regulation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        if (department != that.department) return false;
        if (regulation != that.regulation) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = department;
        result = 31 * result + regulation;
        return result;
    }
}
