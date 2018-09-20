package com.westos.Information;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement//开启事物
@SpringBootApplication
@MapperScan("com.westos.Information.dao")
public class Application {

    public static void main(String[] args) {
        //启动SpringBoot
        SpringApplication.run(Application.class,args);

        /*//自动打开浏览器
        String cmd = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://localhost:8090/index.html";
        Runtime run = Runtime.getRuntime();
        try{
            run.exec(cmd);
        }catch (Exception e){
            e.printStackTrace();
        }*/

    }
}
