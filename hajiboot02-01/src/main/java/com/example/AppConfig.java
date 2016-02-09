package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.app.AddCalculator;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import com.example.app.Frontend;
import com.example.app.ScannerArgumentResolver;

//2.1.4コンポーネントスキャンにより、このクラスは不要となる。
@Configuration	//JavaConfig用クラスであることを示す。
public class AppConfig {
	//2.1.1
	@Bean	//DIコンテナに管理させたいBeanを生成するメソッドに付与する
			//デフォルトではメソッド名がBean名になる
			//デフォルトではこのインスタンスはDIコンテナでsingletonとなる。
	Calculator calculator() {
		return new AddCalculator();
		//AddCalculatorクラスがCalculator型のcalculatorという名前でDIコンテナにsingletonとして管理される
	}

	//2.1.2
	@Bean
	ArgumentResolver argumentResolver() {
		return new ScannerArgumentResolver();
	}

	//2.1.3
	@Bean
	Frontend frontend() {
		return new Frontend();
		//Spring Frameworkが使えない場合はここでフィールドに対して、
		//依存関係にあるフィールドを初期化する。
		//example
		//Frontend frontend = new Frontend();
		//frontend.setCalculator(calculator());
		//frontend.setArgumentResolver(argumentResolver());
		//return frontend;
	}

}
