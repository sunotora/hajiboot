package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//2.1.3
//2.1.5では不要となる
@Component
public class Frontend {

	//オートワイヤリング
	//Autowiredアノテーションで
	//DIコンテナがインジェクションすべきフィールドであることを示す
	//その他セッター、コンストラクタにも注入可能（よくわからんけど）
	@Autowired
	ArgumentResolver argumentResolver;

	@Autowired
	Calculator calculator;

	public void run() {
		System.out.println("Enter 2 numbers lie 'a b' :");
		Argument arg = argumentResolver.resolve(System.in);
		int result = calculator.calc(arg.getA(), arg.getB());
		System.out.println("result = " + result);
	}
}
