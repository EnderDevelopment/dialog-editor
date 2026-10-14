package com.philipiocmd.dialogmod.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class DialogScreen extends Screen {
    protected DialogScreen(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();
        this.addDrawableChild(new ButtonWidget.Builder(Text.literal("Close"), button -> this.close()) 
            .positionAndSize(this.width / 2 - 50, this.height / 2 + 50, 100, 20) 
            .build());
    }

    @Override
    public void render(net.minecraft.client.util.math.MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
    }
}