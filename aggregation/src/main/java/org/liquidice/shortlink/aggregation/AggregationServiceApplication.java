
package org.liquidice.shortlink.aggregation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 短链接聚合应用
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
        "org.liquidice.shortlink.admin",
        "org.liquidice.shortlink.project",
        "org.liquidice.shortlink.aggregation"
})
@MapperScan(value = {
        "org.liquidice.shortlink.project.dao.mapper",
        "org.liquidice.shortlink.admin.dao.mapper"
})
public class AggregationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AggregationServiceApplication.class, args);
    }
}