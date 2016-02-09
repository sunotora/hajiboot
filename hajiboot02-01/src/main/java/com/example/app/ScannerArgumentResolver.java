package com.example.app;

import java.io.InputStream;
import java.util.Scanner;

//2.1.2
public class ScannerArgumentResolver implements ArgumentResolver {
	@Override
	public Argument resolve(InputStream stream) {
		try (Scanner scanner = new Scanner(stream)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			return new Argument(a, b);
		} catch (Exception e) {
			return new Argument(0, 0);
		}
	}
}
