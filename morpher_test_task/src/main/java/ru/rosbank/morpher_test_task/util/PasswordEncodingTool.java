package ru.rosbank.morpher_test_task.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodingTool {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("password"));

    }
}
