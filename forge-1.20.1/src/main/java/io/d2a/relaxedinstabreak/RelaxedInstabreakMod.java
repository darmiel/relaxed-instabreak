package io.d2a.relaxedinstabreak;

import io.d2a.relaxedinstabreak.config.RelaxedConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(RelaxedInstabreakMod.MOD_ID)
public class RelaxedInstabreakMod {

    public static final String MOD_ID = "relaxedinstabreak";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public RelaxedInstabreakMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, RelaxedConfig.SPEC);
        LOGGER.info("Relaxed Instabreak loaded (Forge 1.20.1)");
    }
}
