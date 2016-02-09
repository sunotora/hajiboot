package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;

//@EnableAutoConfiguration	//Spring bootのいろいろ自動設定するやつ
//@Import(AppConfig.class)	//＠Configurationアノテを付与したJavaConfigクラスをImport
//public class App {
//
//	2.1.1プロジェクトの作成
//	public static void main (String args[]) {
//
//		//Spring Bootアプリケーションを起動
//		//第一引数には@EnableAutoConfigurationを付与したクラスを指定
//		//SpringApplication.runメソッドの返り値はDIコンテナであるApplicationContextが入る
//		//ConfigurableApplicationContextはclose可能なやつ
//		try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
//			try (Scanner scanner = new Scanner(System.in)){
//
//				System.out.println("Enter 2 numbers like 'a b' : ");
//				int a = scanner.nextInt();
//				int b = scanner.nextInt();
//
//				//DIコンテナからCalculator型のインスタンスを取得
//				//AddCalculatorクラスの実装は隠蔽されている
//				Calculator calculator = context.getBean(Calculator.class);
//				int result = calculator.calc(a, b);
//				System.out.println("result = " + result);
//			}
//		}


//	2.1.2アプリケーションの抽象化
//	public static void main (String args[]) {
//
//		try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
//			try (Scanner scanner = new Scanner(System.in)){
//
//				System.out.println("Enter 2 numbers like 'a b' : ");
//				ArgumentResolver resolver = context.getBean(ArgumentResolver.class);
//				Argument arg = resolver.resolve(System.in);
//
//				Calculator calculator = context.getBean(Calculator.class);
//				//getterが自動で生成されている便利
//				int result = calculator.calc(arg.getA(), arg.getB());
//				System.out.println("result = " + result);
//			}
//		}

//	2.1.3オートワイヤリングによる注入
//	public static void main (String args[]) {
//		try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
//			Frontend frontend = context.getBean(Frontend.class);
//			frontend.run();
//		}
//	}
//}

//	2.1.4コンポーネントスキャンで自動Bean登録
//@EnableAutoConfiguration
//@ComponentScan	//このクラスと同じパッケージ以下のクラスを走査
////@Import(AppConfig.class)	//不要となる
//public class App {
//	public static void main (String args[]) {
//		try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
//			Frontend frontend = context.getBean(Frontend.class);
//			frontend.run();
//		}
//	}


//	2.1.5CommandLineRunnerの利用
@EnableAutoConfiguration
@ComponentScan
//@Component以外にもコンポーネントスキャンの対象にするアノテーションが存在する
//@Controller:MVCのコントローラーであることを示すアノテーション
//@Service:サービスクラスであることを示すアノテーション
//＠Repository：リポジトリクラスであることを示すアノテーション、発生例外がDataAccessExceptionに変換される
public class App implements CommandLineRunner {

	//CommandLineRunnerインターフェースを持つクラスはDI可能
	@Autowired
	ArgumentResolver argumentResolver;

	@Autowired
	Calculator calculator;

	//Frontendクラスのrunメソッド相当
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Entor 2 numbers like 'a b' : ");
		Argument argument = argumentResolver.resolve(System.in);
		int result = calculator.calc(argument.getA(), argument.getB());
		System.out.println("result = " + result);
	}

	public static void main (String args[]) {
		SpringApplication.run(App.class, args);
	}

}
