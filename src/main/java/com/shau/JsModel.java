package com.shau;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JsModel {
    private String modelName;
    private List<JsModelPart> modelParts = new ArrayList<>();
}
