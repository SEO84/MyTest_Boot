package com.busanit501.foodboot.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Food extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fno;

    @Column(length = 500, nullable = false)
    private String fname;
    @Column(length = 2000, nullable = false)
    private String fdesc;
    @Column(length = 50, nullable = false)
    private String chef;

    public void changeNameDesc(String fname, String fdesc) {
        this.fname = fname;
        this.fdesc = fdesc;
    }

}
