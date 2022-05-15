package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AssignmentPK implements Serializable {
    private int department;
    private int regulation;

    @Column(name = "department")
    @Id
    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Column(name = "regulation")
    @Id
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

        AssignmentPK that = (AssignmentPK) o;

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
