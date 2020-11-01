package tn.enis.member.bean;

import java.util.Date;
import lombok.Data;

@Data
public class PublicationBean {
	private Long id;
	private String titre;
	private String type;
	private Date dateApparition;
	private String lien;
	private String sourcePdf;
}
