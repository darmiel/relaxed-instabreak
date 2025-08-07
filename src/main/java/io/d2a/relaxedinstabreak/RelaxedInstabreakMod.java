package io.d2a.relaxedinstabreak;

import io.d2a.relaxedinstabreak.config.ClothConfig;
import io.d2a.relaxedinstabreak.config.DefaultConfig;
import io.d2a.relaxedinstabreak.config.RelaxedConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RelaxedInstabreakMod implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("relaxed-instabreak");

    private static final RelaxedConfig config;

    static {
        if (FabricLoader.getInstance().isModLoaded("cloth-config")) {
            config = AutoConfig.register(ClothConfig.class, GsonConfigSerializer::new).getConfig();
        } else {
            config = new DefaultConfig();
        }
    }

    public static RelaxedConfig getConfig() {
        return config;
    }

    /**
     * Checks if the relaxed instabreak behavior is enabled based on the player's sneaking state and the mod configuration.
     *
     * @return true if the behavior is enabled, false otherwise.
     */
    public static boolean isRelaxingBehaviorEnabled() {
        final RelaxedConfig config = RelaxedInstabreakMod.getConfig();
        if (config.alwaysEnabled()) {
            return true;
        }
        final ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) {
            return false;
        }
        return player.isSneaking() != config.isReversed();
    }

    @Override
    public void onInitializeClient() {

    }

}