package org.training.POJO;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PostRequestComplex {

	String H_No;
	String Street;
	String Zipcode;
}
