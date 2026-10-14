package com.philipiocmd.dialogmod.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.client.MinecraftClient;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DialogManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File DIALOG_DIR = new File(MinecraftClient.getInstance().runDirectory, "dialogs");

    public static void saveDialog(String name, JsonObject dialog) {
        if (!DIALOG_DIR.exists()) {
            DIALOG_DIR.mkdirs();
        }
        File dialogFile = new File(DIALOG_DIR, name + ".json");
        try (FileWriter writer = new FileWriter(dialogFile)) {
            GSON.toJson(dialog, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JsonObject loadDialog(String name) {
        File dialogFile = new File(DIALOG_DIR, name + ".json");
        if (dialogFile.exists()) {
            try (FileReader reader = new FileReader(dialogFile)) {
                return JsonParser.parseReader(reader).getAsJsonObject();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}