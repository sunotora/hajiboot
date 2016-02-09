package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor//	Lombok,全フィールドを引数に持つコンストラクタを生成する。
public class Customer {
	private Integer id;
	private String firstName;
	private String lastName;
}
