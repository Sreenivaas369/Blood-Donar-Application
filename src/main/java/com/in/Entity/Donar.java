package com.in.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "donar")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Donar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int donarid;
	private String fullname;
	private long mobilenumber;
	private boolean availability;
	private boolean acknowledgement;
	@CreationTimestamp
	private String date;

	@OneToOne
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private User user;
	@ManyToOne
	@JoinColumn(name = "bloodgroupid", referencedColumnName = "bloodgroupid")
	private BloodGroup bloodgroup;
	@ManyToOne
	@JoinColumn(name = "addressid", referencedColumnName = "addressid")
	private Address address;

}
