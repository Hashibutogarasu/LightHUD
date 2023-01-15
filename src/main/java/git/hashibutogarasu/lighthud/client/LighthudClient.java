package git.hashibutogarasu.lighthud.client;

import git.hashibutogarasu.lighthud.Textures;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;

import java.util.logging.Logger;

@Environment(EnvType.CLIENT)
public class LighthudClient implements ClientModInitializer {
    public static Logger LOGGER = Logger.getLogger("lighthud");
    @Override
    public void onInitializeClient() {

    }
}
