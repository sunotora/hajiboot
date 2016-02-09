package com.example.app;

import java.io.InputStream;

import org.springframework.stereotype.Component;

//2.1.2
@Component
public interface ArgumentResolver {
	Argument resolve(InputStream stream);
}
