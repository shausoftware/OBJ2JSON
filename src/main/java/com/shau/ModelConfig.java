package com.shau;

import com.shau.Material;

import java.util.Map;

public interface ModelConfig {

    public String getModelName();

    public Float getModelScale();

    public String getInObjFilePath();

    public String getOutJsonFilePath();

    public void preProcess(Model model);

    public Material getMaterialById(String materialName);
}
