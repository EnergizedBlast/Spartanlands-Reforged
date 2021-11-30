package com.chaosbuffalo.spartanlands.init;

import com.chaosbuffalo.spartanlands.Spartanlands;
import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.util.LogHelper;
import com.oblivioussp.spartanweaponry.util.StringHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ModelRenderRegistrySLands {


    public static void addItemToRegistry(Item item, String modelLoc) {
        SpartanWeaponryAPI.addItemModelToRegistry(
                item, Spartanlands.MODID,
                modelLoc);
    }

}