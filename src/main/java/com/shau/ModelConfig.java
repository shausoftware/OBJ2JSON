package com.shau;

import com.shau.Material;

import java.util.Map;

/**
 * This interface provides methods to transform a Wavefront OBJ model into a JSON representation more suitable for the Web/WebGL.
 * The output JSON is structured by material ID and the preProcess method provides opportunities to transform or optimise the model.
 */

public interface ModelConfig {

    /**
     * @return Name of model.
     */
    public String getModelName();

    /**
     * @return Scale of model.
     */
    public Float getModelScale();


    /**
     * @return Path to input (Wavefront OBJ) model file.
     */
    public String getInObjFilePath();

    /**
     * @return Path to output (JSON) file for WebGL.
     */
    public String getOutJsonFilePath();


    /**
     * Perform any optimisations and transforms to model prior to output.
     * @param model
     */
    public void preProcess(Model model);

    /**
     * Implement your own material properties here. Suitable for PBR.
     * @param materialName Unique name of material (Output JSON is organsied by material).
     * @return PBR suitable material.
     */
    public Material getMaterialById(String materialName);
}
