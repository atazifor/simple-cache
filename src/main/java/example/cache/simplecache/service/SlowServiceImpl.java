package example.cache.simplecache.service;

import org.springframework.stereotype.Service;

@Service("dataServiceNoCache")
public class SlowServiceImpl implements DataService {

    @Override
    public String getSlowData() {
        // Simulate delay
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Data from slow source";
    }
}
