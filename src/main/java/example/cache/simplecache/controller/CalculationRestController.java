package example.cache.simplecache.controller;

import example.cache.simplecache.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/calculate")
public class CalculationRestController {
    private final CalculationService calculationService;

    @Autowired
    public CalculationRestController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping(path = "/areaOfCircle", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> areaOfCircle(@RequestParam int radius) {
        double result = calculationService.areaOfCircle(radius);
        return ResponseEntity.ok(result);
    }
    @GetMapping(path = "/multiply", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> multiplyTwoIntegers(@RequestParam int f1, @RequestParam int f2) {
        int mult = calculationService.multiply(f1, f2);
        return ResponseEntity.ok(mult);
    }
}
