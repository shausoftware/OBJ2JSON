package com.shau;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Vec3f {

    private List<Float> floats = new ArrayList<>();

    public Vec3f(String sf1, String sf2, String sf3, float scale) {
        floats.add(Float.parseFloat(sf1) * scale);
        floats.add(Float.parseFloat(sf2) * scale);
        floats.add(Float.parseFloat(sf3) * scale);
    }
}