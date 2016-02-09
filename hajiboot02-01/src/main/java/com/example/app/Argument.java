package com.example.app;

import lombok.Data;

//2.1.2
//このアノテーション付与でコンパイル時に
//setter/getter, toString, equals, hashCodeを自動生成
//今回の例だとfinalなのでsetterは生成されない
//a,bを引数に持つコンストラクタが生成される
@Data
public class Argument {
	private final int a;
	private final int b;
}
