package com.westos.Information.test;

import java.sql.*;

public class jdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //驱动加载
        Class.forName("com.mysql.cj.jdbc.Driver");
//        获取链接
        String url="jdbc:mysql://localhost:3306/information_student?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8";
        Connection connection = DriverManager.getConnection(url,"root","123456");
//        定义sql语句
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student where stuid=?");
//        绑定内容
        preparedStatement.setString(1,"151001");

//        获取返回的结果集
        ResultSet resultSet = preparedStatement.executeQuery();
//        遍历
        while(resultSet.next()){
            System.out.println(resultSet.getString("stuid"));
            System.out.println(resultSet.getString("name"));
        }
//        释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
