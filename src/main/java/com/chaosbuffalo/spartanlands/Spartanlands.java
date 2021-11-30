package com.chaosbuffalo.spartanlands;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Spartanlands.MODID, name = Spartanlands.NAME, version = Spartanlands.VERSION,
        dependencies="required-after:thebetweenlands;required-after:spartanweaponry@[beta 1.3.8]")
public class Spartanlands
{
    public static final String MODID = "spartanlands";
    public static final String NAME = "Spartanlands";
    public static final String VERSION = "1.00";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
