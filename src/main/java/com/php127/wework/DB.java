/*
 * This file is part of the zyan/wework-msgaudit.
 *
 * (c) 读心印 <aa24615@qq.com>
 *
 * This source file is subject to the MIT license that is bundled
 * with this source code in the file LICENSE.
 */

package com.php127.wework;


import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLNonTransientConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;


public class DB {

    public static DriverManagerDataSource getInstance(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //地址:端口
        // rm-bp1zk6h4k16mcr868to.mysql.rds.aliyuncs.com
        dataSource.setUrl("jdbc:mysql://rm-bp1zk6h4k16mcr868to.mysql.rds.aliyuncs.com/warehouse?useSSL=false&characterEncoding=utf-8&autoReconnect=true");
        //用户名
        dataSource.setUsername("warehouse");
        //密码
        dataSource.setPassword("GATd8*fEfStZ7Dc");
        return dataSource;
    }

    public static JdbcTemplate getJdbcTemplate(){

        JdbcTemplate jdbcTemplate = null;

        jdbcTemplate = new JdbcTemplate(getInstance());

        return jdbcTemplate;
    }
}
