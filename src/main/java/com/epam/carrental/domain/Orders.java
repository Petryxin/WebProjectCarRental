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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int numberOfDays;
    //private String passportNumberOfUser;
    private boolean approval;
    private int amount;
    private boolean payment;
    private String rejectionReason;
    private OrderStatus orderStatus;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userweb_id")
    private UserWeb userWeb;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id")
    private Car car;
}
