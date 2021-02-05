package ua.mainacademy.model;

import lombok.*;

import javax.persistence.*;


@ToString
@Setter
@Getter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
