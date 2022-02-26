package xxrexraptorxx.additionalstructures.utils;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_STRUCTURES = "structures";

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.BooleanValue UPDATE_CHECKER;
    public static ForgeConfigSpec.BooleanValue DEBUG_MODE;

    public static ForgeConfigSpec.BooleanValue OVERWORLD_GENERATOR;
    public static ForgeConfigSpec.BooleanValue NETHER_GENERATOR;
    public static ForgeConfigSpec.BooleanValue END_GENERATOR;

    public static ForgeConfigSpec.DoubleValue GENERATION_MODIFIER;


    public static void init() {
        initCommon();
        initClient();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }


    public static void initClient() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        UPDATE_CHECKER = builder.comment("Activate the Update-Checker").define("update-checker", true);
        DEBUG_MODE = builder.comment("Activate the Debug Mode").define("debug_mode", false);
        builder.pop();

        CLIENT_CONFIG = builder.build();
    }


    public static void initCommon() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("Structures").push(CATEGORY_STRUCTURES);
        builder.pop();

        COMMON_CONFIG = builder.build();
    }
}
