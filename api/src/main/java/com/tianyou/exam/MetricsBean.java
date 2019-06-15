package com.tianyou.exam;

import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.hotspot.DefaultExports;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
public class MetricsBean {


    @PostConstruct
    public void init() throws IOException {
        DefaultExports.initialize();
        HTTPServer server = new HTTPServer(9090);
    }

}
