package example.cache.simplecache.controller;

import example.cache.simplecache.service.DataService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BenchmarkController {

    private final DataService noCacheService;
    private final DataService withCacheService;

    public BenchmarkController(@Qualifier("dataServiceNoCache") DataService noCacheService,
                               @Qualifier("dataServiceWithCache") DataService withCacheService) {
        this.noCacheService = noCacheService;
        this.withCacheService = withCacheService;
    }

    @GetMapping("/data/no-cache")
    public String getWithoutCache() {
        long start = System.currentTimeMillis();
        String result = noCacheService.getSlowData();
        long end = System.currentTimeMillis();
        return String.format("Time taken (no cache): %d ms, Data: %s", (end - start), result);
    }

    @GetMapping("/data/with-cache")
    public String getWithCache() {
        long start = System.currentTimeMillis();
        String result = withCacheService.getSlowData();
        long end = System.currentTimeMillis();
        return String.format("Time taken (with cache): %d ms, Data: %s", (end - start), result);
    }
}