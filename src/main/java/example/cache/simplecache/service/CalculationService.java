package example.cache.simplecache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    private final Logger LOG = LoggerFactory.getLogger(CalculationService.class);
    @Cacheable(value = "areaOfCircleCache", key = "#radius", condition = "#radius > 5")
    public double areaOfCircle(int radius) {
        LOG.info("calculate the area of a circle with a radius of {}", radius);
        return Math.PI * Math.pow(radius, 2);
    }

    @Cacheable(value = "multiplyCache", keyGenerator = "multiplyKeyGenerator")
    public int multiply(int factor1, int factor2) {
        LOG.info("Multiply {} with {}", factor1, factor2);
        return factor1 * factor2;
    }
}
