package com.shau;

import com.shau.Vec3f;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * PBR suitable material
 */

@Data
public class Material {
    private String materialName;
    private com.shau.Vec3f baseColour;
    private Vec3f metalColour;
    private Float specular;
    private Float fresnel;
    private Float transparency;
    private Float shadow;
    private Float emission;
    private Float reflect;
    private Float textureId;
}
