package labseq.service;

import jakarta.enterprise.context.ApplicationScoped;
import labseq.exception.NegativeException;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class LabSeqService {

    private final Map<Integer, Long> cache = new HashMap<>();

    public long calculateLabSequence(int n) {
        if (n < 0) {
            throw new NegativeException();
        }

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 0;
        if (n == 3) return 1;
        if (cache.containsKey(n)) return cache.get(n);

        long result = calculateLabSequence(n - 4) + calculateLabSequence(n - 3);
        cache.put(n, result);
        return result;
    }
}
