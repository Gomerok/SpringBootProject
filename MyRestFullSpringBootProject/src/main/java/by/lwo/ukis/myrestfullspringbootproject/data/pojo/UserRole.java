package by.lwo.ukis.myrestfullspringbootproject.data.pojo;


import by.lwo.ukis.myrestfullspringbootproject.data.pojo.enums.UserRoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "user_role")
@Data
@NoArgsConstructor
public class UserRole implements Serializable {
    @Id
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @GeneratedValue(generator = "uuid-generator")
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleType role;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    public UserRole(User user,UserRoleType roleType,LocalDateTime creationTime){
        this.user=user;
        this.role=roleType;
        this.creationTime=creationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole role = (UserRole) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("id=").append(id);
        sb.append(", role='").append(role).append('\'');
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}