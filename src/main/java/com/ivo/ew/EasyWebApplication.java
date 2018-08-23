package com.ivo.ew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangjian
 * @date 2018/7/10
 */
@SpringBootApplication
public class EasyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyWebApplication.class, args);

        System.out.println(
                "          ┌─┐       ┌─┐\n" +
                        "       ┌──┘ ┴───────┘ ┴──┐\n" +
                        "       │                 │\n" +
                        "       │       ───       │\n" +
                        "       │  ─┬┘       └┬─  │\n" +
                        "       │                 │\n" +
                        "       │       ─┴─       │\n" +
                        "       │                 │\n" +
                        "       └───┐         ┌───┘\n" +
                        "           │         │\n" +
                        "           │         │   神兽保佑\n" +
                        "           │         │   代码无BUG!\n" +
                        "           │         └──────────────┐\n" +
                        "           │                        │\n" +
                        "           │                        ├─┐\n" +
                        "           │                        ┌─┘\n" +
                        "           │                        │\n" +
                        "           └─┐  ┐  ┌───────┬──┐  ┌──┘\n" +
                        "             │ ─┤ ─┤       │ ─┤ ─┤\n" +
                        "             └──┴──┘       └──┴──┘\n" +
                        "—————————————————————神兽出没————————————————-——"
        );
    }
}
