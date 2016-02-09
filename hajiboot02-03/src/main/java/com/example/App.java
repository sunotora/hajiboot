package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	//Spring BootではautoConfigureという仕組みで自動で注入される、超便利
	//今回はh2データベースを選択、データベースの指定がない場合はデフォルトのインメモリ組み込みデータベースが作られる。

	@Override
	public void run(String... args) throws Exception {
		System.out.println("************************");
		run_2_2_1();
		System.out.println("************************");
		run_2_2_2();
		System.out.println("************************");
	}

	private void run_2_2_1() {
		String sql = "SELECT 1";
		//Sqlに埋め込むパラメータを作成。Map<String, Object>みたいなものらしい、こっちのが便利に使用可能
		SqlParameterSource param = new MapSqlParameterSource();
		//クエリの実行結果をオブジェクトに変換して取得（クエリの結果が１件のみの場合のみ有効
		//１件でない場合IncorrectResultSizeDataAccessExceptionが発生する。
		Integer result = jdbcTemplate.queryForObject(sql, param, Integer.class);
		System.out.println("result : " + result);
	}

	private void run_2_2_2() {
		//a, bというプレースホルダを埋め込み
		String sql = "SELECT :a + :b";
		//a, bという値を設定（この書き方関数的だけどあまり好きになれない）
		SqlParameterSource param = new MapSqlParameterSource()
									.addValue("a", 100)
									.addValue("b", 200);
//		MapSqlParameterSource param2 = new MapSqlParameterSource();
//		param2.addValue("a", 100);
//		param2.addValue("b", 200);


		Integer result = jdbcTemplate.queryForObject(sql, param, Integer.class);
		System.out.println("result : " + result);
	}


	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
