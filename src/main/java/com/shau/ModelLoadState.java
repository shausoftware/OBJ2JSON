package com.shau;

import com.shau.Vec3f;
import lombok.Data;

@Data
public class ModelLoadState {

    private Model model = new Model();
    private String currentId = null;
    private String currentMaterial = null;
    private String currentSmoothing = "off";

    public void loadLine(String line, float scale) {

        String[] split = line.split(" ");

        switch (split[0]) {
            case "o": // new part object
                currentId = split[1];
                if (!model.getParts().containsKey(currentId)) {
                    model.getParts().put(currentId, new ModelPart(currentId));
                }
                break;
            case "v": // vertices
                model.getVertices().add(new com.shau.Vec3f(split[1], split[2], split[3], scale));
                break;
            case "vn": // normals
                model.getNormals().add(new Vec3f(split[1], split[2], split[3], 1.0f));
                break;
            case "usemtl": // material
                currentMaterial = split[1];
                break;
            case "s": //smoothing
                currentSmoothing = split[1];
                break;
            case "f":
                model.getParts().get(currentId).addIndex(currentMaterial, currentSmoothing, split[1], split[2], split[3]);
                break;
        }
    }
}