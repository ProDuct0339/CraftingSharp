package kr.o_r.prodzpod.craftingsharp;

import java.util.ArrayList;

import org.apache.logging.log4j.Level;

import kr.o_r.prodzpod.craftingsharp.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {

    private static final String CATEGORY_GENERAL = "general";
    public static boolean testConfig = true;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initConfig(cfg);
        } catch (Exception e1) {
            CraftingSharp.logger.log(Level.ERROR, "[C#] Failed to load Configuration file.", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        // cfg.getBoolean() will get the value in the config if it is already specified there. If not it will create the value.
        testConfig = cfg.getBoolean("testConfig", CATEGORY_GENERAL, testConfig, "this is a test config!!");
    }
}