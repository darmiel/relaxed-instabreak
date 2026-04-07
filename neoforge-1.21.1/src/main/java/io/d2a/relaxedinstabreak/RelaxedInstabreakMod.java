package io.d2a.relaxedinstabreak;

import io.d2a.relaxedinstabreak.config.RelaxedConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(RelaxedInstabreakMod.MOD_ID)
public class RelaxedInstabreakMod {

    public static final String MOD_ID = "relaxedinstabreak";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public RelaxedInstabreakMod(ModContainer container) {
        container.registerConfig(ModConfig.Type.CLIENT, RelaxedConfig.SPEC);
        LOGGER.info("Relaxed Instabreak loaded (NeoForge 1.21.1)");
    }
}
