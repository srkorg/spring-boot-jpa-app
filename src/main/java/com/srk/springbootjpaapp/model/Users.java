package com.srk.springbootjpaapp.model;

import com.fasterxml.uuid.Generators;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Users {
    @Id
    @Column(name = "users_id", columnDefinition = "BINARY(36)")
    @Type(type="uuid-char")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id = Generators.timeBasedGenerator().generate();
	private String name;
	private String teamName;
	private Long salary;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
	private List<UsersLog> usersLogs;

	public UUID getId() {
		return id;
	}

	public Users setId(UUID id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Users setName(String name) {
		this.name = name;
		return this;
	}

	public String getTeamName() {
		return teamName;
	}

	public Users setTeamName(String teamName) {
		this.teamName = teamName;
		return this;
	}

	public Long getSalary() {
		return salary;
	}

	public Users setSalary(Long salary) {
		this.salary = salary;
		return this;
	}

    public List<UsersLog> getUsersLogs() {
        return usersLogs;
    }

    public void setUsersLogs(List<UsersLog> usersLogs) {
        this.usersLogs = usersLogs;
    }
}