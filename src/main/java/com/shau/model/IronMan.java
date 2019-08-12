package com.shau.model;

import com.shau.*;

import java.util.Map;

public class IronMan implements ModelConfig {

    private String inObjFilePath = "samples/IronMan3.obj";
    private String outJsonFilePath = "output/IronMan.json";

    @Override
    public String getInObjFilePath() {
        return inObjFilePath;
    }

    @Override
    public String getOutJsonFilePath() {
        return outJsonFilePath;
    }

    @Override
    public void preProcess(Model model) {
        model.getParts().remove("Cube");
    }

    @Override
    public Material getMaterialById(String materialName) {

        Material material = null;

        if ("red".equals(materialName)) {
            //red body
            material = new Material();
            material.setMaterialName(materialName);
            material.setBaseColour(new Vec3f("0.3", "0.0", "0.01", 1.0f));
            material.setEmission(0.0f);
            material.setReflect(0.0f);
            material.setFresnel(0.4f);
            material.setMetalColour(new Vec3f("0.0", "0.0", "0.0", 1.0f));
            material.setShadow(0.7f);
            material.setSpecular(0.8f);
            material.setTextureId(0.0f);
            material.setTransparency(0.0f);
        } else if ("Iron_man_leg:red".equals(materialName)) {
            //red leg
            material = new Material();
            material.setMaterialName(materialName);
            material.setBaseColour(new Vec3f("0.3", "0.0", "0.01", 1.0f));
            material.setEmission(0.0f);
            material.setReflect(0.6f);
            material.setFresnel(0.4f);
            material.setMetalColour(new Vec3f("0.0", "0.0", "0.0", 1.0f));
            material.setShadow(0.7f);
            material.setSpecular(0.8f);
            material.setTextureId(0.0f);
            material.setTransparency(0.0f);
        } else if ("gold".equals(materialName)) {
            //gold body
            material = new Material();
            material.setMaterialName(materialName);
            material.setBaseColour(new Vec3f("1.0", "1.0", "0.6", 1.0f));
            material.setEmission(0.0f);
            material.setReflect(0.6f);
            material.setFresnel(0.4f);
            material.setMetalColour(new Vec3f("0.0", "0.0", "0.0", 1.0f));
            material.setShadow(0.7f);
            material.setSpecular(0.8f);
            material.setTextureId(0.0f);
            material.setTransparency(0.0f);
        } else if ("yellow".equals(materialName)) {
            //eyes
            material = new Material();
            material.setMaterialName(materialName);
            material.setBaseColour(new Vec3f("0.5", "1.0", "1.0", 1.0f));
            material.setEmission(1.0f);
            material.setReflect(0.0f);
            material.setFresnel(0.0f);
            material.setMetalColour(new Vec3f("0.0", "0.0", "0.0", 1.0f));
            material.setShadow(0.0f);
            material.setSpecular(0.0f);
            material.setTextureId(0.0f);
            material.setTransparency(0.0f);
        } else if ("silver".equals(materialName)) {
            material = new Material();
            material.setMaterialName(materialName);
            material.setBaseColour(new Vec3f("0.1", "0.1", "0.1", 1.0f));
            material.setEmission(0.0f);
            material.setReflect(0.0f);
            material.setFresnel(0.0f);
            material.setMetalColour(new Vec3f("0.0", "0.0", "0.0", 1.0f));
            material.setShadow(0.7f);
            material.setSpecular(0.0f);
            material.setTextureId(0.0f);
            material.setTransparency(0.0f);
        } else if ("darksilver".equals(materialName)) {
            //glow stuff
            material = new Material();
            material.setMaterialName(materialName);
            material.setBaseColour(new Vec3f("0.5", "0.5", "0.8", 1.0f));
            material.setEmission(1.0f);
            material.setReflect(0.0f);
            material.setFresnel(0.0f);
            material.setMetalColour(new Vec3f("0.0", "0.0", "0.0", 1.0f));
            material.setShadow(0.0f);
            material.setSpecular(0.0f);
            material.setTextureId(0.0f);
            material.setTransparency(0.0f);
        } else if ("black".equals(materialName)) {
            material = new Material();
            material.setMaterialName(materialName);
            material.setBaseColour(new Vec3f("0.0", "0.0", "0.0", 1.0f));
            material.setEmission(0.0f);
            material.setReflect(0.0f);
            material.setFresnel(0.0f);
            material.setMetalColour(new Vec3f("0.0", "0.0", "0.0", 1.0f));
            material.setShadow(0.7f);
            material.setSpecular(0.0f);
            material.setTextureId(0.0f);
            material.setTransparency(0.0f);
        } else if ("lambert1".equals(materialName)) {
            material = new Material();
            material.setMaterialName(materialName);
            material.setBaseColour(new Vec3f("0.0", "0.0", "0.0", 1.0f));
            material.setEmission(0.0f);
            material.setReflect(0.0f);
            material.setFresnel(0.0f);
            material.setMetalColour(new Vec3f("0.0", "0.0", "0.0", 1.0f));
            material.setShadow(0.7f);
            material.setSpecular(0.0f);
            material.setTextureId(0.0f);
            material.setTransparency(0.0f);
        } else {
            material = new Material();
            material.setMaterialName(materialName);
            material.setBaseColour(new Vec3f("0.0", "1.0", "0.0", 1.0f));
            material.setEmission(0.0f);
            material.setReflect(0.0f);
            material.setFresnel(0.0f);
            material.setMetalColour(new Vec3f("0.0", "0.0", "0.0", 1.0f));
            material.setShadow(0.0f);
            material.setSpecular(0.0f);
            material.setTextureId(0.0f);
            material.setTransparency(0.0f);
        }

        return material;
    }

    @Override
    public Float getModelScale() {
        return 0.04f;
    }

    @Override
    public String getModelName() {
        return "IronMan";
    }
}