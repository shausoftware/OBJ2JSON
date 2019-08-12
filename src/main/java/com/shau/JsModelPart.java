package com.shau;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class JsModelPart {
    private String partid;
    private String materialid;
    private Float reflect;
    private Float emission;
    private Float shadow;
    private Float specular;
    private Float fresnel;
    private Float textureid;
    private Float transparency;
    private JsColour baseColour;
    private JsColour metalColour;
    private List<Float> interleaved;
}
