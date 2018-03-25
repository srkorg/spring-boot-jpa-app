package com.srk.springbootjpaapp.model;

import com.fasterxml.uuid.Generators;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users_contact")
public class UsersContact {
    @Id
    @Column(name = "id", columnDefinition = "BINARY(36)")
    @Type(type="uuid-char")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id = Generators.timeBasedGenerator().generate();
    @Column(name = "phone_no")
    private Integer phoneNo;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private Users users;

    public UsersContact() {}

    public Users getUsers() {
        return users;
    }

    public UsersContact setUsers(Users users) {
        this.users = users;
        return this;
    }

    public UUID getId() {
		return id;
	}

	public UsersContact setId(UUID id) {
		this.id = id;
		return this;
	}

	public Integer getPhoneNo() {
		return phoneNo;
	}

	public UsersContact setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
        return this;
	}

    public String getEmail() {
        return email;
    }

    public UsersContact setEmail(String email) {
        this.email = email;
        return this;
    }
}
