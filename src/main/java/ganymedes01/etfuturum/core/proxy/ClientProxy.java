package ganymedes01.etfuturum.core.proxy;

import java.io.File;

import com.mojang.authlib.minecraft.MinecraftSessionService;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.ReflectionHelper;
import ganymedes01.etfuturum.ModBlocks;
import ganymedes01.etfuturum.client.renderer.block.BlockBarrelRenderer;
import ganymedes01.etfuturum.client.renderer.block.BlockChestRenderer;
import ganymedes01.etfuturum.client.renderer.block.BlockChorusFlowerRender;
import ganymedes01.etfuturum.client.renderer.block.BlockChorusPlantRender;
import ganymedes01.etfuturum.client.renderer.block.BlockDoorRenderer;
import ganymedes01.etfuturum.client.renderer.block.BlockEndRodRender;
import ganymedes01.etfuturum.client.renderer.block.BlockGlazedTerracottaRenderer;
import ganymedes01.etfuturum.client.renderer.block.BlockLanternRenderer;
import ganymedes01.etfuturum.client.renderer.block.BlockLavaCauldronRenderer;
import ganymedes01.etfuturum.client.renderer.block.BlockSlimeBlockRender;
import ganymedes01.etfuturum.client.renderer.block.BlockTrapDoorRenderer;
import ganymedes01.etfuturum.client.renderer.entity.ArmourStandRenderer;
import ganymedes01.etfuturum.client.renderer.entity.BrownMooshroomRenderer;
import ganymedes01.etfuturum.client.renderer.entity.EndermiteRenderer;
import ganymedes01.etfuturum.client.renderer.entity.HuskRenderer;
import ganymedes01.etfuturum.client.renderer.entity.LingeringEffectRenderer;
import ganymedes01.etfuturum.client.renderer.entity.LingeringPotionRenderer;
import ganymedes01.etfuturum.client.renderer.entity.NewSnowGolemRenderer;
import ganymedes01.etfuturum.client.renderer.entity.PlacedEndCrystalRenderer;
import ganymedes01.etfuturum.client.renderer.entity.RabbitRenderer;
import ganymedes01.etfuturum.client.renderer.entity.StrayOverlayRenderer;
import ganymedes01.etfuturum.client.renderer.entity.StrayRenderer;
import ganymedes01.etfuturum.client.renderer.entity.VillagerZombieRenderer;
import ganymedes01.etfuturum.client.renderer.item.ItemBannerRenderer;
import ganymedes01.etfuturum.client.renderer.item.ItemBowRenderer;
import ganymedes01.etfuturum.client.renderer.item.ItemSkullRenderer;
import ganymedes01.etfuturum.client.renderer.tileentity.TileEntityBannerRenderer;
import ganymedes01.etfuturum.client.renderer.tileentity.TileEntityEndRodRenderer;
import ganymedes01.etfuturum.client.renderer.tileentity.TileEntityFancySkullRenderer;
import ganymedes01.etfuturum.client.renderer.tileentity.TileEntityNewBeaconRenderer;
import ganymedes01.etfuturum.client.renderer.tileentity.TileEntityWoodSignRenderer;
import ganymedes01.etfuturum.client.skins.NewRenderPlayer;
import ganymedes01.etfuturum.client.skins.NewSkinManager;
import ganymedes01.etfuturum.configuration.ConfigurationHandler;
import ganymedes01.etfuturum.core.handlers.ClientEventHandler;
import ganymedes01.etfuturum.entities.EntityArmourStand;
import ganymedes01.etfuturum.entities.EntityBrownMooshroom;
import ganymedes01.etfuturum.entities.EntityEndermite;
import ganymedes01.etfuturum.entities.EntityHusk;
import ganymedes01.etfuturum.entities.EntityLingeringEffect;
import ganymedes01.etfuturum.entities.EntityLingeringPotion;
import ganymedes01.etfuturum.entities.EntityNewSnowGolem;
import ganymedes01.etfuturum.entities.EntityPlacedEndCrystal;
import ganymedes01.etfuturum.entities.EntityRabbit;
import ganymedes01.etfuturum.entities.EntityStray;
import ganymedes01.etfuturum.entities.EntityZombieVillager;
import ganymedes01.etfuturum.tileentities.TileEntityBanner;
import ganymedes01.etfuturum.tileentities.TileEntityEndRod;
import ganymedes01.etfuturum.tileentities.TileEntityNewBeacon;
import ganymedes01.etfuturum.tileentities.TileEntityWoodSign;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerEvents() {
        super.registerEvents();
        FMLCommonHandler.instance().bus().register(ClientEventHandler.INSTANCE);
        MinecraftForge.EVENT_BUS.register(ClientEventHandler.INSTANCE);
//        MinecraftForge.EVENT_BUS.register(BiomeFogEventHandler.INSTANCE);
    }

    @Override
    public void registerRenderers() {
        registerItemRenderers();
        registerBlockRenderers();
        registerEntityRenderers();
    }

    private void registerItemRenderers() {
        if (ConfigurationHandler.enableBanners)
            MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.banner), new ItemBannerRenderer());
        if (ConfigurationHandler.enableFancySkulls)
            MinecraftForgeClient.registerItemRenderer(Items.skull, new ItemSkullRenderer());
        if (ConfigurationHandler.enableBowRendering)
            MinecraftForgeClient.registerItemRenderer(Items.bow, new ItemBowRenderer());
    }

    private void registerBlockRenderers() {
        if (ConfigurationHandler.enableSlimeBlock)
            RenderingRegistry.registerBlockHandler(new BlockSlimeBlockRender());

        if (ConfigurationHandler.enableDoors)
            RenderingRegistry.registerBlockHandler(new BlockDoorRenderer());

        if (ConfigurationHandler.enableBanners)
            ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBanner.class, new TileEntityBannerRenderer());

        if (ConfigurationHandler.enableFancySkulls)
            ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySkull.class, new TileEntityFancySkullRenderer());

        if (ConfigurationHandler.enableChorusFruit) {
            RenderingRegistry.registerBlockHandler(new BlockEndRodRender());
            RenderingRegistry.registerBlockHandler(new BlockChorusFlowerRender());
            RenderingRegistry.registerBlockHandler(new BlockChorusPlantRender());
            ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEndRod.class, new TileEntityEndRodRenderer());
        }

        if (ConfigurationHandler.enableColourfulBeacons)
            ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNewBeacon.class, new TileEntityNewBeaconRenderer());

		if (ConfigurationHandler.enableLantern)
			RenderingRegistry.registerBlockHandler(new BlockLanternRenderer());
		
		if (ConfigurationHandler.enableBarrel)
			RenderingRegistry.registerBlockHandler(new BlockBarrelRenderer());
		
		if (ConfigurationHandler.enableTrapdoors)
			RenderingRegistry.registerBlockHandler(new BlockTrapDoorRenderer());
		
		if(ConfigurationHandler.enableSigns)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodSign.class, new TileEntityWoodSignRenderer());

		if(ConfigurationHandler.enableGlazedTerracotta)
			RenderingRegistry.registerBlockHandler(new BlockGlazedTerracottaRenderer());
		
		if(ConfigurationHandler.enableLavaCauldrons)
			RenderingRegistry.registerBlockHandler(new BlockLavaCauldronRenderer());
		
        RenderingRegistry.registerBlockHandler(new BlockChestRenderer());
    }

    @SuppressWarnings("unchecked")
    private void registerEntityRenderers() {
        if (ConfigurationHandler.enableArmourStand)
            RenderingRegistry.registerEntityRenderingHandler(EntityArmourStand.class, new ArmourStandRenderer());
        if (ConfigurationHandler.enableEndermite)
            RenderingRegistry.registerEntityRenderingHandler(EntityEndermite.class, new EndermiteRenderer());
        if (ConfigurationHandler.enableRabbit)
            RenderingRegistry.registerEntityRenderingHandler(EntityRabbit.class, new RabbitRenderer());
        
        if (ConfigurationHandler.enableHusk)
            RenderingRegistry.registerEntityRenderingHandler(EntityHusk.class, new HuskRenderer());
        if (ConfigurationHandler.enableStray) {
            RenderingRegistry.registerEntityRenderingHandler(EntityStray.class, new StrayRenderer());
            RenderingRegistry.registerEntityRenderingHandler(EntityStray.class, new StrayOverlayRenderer());
        }
        
        if (ConfigurationHandler.enableLingeringPotions) {
            RenderingRegistry.registerEntityRenderingHandler(EntityLingeringPotion.class, new LingeringPotionRenderer());
            RenderingRegistry.registerEntityRenderingHandler(EntityLingeringEffect.class, new LingeringEffectRenderer());
        }
        if (ConfigurationHandler.enableVillagerZombies)
            RenderingRegistry.registerEntityRenderingHandler(EntityZombieVillager.class, new VillagerZombieRenderer());
        
        if (ConfigurationHandler.enableDragonRespawn)
            RenderingRegistry.registerEntityRenderingHandler(EntityPlacedEndCrystal.class, new PlacedEndCrystalRenderer());

        if (ConfigurationHandler.enableBrownMooshroom)
            RenderingRegistry.registerEntityRenderingHandler(EntityBrownMooshroom.class, new BrownMooshroomRenderer());
        
        if (ConfigurationHandler.enablePlayerSkinOverlay) {
            TextureManager texManager = Minecraft.getMinecraft().renderEngine;
            File fileAssets = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), "fileAssets", "field_110446_Y", " field_110607_c");
            File skinFolder = new File(fileAssets, "skins");
            MinecraftSessionService sessionService = Minecraft.getMinecraft().func_152347_ac();
            ReflectionHelper.setPrivateValue(Minecraft.class, Minecraft.getMinecraft(), new NewSkinManager(Minecraft.getMinecraft().func_152342_ad(), texManager, skinFolder, sessionService), "field_152350_aA");

            RenderManager.instance.entityRenderMap.put(EntityPlayer.class, new NewRenderPlayer());
        }
        if (ConfigurationHandler.enableShearableGolems)
            RenderingRegistry.registerEntityRenderingHandler(EntityNewSnowGolem.class, new NewSnowGolemRenderer());
    }
}