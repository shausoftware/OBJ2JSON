package com.shau;

import com.shau.Vec3f;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Model {
    private Map<String, ModelPart> parts = new HashMap<String, ModelPart>();
    private List<Vec3f> vertices = new ArrayList<>();
    private List<Vec3f> normals = new ArrayList<>();
}
