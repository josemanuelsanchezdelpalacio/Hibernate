package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "departamentos", schema = "miBD", catalog = "")
public class DepartamentosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dept_no", nullable = false)
    private Byte deptNo;
    @Basic
    @Column(name = "dnombre", nullable = true, length = 15)
    private String dnombre;
    @Basic
    @Column(name = "loc", nullable = true, length = 15)
    private String loc;

    public Byte getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Byte deptNo) {
        this.deptNo = deptNo;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartamentosEntity that = (DepartamentosEntity) o;

        if (deptNo != null ? !deptNo.equals(that.deptNo) : that.deptNo != null) return false;
        if (dnombre != null ? !dnombre.equals(that.dnombre) : that.dnombre != null) return false;
        if (loc != null ? !loc.equals(that.loc) : that.loc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
       int result = deptNo != null ? deptNo.hashCode() : 0;
        result = 31 * result + (dnombre != null ? dnombre.hashCode() : 0);
        result = 31 * result + (loc != null ? loc.hashCode() : 0);
        return result;
    }


}
