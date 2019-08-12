package com.shau;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Index {

    private List<String> idxs = new ArrayList<>();

    public Index(String sf1, String sf2, String sf3, String smoothing) {
        idxs.add(sf1);
        idxs.add(sf2);
        idxs.add(sf3);
        idxs.add(smoothing);
    }
}