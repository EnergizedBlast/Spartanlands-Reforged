package com.chaosbuffalo.spartanlands.init;

import com.chaosbuffalo.spartanlands.MatConverter;
import com.chaosbuffalo.spartanlands.Spartanlands;
import com.chaosbuffalo.spartanlands.integration.*;
import com.chaosbuffalo.spartanlands.utils;
import com.oblivioussp.spartanweaponry.api.DamageHelper;
import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.client.gui.CreativeTabsSW;
import com.chaosbuffalo.spartanlands.init.ModelRenderRegistrySLands;
import com.oblivioussp.spartanweaponry.item.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import thebetweenlands.client.tab.CreativeTabBetweenlands;
import thebetweenlands.common.item.BLMaterialRegistry;
import thebetweenlands.common.registries.BlockRegistry;
import thebetweenlands.common.registries.ItemRegistry;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jacob on 7/20/2018.
 * Modified by EnergizedBlast on 11/18/2021.
 */@Mod.EventBusSubscriber
public class ItemRegistrySpartanlands {
    public static final Set<MatConverter> MATERIALS_TO_REGISTER = new HashSet<>();

    public static final String WEEDWOOD = "weedwood";
    public static final String SLIMY_BONE = "slimybone";
    public static final String OCTINE = "octine";
    public static final String VALONITE = "valonite";

    private static final Set<Item> ALL_ITEMS = new HashSet<>();

    static {

        MATERIALS_TO_REGISTER.add(new MatConverter(WEEDWOOD, utils.spartanMatFromToolMat(WEEDWOOD,
                BLMaterialRegistry.TOOL_WEEDWOOD,
                1971718, 8485189)));
        MATERIALS_TO_REGISTER.add(new MatConverter(SLIMY_BONE, utils.spartanMatFromToolMat(SLIMY_BONE,
                BLMaterialRegistry.TOOL_BONE, 9867904, 1472278)));
        MATERIALS_TO_REGISTER.add(new MatConverter(OCTINE, utils.spartanMatFromToolMat(OCTINE,
                BLMaterialRegistry.TOOL_OCTINE, 16278797, 16762911)));
        MATERIALS_TO_REGISTER.add(new MatConverter(VALONITE, utils.spartanMatFromToolMat(VALONITE,
                BLMaterialRegistry.TOOL_VALONITE, 5650518, 16114165)));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> ev) {

        OreDictionary.registerOre("ingotSlimybone", new ItemStack(ItemRegistry.ITEMS_MISC, 1, 14));
        OreDictionary.registerOre("ingotValonite", new ItemStack(ItemRegistry.ITEMS_MISC, 1, 19));
        OreDictionary.registerOre("ingotWeedwood", new ItemStack(BlockRegistry.WEEDWOOD));
        OreDictionary.registerOre("ingotWeedwood", ItemRegistry.WEEDWOOD_SHOVEL);
        Set<Item> item_set = new HashSet<>();
        for (MatConverter mat : MATERIALS_TO_REGISTER){

            ItemKatana katana = new BLSWKatana("katana_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.KATANA, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(katana, "katana_" + mat.name);
            item_set.add(katana);
            ItemGreatsword greatsword = new BLSWGreatsword("greatsword_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.GREATSWORD, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(greatsword, "greatsword_" + mat.name);
            item_set.add(greatsword);
            ItemLongsword longsword = new BLSWLongsword("longsword_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.LONGSWORD, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(longsword, "longsword_" + mat.name);
            item_set.add(longsword);
            ItemSaber saber = new BLSWSaber("saber_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.SABER, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(saber, "saber_" + mat.name);
            item_set.add(saber);
            ItemRapier rapier = new BLSWRapier("rapier_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.RAPIER, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(rapier, "rapier_" + mat.name);
            item_set.add(rapier);
            ItemDagger dagger = new BLSWDagger("dagger_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.DAGGER, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(dagger, "dagger_" + mat.name);
            item_set.add(dagger);
            ItemSpear spear = new BLSWSpear("spear_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.SPEAR, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(spear, "spear_" + mat.name);
            item_set.add(spear);
            ItemPike pike = new BLSWPike("pike_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.PIKE, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(pike, "pike_" + mat.name);
            item_set.add(pike);
            ItemLance lance = new BLSWLance("lance_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.LANCE, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(lance, "lance_" + mat.name);
            item_set.add(lance);
            ItemHalberd halberd = new BLSWHalberd("halberd_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.HALBERD, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(halberd, "halberd_" + mat.name);
            item_set.add(halberd);
            ItemWarhammer warhammer = new BLSWWarhammer("warhammer_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.WARHAMMER, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(warhammer, "warhammer_" + mat.name);
            item_set.add(warhammer);
            ItemHammer hammer = new BLSWHammer("hammer_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.HAMMER, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(hammer, "hammer_" + mat.name);
            item_set.add(hammer);
            ItemThrowingAxe throwing_axe = new BLSWThrowingAxe("throwing_axe_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.THROWING_AXE, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(throwing_axe, "throwing_axe_" + mat.name);
            item_set.add(throwing_axe);
            ItemThrowingKnife throwing_knife = new BLSWThrowingKnife("throwing_knife_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.THROWING_KNIFE, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(throwing_knife, "throwing_knife_" + mat.name);
            item_set.add(throwing_knife);
            ItemJavelin javelin = new BLSWJavelin("javelin_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.JAVELIN, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(javelin, "javelin_" + mat.name);
            item_set.add(javelin);

            ItemGlaive glaive = new BLSWGlaive("glaive_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.GLAIVE, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(glaive, "glaive_" + mat.name);
            item_set.add(glaive);
            ItemBoomerang boomerang = new BLSWBoomerang("boomerang_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.BOOMERANG, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(boomerang, "boomerang_" + mat.name);
            item_set.add(boomerang);
            ItemMace mace = new BLSWMace("mace_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.MACE, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(mace, "mace_" + mat.name);
            item_set.add(mace);
            ItemBattleaxe battleaxe = new BLSWBattleaxe("battleaxe_" + mat.name, Spartanlands.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.BATTLEAXE, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistrySLands.addItemToRegistry(battleaxe, "battleaxe_" + mat.name);
            item_set.add(battleaxe);

            ItemLongbow longbow = new BLSWLongbow("longbow_" + mat.name,  mat.material);
            ModelRenderRegistrySLands.addItemToRegistry(longbow, "longbow_" + mat.name);
            item_set.add(longbow);
            ItemCrossbow crossbow = new BLSWCrossbow("crossbow_" + mat.name, mat.material);
            ModelRenderRegistrySLands.addItemToRegistry(crossbow, "crossbow_" + mat.name);
            item_set.add(crossbow);

            if (mat.name.contains("weedwood"))
            {
                ItemCaestus caestus = new BLSWCaestus("caestus_lurker", Spartanlands.MODID, mat.material);
                ModelRenderRegistrySLands.addItemToRegistry(caestus, "caestus_lurker");
                item_set.add(caestus);
            }
        }

        for (Item it : item_set){
            ev.getRegistry().register(it);
        }
        ALL_ITEMS.forEach(ev.getRegistry()::register);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ALL_ITEMS.stream()
                .filter(item -> item.getRegistryName() != null)
                .forEach(item ->
                        ModelLoader.setCustomModelResourceLocation(item, 0,
                                new ModelResourceLocation(item.getRegistryName(), "inventory")));
    }
}
