package org.training.POJO;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PojoPostReqSimple {

	String FirstName;
	String LastName;
	String Designation;
	String Id;
	String MentorName;
	String CourseName;
}
