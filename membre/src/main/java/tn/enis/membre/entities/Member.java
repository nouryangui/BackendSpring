package tn.enis.membre.entities;

import java.io.File;
import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@DiscriminatorColumn(name = "type_mbr", discriminatorType = DiscriminatorType.STRING)

public abstract class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String cin;
	String firstName;
	String lastName;
	LocalDate birthDate;
	String email;
	String password;
	Byte[] photo;
	File cv;

}
