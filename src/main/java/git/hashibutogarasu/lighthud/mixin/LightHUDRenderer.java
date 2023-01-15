package git.hashibutogarasu.lighthud.mixin;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.LightBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.DebugHud;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.visitor.NbtElementVisitor;
import net.minecraft.text.Text;
import net.minecraft.world.LightType;
import net.minecraft.world.chunk.light.LightingProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;
import java.util.Objects;
import java.util.logging.Logger;

@Mixin(InGameHud.class)
class LightHUDRenderer extends DrawableHelper {

    @Inject(method = "render", at = @At("HEAD"))
    private void injectMethod(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            long lightLevel = client.player.getWorld().getLightLevel(LightType.BLOCK,client.player.getBlockPos());
            var light = LightBlock.addNbtForLevel(Items.LIGHT.getDefaultStack(), (int) lightLevel);
            Color color = Color.WHITE;
            if(lightLevel <= 7 )
                color = Color.RED;
            if(lightLevel >= 8)
                color = Color.GREEN;
            client.textRenderer.draw(matrices, Text.literal("LightLevel"),5,8, Color.WHITE.getRGB());
            client.getItemRenderer().renderInGui(light,60,5);
            client.textRenderer.draw(matrices, Text.literal(String.valueOf(lightLevel)),90,8, color.getRGB());
        }
    }
}
