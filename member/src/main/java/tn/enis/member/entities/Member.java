package tn.enis.member.entities;

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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@DiscriminatorColumn(name = "type_mbr", discriminatorType = DiscriminatorType.STRING)

public abstract class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@NonNull
	String cin;
	@NonNull
	String firstName;
	@NonNull
	String lastName;
	@NonNull
	LocalDate birthDate;
	@NonNull
	String email;
	@NonNull
	String password;
	Byte[] photo;
	File cv;

}
