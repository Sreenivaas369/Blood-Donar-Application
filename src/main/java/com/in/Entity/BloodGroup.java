package com.in.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Table(name="bloodgroup")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bloodgroupid;
	@Column(unique=true)
	@NotBlank(message="Blood group should be mandatory")
	private String bloodgroup;
	public BloodGroup(String bloodgroup) {
		super();
		this.bloodgroup = bloodgroup;
	}



}
