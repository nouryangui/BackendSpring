package tn.enis.membre.entities;

import java.time.LocalDate;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@DiscriminatorValue("student")

public class Student extends Member {
	LocalDate dateInscription;
	String diplome;
	@ManyToOne
	Teacher teacher;

}
