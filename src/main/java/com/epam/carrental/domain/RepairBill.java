package com.epam.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RepairBill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String damage;
    private int amountRepair;

    @OneToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Orders order;
}
