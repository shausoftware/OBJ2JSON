package com.shau;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.shau.Material;
import com.shau.model.IronMan;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ObjProcessor {

    public static void main(String[] args) {

        System.out.println("STARTING TRANFORM");

        ObjectMapper mapper = new ObjectMapper();

        ModelLoadState modelLoadState = new ModelLoadState();
        ModelConfig config = new IronMan();

        //load model from obj file
        Path input = Paths.get(config.getInObjFilePath()).toAbsolutePath();
        try (Stream<String> lineStream = Files.lines(input)) {
            lineStream.forEach(line -> {
                modelLoadState.loadLine(line, config.getModelScale());
            });
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("LOADED INPUT MODEL");

        //transorm
        Model model = modelLoadState.getModel();
        config.preProcess(model);
        JsModel jsModel = mapJsModel(config, model);

        System.out.println("TRANSORMED MODEL");

        //write out as JSON
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(Paths.get(config.getOutJsonFilePath()).toFile(), jsModel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("FINISHED");
    }

    //build object model for JS mapping
    protected static JsModel mapJsModel(ModelConfig config, Model model) {

        JsModel jsModel = new JsModel();
        jsModel.setModelName(config.getModelName());

        model.getParts().entrySet().stream().forEach(modelPart -> {

            modelPart.getValue().getIndexMap().entrySet().stream().forEach(material -> {

                Material materialCongig = config.getMaterialById(material.getKey());

                List<Float> interleaved = new ArrayList<>(); //interleaved vertices and normals
                material.getValue().stream().forEach(idx -> {
                    //each triangular face has 3*3 vertices each with a corresponding normal
                    String[] s1 = idx.getIdxs().get(0).split("/");
                    String[] s2 = idx.getIdxs().get(1).split("/");
                    String[] s3 = idx.getIdxs().get(2).split("/");

                    interleaved.addAll(model.getVertices().get(Integer.parseInt(s1[0]) - 1).getFloats());
                    interleaved.addAll(model.getNormals().get(Integer.parseInt(s1[2]) - 1).getFloats());
                    interleaved.addAll(model.getVertices().get(Integer.parseInt(s2[0]) - 1).getFloats());
                    interleaved.addAll(model.getNormals().get(Integer.parseInt(s2[2]) - 1).getFloats());
                    interleaved.addAll(model.getVertices().get(Integer.parseInt(s3[0]) - 1).getFloats());
                    interleaved.addAll(model.getNormals().get(Integer.parseInt(s3[2]) - 1).getFloats());
                });

                JsModelPart jsModelPart = JsModelPart.builder()
                        .interleaved(interleaved)
                        .partid(modelPart.getValue().getPartId())
                        .materialid(material.getKey())
                        .reflect(materialCongig.getFresnel())
                        .textureid(materialCongig.getTextureId())
                        .transparency(materialCongig.getTransparency())
                        .baseColour(new JsColour(materialCongig.getBaseColour().getFloats()))
                        .metalColour(new JsColour(materialCongig.getMetalColour().getFloats())).build();

                jsModel.getModelParts().add(jsModelPart);
            });
        });

        return jsModel;
    }
}
