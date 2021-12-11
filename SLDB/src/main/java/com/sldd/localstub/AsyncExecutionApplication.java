package com.sldd.localstub;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncExecutionApplication {

    public void executeSingleWithMultipleThreadsAsync() throws InterruptedException, URISyntaxException, IOException {
        //given
        var concurrentThreads = 20;
        String fooResourceUrl
                = "https://yfo0au8s5m.execute-api.us-east-1.amazonaws.com/Prod/sldb/account";
        URI uri = new URI(fooResourceUrl);
        List<String> arr = new ArrayList<>();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(5))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();
        //when
        ExecutorService executorService = Executors.newFixedThreadPool(concurrentThreads);
        for (int i = 0; i < concurrentThreads; i++) {
            executorService.execute(() -> {
                for(int j = 0; j < 20; j++) {
                    try {
                        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                        arr.add(response.body());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.awaitTermination(40000l, TimeUnit.MILLISECONDS);

        for (var s : arr) {
            System.out.println(s);
        }
    }
}
