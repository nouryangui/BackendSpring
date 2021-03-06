package tn.enis.member.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EventMemberId implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long memberId;
	private Long eventId;
}
