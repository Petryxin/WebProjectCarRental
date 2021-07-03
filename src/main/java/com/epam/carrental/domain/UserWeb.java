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
public class UserWeb {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String login;
        private String password;
        private UserRole userRole;

        private String firstName;
        private String lastName;
        private String passportNumber;
}
