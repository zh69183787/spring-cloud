package com.zh69183787.api.consumer;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

    @RestController
    public class UploadController {

        @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) throws IOException {
            List<String> lines = new ArrayList<String>();
            String s;
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            while ((s = reader.readLine()) != null) {
                lines.add(s);
            }
            reader.close();
            return file.getName();
        }

    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
