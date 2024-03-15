package example.cache.simplecache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("dataServiceWithCache")
public class CachedDataServiceImpl implements DataService {

    @Cacheable("dataCache")
    @Override
    public String getSlowData() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Data from cached source";
    }
}