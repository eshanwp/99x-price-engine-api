package io.x99.priceengine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

import java.lang.invoke.MethodHandles;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.TimeZone;

@Slf4j
@EnableRetry
@SpringBootApplication
public class PriceEngineApiApplication {

    public static void main(String[] args) {

        try {
            TimeZone.setDefault(TimeZone.getTimeZone("GMT+0530"));
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.setProperty("hostingServerAddress", inetAddress.getHostAddress());
            System.setProperty("ns", "");

            SpringApplication.run(PriceEngineApiApplication.class, args);

        } catch (UnknownHostException e) {
            log.error("{}|{}|{}", MethodHandles.lookup().lookupClass().getName(), "main", e.getStackTrace());
        }

    }

}
