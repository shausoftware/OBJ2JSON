package com.shau;

import com.shau.Index;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ModelPart {

    private Map<String, List<com.shau.Index>> indexMap = new HashMap<>();
    private String partId;

    public ModelPart(String partId) {
        this.partId = partId;
    }

    public void addIndex(String material, String smoothing, String ix, String iy, String iz) {
        if (!indexMap.containsKey(material)) {
            List<com.shau.Index> indexList = new ArrayList<>();
            indexMap.put(material, indexList);
        }
        indexMap.get(material).add(new Index(ix, iy, iz, smoothing));
    }
}