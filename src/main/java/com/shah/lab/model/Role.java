package com.shah.lab.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role
{
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
        @SequenceGenerator(initialValue = 1, sequenceName = "role_seq", allocationSize = 1, name = "ROLE_SEQ")
        private Long id;

        private String name;

        @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
        private Set<User> users;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<User> getUsers() {
            return users;
        }

        public void setUsers(Set<User> users) {
            this.users = users;
        }

}
