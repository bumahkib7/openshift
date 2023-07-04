package org.openex.openshift.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String policyNumber;
    private String policyDetails;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Policy policy = (Policy) o;
        return getId() != null && Objects.equals(getId(), policy.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}
