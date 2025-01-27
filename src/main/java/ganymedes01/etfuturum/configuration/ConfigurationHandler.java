package ganymedes01.etfuturum.configuration;

import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.IFMLSidedHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import ganymedes01.etfuturum.enchantment.FrostWalker;
import ganymedes01.etfuturum.enchantment.Mending;
import ganymedes01.etfuturum.lib.Reference;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

    public static ConfigurationHandler INSTANCE = new ConfigurationHandler();
    public Configuration cfg;
    
    public static final String catClient = "client";
    public static final String catBlock = "blocks";
    public static final String catItems = "items";
    public static final String catEquipment = "equipment";
    public static final String catEnchants = "enchants";
    public static final String catEntity = "entity";
    public static final String catReplacement = "replacement";
    public static final String catFunction = "function";
    public static final String catWorld = "world";
    
    public static final String[] usedCategories = { catClient, catBlock, catItems, catEquipment, catEnchants, catEntity, catReplacement, catFunction, catWorld};

    public static boolean enableStones;
    public static boolean enableIronTrapdoor;
    public static boolean enableMutton;
    public static boolean enableSponge;
    public static boolean enablePrismarine;
    public static boolean enableDoors;
    public static boolean enableTrapdoors;
    public static boolean enableInvertedDaylightSensor;
    public static boolean enableCoarseDirt;
    public static boolean enableRedSandstone;
    public static boolean enableEnchants;
    public static boolean enableAnvil;
    public static boolean enableFences;
    public static boolean enableSilkTouchingMushrooms;
    public static boolean enableBanners;
    public static boolean enableSlimeBlock;
    public static boolean enableArmourStand;
    public static boolean enableRabbit;
    public static boolean enableOldGravel;
    public static boolean enableRecipeForPrismarine;
    public static boolean enableEndermite;
    public static boolean enableBeetroot;
    public static boolean enableChorusFruit;
    public static boolean enableGrassPath;
    public static boolean enableSticksFromDeadBushes;
    public static boolean enableBowRendering;
    public static boolean enableTippedArrows;
    public static boolean enableLingeringPotions;
    public static boolean enableBurnableBlocks;
    public static boolean enableFancySkulls;
    public static boolean enableSkullDrop;
    public static boolean enableDmgIndicator;
    public static boolean enableTransparentAmour;
    public static boolean enableCryingObsidian;
    public static boolean enableUpdatedFoodValues;
    public static boolean enableUpdatedHarvestLevels;
    public static boolean enableVillagerZombies;
    public static boolean enableStoneBrickRecipes;
    public static boolean enableBabyGrowthBoost;
    public static boolean enableVillagerTurnsIntoWitch;
    public static boolean enableElytra;
    public static boolean enableFrostWalker;
    public static boolean enableMending;
    public static boolean enableBrewingStands;
    public static boolean enableDragonRespawn;
    public static boolean enableRoses;
    public static boolean enableColourfulBeacons;
    public static boolean enablePlayerSkinOverlay;
    public static boolean enableShearableGolems;
    public static boolean enableShearableCobwebs;
    public static boolean enableFloatingTrapDoors;
    public static boolean enableBarrel;
    public static boolean enableLantern;
    public static boolean enableSmoker;
    public static boolean enableBlastFurnace;
    public static boolean enableAutoAddSmoker;
    public static boolean enableAutoAddBlastFurnace;
    public static boolean enableMeltGear = false;
    public static int totemHealPercent;
    public static boolean enableBarrier;
    public static boolean enableHoeMining;
	public static boolean enableNetherGold;
	public static boolean enableAirDebris;
	public static int smallDebrisMax = 2;
	public static int debrisMax = 3;
	public static int maxNetherGoldPerCluster;
	public static int maxMagmaPerCluster;
	public static boolean enableSigns;
	public static boolean enableHayBaleFalls;
	public static int hayBaleReducePercent;
	public static boolean enableSmoothStone;
	public static boolean enableSmoothSandstone;
	public static boolean enableSmoothQuartz;
	public static boolean enableQuartzBricks;
	public static boolean enableGenericSlabs;
	public static boolean enableGenericStairs;
	public static boolean enableNewFlowers;
	public static int maxCopperPerCluster;
//	public static boolean enableDyeReplacement;
	public static boolean enableSweetBerryBushes;
	public static boolean enableLavaCauldrons;

    public static boolean enableNewNetherBricks;
    public static boolean enableNetherwartBlock;
    public static boolean enableMagmaBlock;
    public static boolean enableNetherite;
    public static boolean enableBoneBlock;
    public static boolean enableConcrete;
    
    public static boolean enableHusk;
    public static boolean enableStray;
    public static boolean enableNetherEndermen;
    public static boolean enableTotemUndying;
    public static boolean enableRecipeForTotem;
    
    public static boolean enableWoodRedstone;
    public static boolean enableStrippedLogs;
    public static boolean enableBarkLogs;
	public static boolean enableBlueIce;
	public static boolean enableCopper;
	public static boolean enableCopperSubItems;
	public static boolean enableOceanMonuments;

    public static boolean enableTileReplacement;

    public static int maxStonesPerCluster;

    public static boolean enableNetheriteFlammable;
    public static int netheriteToolDurability;
    public static int netheriteEnchantability;
    public static int netheriteHarvestLevel;
    public static float netheriteSpeed;
    public static float netheriteDamageBase;
    public static int netheriteArmourDurabilityFactor;
    public static int netheritePickaxeDurability;
    public static int netheriteSwordDurability;
    public static int netheriteHoeDurability;
    public static int netheriteAxeDurability;
    public static int netheriteSpadeDurability;
    public static int netheriteHelmetDurability;
    public static int netheriteChestplateDurability;
    public static int netheriteLeggingsDurability;
    public static int netheriteBootsDurability;
	public static int minCopperOxidationTime;
	public static int maxCopperOxidationTime;
	public static boolean enableSuspiciousStew;
	public static boolean enableGlazedTerracotta;
	public static boolean enableBrownMooshroom;
	public static boolean enableNewNether;
    
    public static boolean enableIronNugget;
    
    public static boolean enableNewBlocksSounds;
    public static boolean enableNewMiscSounds;
    public static boolean enableNewAmbientSounds;
	public static boolean enableNetherAmbience;
	public static boolean enableExtraF3HTooltips;
    
    //Nether Update temp disabled
    public static boolean enableCrimsonBlocks = false;
    public static boolean enableWarpedBlocks = false;

    public void init(File file) {
        cfg = new Configuration(file);

        syncConfigs();
    }

    private void syncConfigs() {
        
        //blocks
        enableStones = cfg.getBoolean("enableStones", catBlock, true, "Enable Granite/Andesite/Diorite");

        enableNetherGold = cfg.getBoolean("enableNetherGold", catBlock, true, "");
        
        enableIronTrapdoor = cfg.getBoolean("enableIronTrapdoor", catBlock, true, "");
        enableSponge = cfg.getBoolean("enableSponge", catBlock, true, "");
        enablePrismarine = cfg.getBoolean("enablePrismarine", catBlock, true, "");
        enableDoors = cfg.getBoolean("enableDoors", catBlock, true, "Enables wood variant doors");
        enableTrapdoors = cfg.getBoolean("enableTrapdoors", catBlock, true, "Enables wood variant trapdoors");
        enableInvertedDaylightSensor = cfg.getBoolean("enableInvertedSensor", catBlock, true, "Inverted Daylight Sensor");
        enableCoarseDirt = cfg.getBoolean("enableCoarseDirt", catBlock, true, "");
        enableRedSandstone = cfg.getBoolean("enableRedSandstone", catBlock, true, "");
        enableFences = cfg.getBoolean("enableFences", catBlock, true, "Enables wood variant fences and gates");
        enableBanners = cfg.getBoolean("enableBanners", catBlock, true, "");
        enableSlimeBlock = cfg.getBoolean("enableSlimeBlock", catBlock, true, "Just bouncy, does not pull blocks.");
        enableOldGravel = cfg.getBoolean("enableOldGravel", catBlock, true, "");
        enableChorusFruit = cfg.getBoolean("enableChorusBlocks", catBlock, true, "Enables chorus plants and purpur blocks");
        enableGrassPath = cfg.getBoolean("enableGrassPath", catBlock, true, "");
        enableCryingObsidian = cfg.getBoolean("enableCryingObsidian", catBlock, true, "");
        enableRoses = cfg.getBoolean("enableOldRoses", catBlock, true, "");
        
        
        enableNewNetherBricks = cfg.getBoolean("enableRedNetherBricks", catBlock, true, "");
        enableNetherwartBlock = cfg.getBoolean("enableNetherwartBlock", catBlock, true, "");
        enableNetherite = cfg.getBoolean("enableNetherite", catBlock, true, "");
        enableMagmaBlock = cfg.getBoolean("enableMagmaBlock", catBlock, true, "");
        enableBoneBlock = cfg.getBoolean("enableBoneBlock", catBlock, true, "");
        enableConcrete = cfg.getBoolean("enableConcrete", catBlock, true, "");
        
        enableWoodRedstone = cfg.getBoolean("enableWoodRedstone", catBlock, true, "Enables wood variant buttons and pressure plates");
        enableStrippedLogs = cfg.getBoolean("enableStrippedLogs", catBlock, true, "Enables stripped log blocks");
        enableBarkLogs = cfg.getBoolean("enableBarkLogs", catBlock, true, "Enables log blocks with bark on all sides");
        
        enableBarrel = cfg.getBoolean("enableBarrel", catBlock, true, "");
        enableLantern = cfg.getBoolean("enableLantern", catBlock, true, "");
        enableSmoker = cfg.getBoolean("enableSmoker", catBlock, true, "");
        enableBlastFurnace = cfg.getBoolean("enableBlastFurnace", catBlock, true, "");
        enableSigns = cfg.getBoolean("enableSigns", catBlock, true, "");
        enableBlueIce = cfg.getBoolean("enableBlueIce", catBlock, true, "");
        enableSmoothStone = cfg.getBoolean("enableSmoothStone", catBlock, true, "");
        enableSmoothSandstone = cfg.getBoolean("enableSmoothSandStone", catBlock, true, "");
        enableSmoothQuartz = cfg.getBoolean("enableSmoothQuartz", catBlock, true, "");
        enableQuartzBricks = cfg.getBoolean("enableQuartzBricks", catBlock, true, "");
        enableGenericSlabs = cfg.getBoolean("enableGenericSlabs", catBlock, true, "Slabs for vanilla blocks: stone, mossy stone brick, mossy cobble, cut sandstone");
        enableGenericStairs = cfg.getBoolean("enableGenericStairs", catBlock, true, "Stairs for vanilla blocks: stone, mossy stone brick, mossy cobble");
        enableNewFlowers = cfg.getBoolean("enableNewFlowers", catBlock, true, "Cornflower, lily of the valley, wither rose");
        enableCopper = cfg.getBoolean("enableCopper", catBlock, true, "Copper ore and copper blocks, variants, and waxed variants. (Slime balls are used if no mod introduces wax)");
        enableCopperSubItems = cfg.getBoolean("enableCopperSubItems", catBlock, true, "Copper sub-blocks and items. Disable copper but keep this on if you want the new copper items and blocks made of it, without the main ingot, ore or copper block itself.");
        enableSweetBerryBushes = cfg.getBoolean("enableSweetBerryBushes", catBlock, true, "");
        enableGlazedTerracotta = cfg.getBoolean("enableGlazedTerracotta", catBlock, true, "");
        
        enableBarrier = cfg.getBoolean("enableBarrier", catBlock, true, "");
        enableLavaCauldrons = cfg.getBoolean("enableLavaCauldrons", catBlock, true, "Allow lava buckets to fill cauldrons");
        
        //items
        enableMutton = cfg.getBoolean("enableMutton", catItems, true, "");
        enableBeetroot = cfg.getBoolean("enableBeetroot", catItems, true, "");
        enableElytra = cfg.getBoolean("enableElytra", catItems, true, "");
        enableIronNugget = cfg.getBoolean("enableIronNugget", catItems, true, "");
        enableTippedArrows = cfg.getBoolean("enableTippedArrows", catItems, true, "");
        enableLingeringPotions = cfg.getBoolean("enableLingeringPotions", catItems, true, "");
        
        enableTotemUndying = cfg.getBoolean("enableTotemUndying", catItems, true, "");
        enableSuspiciousStew = cfg.getBoolean("enableSuspiciousStew", catItems, true, "");
        
        //equipment
        netheriteToolDurability = cfg.getInt("netheriteToolDurability", catEquipment, 2031, 1, Integer.MAX_VALUE, "");
        netheriteEnchantability = cfg.getInt("netheriteEnchantability", catEquipment, 15, 1, Integer.MAX_VALUE, "");
        netheriteHarvestLevel = cfg.getInt("netheriteHarvestLevel", catEquipment, 4, 0, Integer.MAX_VALUE, "Netherite harvest level, Diamond is 3");
        netheriteSpeed = cfg.getFloat("netheriteSpeed", catEquipment, 9.0f, 0.1f, Float.MAX_VALUE, "Netherite mining speed, Diamond is 8.0");
        netheriteDamageBase  = cfg.getFloat("netheriteDamageBase", catEquipment, 4.0f, 0.0f, Float.MAX_VALUE, "Neterite base damage, Diamond is 3.0");
        netheriteArmourDurabilityFactor = cfg.getInt("netheriteArmourDurabilityFactor", catEquipment, 37, 1, Integer.MAX_VALUE, "");
        netheritePickaxeDurability = cfg.getInt("netheritePickaxeDurability", catEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Pickaxe Durability, -1 to disable");
        netheriteSwordDurability = cfg.getInt("netheriteSwordDurability", catEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Sword Durability, -1 to disable");
        netheriteHoeDurability = cfg.getInt("netheriteHoeDurability", catEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Hoe Durability, -1 to disable");
        netheriteAxeDurability = cfg.getInt("netheriteAxeDurability", catEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Axe Durability, -1 to disable");
        netheriteSpadeDurability = cfg.getInt("netheriteSpadeDurability", catEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Shovel Durability, -1 to disable");
        netheriteHelmetDurability = cfg.getInt("netheriteHelmetDurability", catEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Helmet Durability, -1 to disable");
        netheriteChestplateDurability = cfg.getInt("netheriteChestplateDurability", catEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Chestplate Durability, -1 to disable");
        netheriteLeggingsDurability = cfg.getInt("netheriteLeggingsDurability", catEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Leggings Durability, -1 to disable");
        netheriteBootsDurability = cfg.getInt("netheriteBootsDurability", catEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Boots Durability, -1 to disable");
        enableNetheriteFlammable = cfg.getBoolean("enableNetheriteFlammable", catEquipment, false, "Set to true to disable the fireproof item entity Netherite/ancient debris etc uses");
        
        //enchants
        enableFrostWalker = cfg.getBoolean("frostWalker", catEnchants, true, "");
        FrostWalker.ID = cfg.getInt("frostWalkerID", catEnchants, 36, 0, 1023, "");
        
        enableMending = cfg.getBoolean("mending", catEnchants, true, "");
        Mending.ID = cfg.getInt("mendingID", catEnchants, 37, 0, 1023, "");
        
        //mobs
        enableRabbit = cfg.getBoolean("enableRabbits", catEntity, true, "");
        enableArmourStand = cfg.getBoolean("enableArmorStand", catEntity, true, "");
        enableEndermite = cfg.getBoolean("enableEndermite", catEntity, true, "");
        enableVillagerZombies = cfg.getBoolean("enableZombieVillager", catEntity, true, "");
        
        enableHusk = cfg.getBoolean("enableHusks", catEntity, true, "Desert zombie variant");
        enableStray = cfg.getBoolean("enableStrays", catEntity, true, "Tundra skeleton variant");
        enableBrownMooshroom = cfg.getBoolean("enableBrownMooshroom", catEntity, true, "Brown mooshroom variant");
        
        //function
        enableSilkTouchingMushrooms = cfg.getBoolean("enableSilkMushroom", catFunction, true, "Mushroom blocks can be silk-touched");
        enableRecipeForPrismarine = cfg.getBoolean("enablePrismarineRecipes", catFunction, true, "");
        enableSticksFromDeadBushes = cfg.getBoolean("enableBushSticks", catFunction, true, "Dead Bushes drop sticks");
        enableSkullDrop = cfg.getBoolean("enableSkullDrop", catFunction, true, "Skulls drop from charged creeper kills");
        enableBurnableBlocks = cfg.getBoolean("enableBurnables", catFunction, true, "Fences, gates and dead bushes burn");
        enableUpdatedFoodValues = cfg.getBoolean("enableUpdatedFood", catFunction, true, "Use updated food values");
        enableUpdatedHarvestLevels = cfg.getBoolean("enableUpdatedHarvestLevels", catFunction, true, "Packed Ice, ladders and melons have preferred tools");
        enableShearableGolems = cfg.getBoolean("enableShearableSnowGolems", catFunction, true, "");
        enableShearableCobwebs = cfg.getBoolean("enableShearableCobwebs", catFunction, true, "");
        enableFloatingTrapDoors = cfg.getBoolean("enableFloatingTrapDoors", catFunction, true, "");
        enableStoneBrickRecipes = cfg.getBoolean("enableStoneBrickRecipes", catFunction, true, "Makes mossy, cracked and chiseled stone brick craftable");
        enableBabyGrowthBoost = cfg.getBoolean("enableBabyGrowthBoost", catFunction, true, "");
        enableVillagerTurnsIntoWitch = cfg.getBoolean("enableVillagerTurnsIntoWitch", catFunction, true, "Villagers turn into Witches when struck by lightning");
        
        enableDragonRespawn = cfg.getBoolean("enableDragonRespawn", catFunction, true, "");
        enableNetherEndermen = cfg.getBoolean("enableNetherEndermen", catFunction, true, "Allow endermen to rarely spawn in the Nether");
        
        enableAutoAddSmoker = cfg.getBoolean("enableAutoAddSmoker", catFunction, true, "Auto-adds smeltable foods to the smoker, turn off for only vanilla food");
        enableAutoAddBlastFurnace = cfg.getBoolean("enableAutoAddBlastFurnace", catFunction, true, "Auto-adds ores to the blast furnace, detected if the input has the \"ore\" oreDictionary prefix and is smeltable. Turn off for only vanilla ores");
        totemHealPercent = cfg.getInt("totemHealPercent", catFunction, 5, 5, 100, "Percentage of max health for totem to set you at if you die with it. (5% is 0.05, 20 * 0.05 = 1, 1 health is one half-heart)");
        enableHoeMining = cfg.getBoolean("enableHoeMining", catFunction, true, "Allows blocks like hay bales, leaves etc to mine faster with hoes");
        enableRecipeForTotem = cfg.getBoolean("enableRecipeForTotem", catFunction, false, "Recipe for totems since there's no other way to get them currently?");
        enableHayBaleFalls = cfg.getBoolean("enableHayBaleFalls", catFunction, true, "If true, fall damage on a hay bale will be reduced");
        hayBaleReducePercent = cfg.getInt("hayBaleReducePercent", catFunction, 20, 0, 99, "If enableHayBaleFalls is true, what percent should we keep for the fall damage?");
        minCopperOxidationTime = cfg.getInt("minCopperOxidationTime", catFunction, 1200000, 1, Integer.MAX_VALUE / 2, "Minimum time (in ticks) it takes for copper to advance to the next stage of weathering. Note: This and the below value don't effect copper blocks already placed in the world before this is changed, you'll need to break and replace them to get the new times.");
        maxCopperOxidationTime = cfg.getInt("maxCopperOxidationTime", catFunction, 768000, 1, Integer.MAX_VALUE / 2, "Number added to the minimum time, (in ticks) it takes for copper to advance to the next stage of weathering. Ranges from 0 to the given value. Total time to oxidize copper: Minimum time + 0 to maximum time");
//        enableDyeReplacement = cfg.getBoolean("enableDyeReplacement", catFunction, true, "Removes lapis, bone meal, ink sac and cocoa bean's ore dictionary entries as dyes, making the Et Futurum dyes the dyes instead. Disable if this causes weirdisms with modded recipes. (If false both items can be used)");
        
        //replacement
        enableTileReplacement = cfg.getBoolean("enableTileReplacement", catReplacement, true, "Replace old Brewing Stands/Enchanting Tables/Daylight Sensors/Beacons with new one on the fly.");
        
        enableEnchants = cfg.getBoolean("enableEnchantingTable", catReplacement, true, "");
        enableAnvil = cfg.getBoolean("enableAnvil", catReplacement, true, "");
        enableBrewingStands = cfg.getBoolean("enableBrewingStand", catReplacement, true, "");
        enableColourfulBeacons = cfg.getBoolean("enableBeacon", catReplacement, true, "Beacon beam can be colored using stained glass");
        
        //client
        enableDmgIndicator = cfg.getBoolean("enableDmgIndicator", catClient, true, "Heart Damage Indicator");
        enableTransparentAmour = cfg.getBoolean("enableTransparentAmour", catClient, true, "Allow non-opaque armour");
        enableBowRendering = cfg.getBoolean("enableBowRendering", catClient, true, "Bows render pulling animation on inventory");
        enableFancySkulls = cfg.getBoolean("enableFancySkulls", catClient, true, "Skulls render 3D in inventory");
        enablePlayerSkinOverlay = cfg.getBoolean("enablePlayerSkinOverlay", catClient, true, "Allows use of 1.8 skin format, and Alex skins. Disable if skin is displaying oddly.");
        enableNewBlocksSounds = cfg.getBoolean("enableNewBlocksSounds", catClient, true, "New Blocks sounds, such as the new place/break sounds added alongside new blocks, or ones added to existing blocks");
        enableNewMiscSounds = cfg.getBoolean("enableNewMiscSounds", catClient, true, "New sounds like furnace crackling, chests etc.");
        enableNewAmbientSounds = cfg.getBoolean("enableNewAmbientSounds", catClient, true, "New ambient sounds like rain, cave sounds");
        enableNetherAmbience = cfg.getBoolean("enableNetherAmbience", catClient, true, "");
        enableExtraF3HTooltips = cfg.getBoolean("enableExtraF3HTooltips", catClient, true, "Enables NBT tag count and item namespace label on F3 + H debug item labels");
     
        //world
        enableAirDebris = cfg.getBoolean("enableAirDebris", catWorld, false, "Can ancient debris generate next to air?");
        maxStonesPerCluster = cfg.getInt("maxStonesPerCluster", catWorld, 33, 0, 64, "Max vein size for Granite/Andesite/Diorite blocks in a cluster");
        smallDebrisMax = cfg.getInt("smallDebrisMax", catWorld, 2, 0, 64, "The max vein size for the first, typically smaller debris veins which generate from Y 8 to 119");
        debrisMax = cfg.getInt("debrisMax", catWorld, 3, 0, 64, "The max vein size for the second, typically bigger debris veins, which generate from Y 8 to 22");
        maxNetherGoldPerCluster = cfg.getInt("maxNetherGoldPerCluster", catWorld, 10, 0, 64, "Max vein size for nether gold ore blocks in a cluster");
        maxMagmaPerCluster = cfg.getInt("maxMagmaPerCluster", catWorld, 33, 0, 64, "Max vein size for magma blocks in a cluster");
        maxCopperPerCluster = cfg.getInt("copperClusterSize", catWorld, 14, 0, 64, "Max vein size for copper ore blocks in a cluster");
        enableOceanMonuments = cfg.getBoolean("enableOceanMonuments", catWorld, true, "Note: Ocean monuments currently do not have guardians");
//        enableNewNether = cfg.getBoolean("enableNewNether", catWorld, true, "When false, the new Nether completely stops to generate, regardless of if the new Nether blocks are on. (Will be ignored if Netherlicious is installed)");
        
        if(Loader.isModLoaded("netherlicious")) // Come back to
        	enableNewNether = false;
        
        if (cfg.hasChanged()) {
            cfg.save();
        }
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if (Reference.MOD_ID.equals(eventArgs.modID))
            syncConfigs();
    }
}
