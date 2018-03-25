package com.srk.springbootjpaapp.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users_log")
public class UsersLog {
    @Id
	@Column(name = "log_id", columnDefinition = "BINARY(36)")
	@Type(type = "uuid-char")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    private String log;
    @Column(name = "users_id", columnDefinition = "BINARY(36)")
    private UUID usersId;

	public UsersLog() {	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

    public UUID getUsersId() {
        return usersId;
    }

    public void setUsersId(UUID usersId) {
        this.usersId = usersId;
    }
}