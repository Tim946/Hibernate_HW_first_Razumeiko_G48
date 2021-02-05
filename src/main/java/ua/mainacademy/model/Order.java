package ua.mainacademy.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Entity
public class Order extends BaseEntity {

    @ManyToOne(targetEntity = User.class)
    private User user;

    @Column(name = "creation_time", nullable = false)
    private Long creationTime;

    @Column(nullable = false)
    private Status status;

    public enum Status {
        OPEN,
        CLOSED
    }
}
