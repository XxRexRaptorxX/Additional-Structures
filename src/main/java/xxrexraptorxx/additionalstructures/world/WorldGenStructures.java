package xxrexraptorxx.additionalstructures.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import xxrexraptorxx.additionalstructures.config.ConfigGeneral;
import xxrexraptorxx.additionalstructures.config.ConfigStructures;
import xxrexraptorxx.additionalstructures.util.DebugHelper;

public class WorldGenStructures implements IWorldGenerator {
	
    private static List<Biome> biomeList = ForgeRegistries.BIOMES.getValues();
    

    
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if(world.getWorldInfo().isMapFeaturesEnabled() && world.getWorldType() != WorldType.FLAT) {
			int blockX = chunkX * 16 + random.nextInt(16);			//(chunkZ * 16) + random.nextInt(15)   OLD
			int blockZ = chunkZ * 16 + random.nextInt(16);
			
		if (world.provider.getDimension() == DimensionType.THE_END.getId()) {
			if(ConfigGeneral.activateEndGeneration) {
				//End
				generateStructure(StructureList.BONE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceBones, BiomeDictionary.getBiomes(Type.END));
				generateStructure(StructureList.BONE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceBones, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.END_ALTAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.END_ALTAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.END_HOUSE, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndBuildings, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.END_VILLA, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndBuildings, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.END_PILLARS, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.END_TOWER_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndTowers, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.END_TOWER_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndTowers, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.END_TOWER_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndTowers, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.END_TOWER_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndTowers, BiomeDictionary.getBiomes(Type.END));
				generateStructure(StructureList.END_WALL_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, BiomeDictionary.getBiomes(Type.END));
				generateStructure(StructureList.END_WALL_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, BiomeDictionary.getBiomes(Type.END));
				generateStructure(StructureList.END_WALL_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, BiomeDictionary.getBiomes(Type.END));
				generateStructure(StructureList.END_CRYSTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndCrystals, BiomeDictionary.getBiomes(Type.END));
				generateStructure(StructureList.FOSSIL_ENDERDRAGON_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFossils, BiomeDictionary.getBiomes(Type.END));
				generateStructure(StructureList.FOSSIL_ENDERDRAGON_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFossils, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.FOSSIL_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFossils, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.FOSSIL_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFossils, BiomeDictionary.getBiomes(Type.END));
				generateStructure(StructureList.SKULL_WITHER, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.OBSIDIAN_PILLAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianPillars, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.OBSIDIAN_PILLAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianPillars, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.OBSIDIAN_PILLAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianPillars, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.OBSIDIAN_PILLAR_BROKEN_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianPillars, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.OBSIDIAN_PILLAR_BROKEN_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianPillars, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, BiomeDictionary.getBiomes(Type.END));
				generateUndergroundStructure(StructureList.END_DUNGEON, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.END_RUIN, world, random, blockX, blockZ, ConfigStructures.spawnchanceRuins, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.ENDBRICK_PILLAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.END));
				generateDownsetStructure(StructureList.ENDBRICK_PILLAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.END));
				generateBuryStructure(StructureList.OBSIDIAN_SPIKES_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianSpikes, BiomeDictionary.getBiomes(Type.END));
				generateBuryStructure(StructureList.OBSIDIAN_SPIKES_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianSpikes, BiomeDictionary.getBiomes(Type.END));
				generateBuryStructure(StructureList.OBSIDIAN_SPIKES_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianSpikes, BiomeDictionary.getBiomes(Type.END));
				generateBuryStructure(StructureList.END_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndTrees, BiomeDictionary.getBiomes(Type.END));
				generateBuryStructure(StructureList.END_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndTrees, BiomeDictionary.getBiomes(Type.END));
				generateBuryStructure(StructureList.SHULKER_CLUSTER_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceShulkerClusters, BiomeDictionary.getBiomes(Type.END));
				generateBuryStructure(StructureList.SHULKER_CLUSTER_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceShulkerClusters, BiomeDictionary.getBiomes(Type.END));
			}
		} else if (world.provider.getDimension() == DimensionType.NETHER.getId()) {
			if(ConfigGeneral.activateNetherGeneration) {
				//Nether
//				generateStructure(StructureList.WITHER_ALTAR, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpecials, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, BiomeDictionary.getBiomes(Type.NETHER));
//				generateDownsetStructure(StructureList.FOSSIL_ENDERDRAGON_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFossils, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_WALL_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, BiomeDictionary.getBiomes(Type.NETHER));
//				generateDownsetStructure(StructureList.FOSSIL_1, world, random, blockX, blockZ, Math.round(ConfigStructures.spawnchanceFossils / 4), BiomeDictionary.getBiomes(Type.NETHER));
//				generateDownsetStructure(StructureList.FOSSIL_2, world, random, blockX, blockZ, Math.round(ConfigStructures.spawnchanceFossils / 4), BiomeDictionary.getBiomes(Type.NETHER));
//				generateDownsetStructure(StructureList.BONE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceBones, BiomeDictionary.getBiomes(Type.NETHER));
//				generateDownsetStructure(StructureList.BONE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceBones, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_WALL_1, world, random, blockX, blockZ, 200, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_WALL_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_WALL_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_DUNGEON_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_DUNGEON_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_DUNGEON_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_BASE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_BUILDING_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherBuildings, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_BUILDING_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherBuildings, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_BUILDING_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherBuildings, BiomeDictionary.getBiomes(Type.NETHER));
//				generateStructure(StructureList.NETHER_VILLAGER_HOUSE, world, random, blockX, blockZ, ConfigStructures.spawnchanceVillagerHouses, BiomeDictionary.getBiomes(Type.NETHER));
			}	
		} else if (ConfigGeneral.additionalDimensions.length > 0) {
			for (int i = 0; i<ConfigGeneral.additionalDimensions.length; i++) {
			      int dimension = ConfigGeneral.additionalDimensions[i];
			     
			  if(world.provider.getDimension() == dimension) {
			
			    if(ConfigGeneral.activateOverworldGeneration) {
				//Desert
				generateStructure(StructureList.DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.BIG_CACTUS, world, random, blockX, blockZ, ConfigStructures.spawnchanceBiggerCacti, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.HUGE_CACTUS, world, random, blockX, blockZ, ConfigStructures.spawnchanceBiggerCacti, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.SMALL_PYRAMIDE, world, random, blockX, blockZ, ConfigStructures.spawnchancePyramides, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.PYRAMIDE_TEMPLE, world, random, blockX, blockZ, ConfigStructures.spawnchanceTemple, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.ACACIA_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.ROCK_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.ROCK_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.ROCK_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.SANDY));			
				generateDownsetStructure(StructureList.ROCK_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.SANDY));			
				generateStructure(StructureList.SAND_ROCK_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.SAND_ROCK_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.SAND_ROCK_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.SANDY));
				generateDownsetStructure(StructureList.DESERT_PILLARS_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceDesertPillars, BiomeDictionary.getBiomes(Type.SANDY));
				generateDownsetStructure(StructureList.DESERT_PILLARS_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceDesertPillars, BiomeDictionary.getBiomes(Type.SANDY));
				generateDownsetStructure(StructureList.SAND_TOTEM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceTotems, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.SAND_TOTEM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceTotems, BiomeDictionary.getBiomes(Type.SANDY));
				generateDownsetStructure(StructureList.SAND_TOTEM_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTotems, BiomeDictionary.getBiomes(Type.SANDY));
				generateBuryStructure(StructureList.OASE, world, random, blockX, blockZ, ConfigStructures.spawnchanceOasis, BiomeDictionary.getBiomes(Type.SANDY));
				generateDownsetStructure(StructureList.OASE_SMALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceOasis, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.PALM_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchancePalms, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.PALM_SMALL, world, random, blockX, blockZ, ConfigStructures.spawnchancePalms, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.PALM_1, world, random, blockX, blockZ, ConfigStructures.spawnchancePalms, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.PALM_2, world, random, blockX, blockZ, ConfigStructures.spawnchancePalms, BiomeDictionary.getBiomes(Type.SANDY));
				generateUndergroundStructure(StructureList.DESERT_TOMB, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, BiomeDictionary.getBiomes(Type.SANDY));
				generateBuryStructure(StructureList.PYRAMIDE_DUNGEON, world, random, blockX, blockZ, ConfigStructures.spawnchancePyramideDungeon, BiomeDictionary.getBiomes(Type.SANDY));
				generateDownsetStructure(StructureList.SPHINX, world, random, blockX, blockZ, ConfigStructures.spawnchanceSphinx, BiomeDictionary.getBiomes(Type.SANDY));
				generateDownsetStructure(StructureList.PYRAMIDE_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchancePyramides, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.FALLEN_DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.FALLEN_DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.FALLEN_DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.FALLEN_PALM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.SANDY));
				generateStructure(StructureList.FALLEN_PALM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.SANDY));
				generateUndergroundStructure(StructureList.SARCOPHAGUS_ROOM, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, BiomeDictionary.getBiomes(Type.SANDY));
				//Snow
				generateStructure(StructureList.SNOWMAN, world, random, blockX, blockZ, ConfigStructures.spawnchanceSnowmen, BiomeDictionary.getBiomes(Type.SNOWY));
				generateStructure(StructureList.SNOWMAN_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSnowmen, BiomeDictionary.getBiomes(Type.SNOWY));
				generateStructure(StructureList.DEAD_SPRUCE_TREE, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.SNOWY));
				generateStructure(StructureList.SPRUCE_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.SNOWY));
				generateStructure(StructureList.FALLEN_SPRUCE_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.SNOWY));
				generateStructure(StructureList.FALLEN_SPRUCE_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.SNOWY));
				generateStructure(StructureList.SNOW_PILE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSnowPiles, BiomeDictionary.getBiomes(Type.SNOWY));
				generateStructure(StructureList.SNOW_PILE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSnowPiles, BiomeDictionary.getBiomes(Type.SNOWY));
				generateStructure(StructureList.SNOW_PILE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSnowPiles, BiomeDictionary.getBiomes(Type.SNOWY));
				//Swamp
				generateStructure(StructureList.WITCH_BREWING_STAND, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.SWAMP));
				generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, BiomeDictionary.getBiomes(Type.SWAMP));
				generateStructure(StructureList.SCARECROW, world, random, blockX, blockZ, ConfigStructures.spawnchanceScarecrow, BiomeDictionary.getBiomes(Type.SWAMP));
				generateStructure(StructureList.ILLAGER_HOUSE, world, random, blockX, blockZ, ConfigStructures.spawnchanceIllagerHouses, BiomeDictionary.getBiomes(Type.SWAMP));
				generateDownsetStructure(StructureList.ALTAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.SWAMP));
				generateDownsetStructure(StructureList.ALTAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.SWAMP));
				generateDownsetStructure(StructureList.ALTAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.SWAMP));
				generateDownsetStructure(StructureList.ALTAR_BIG_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.SWAMP));
				generateDownsetStructure(StructureList.ALTAR_BIG_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.SWAMP));
				generateDownsetStructure(StructureList.NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, BiomeDictionary.getBiomes(Type.SWAMP));
					generateStructure(StructureList.OAK_LOG_SHORT, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.SWAMP));
					generateStructure(StructureList.OAK_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.SWAMP));
				generateUndergroundStructure(StructureList.TOMB, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, BiomeDictionary.getBiomes(Type.SWAMP));
				generateBuryStructure(StructureList.HORCRUX, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpecials, BiomeDictionary.getBiomes(Type.SWAMP));
				generateUndergroundStructure(StructureList.TOMB_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs + 500, BiomeDictionary.getBiomes(Type.SWAMP));
				generateDownsetStructure(StructureList.TOWER_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, BiomeDictionary.getBiomes(Type.SWAMP));				
				generateDownsetStructure(StructureList.TOWER_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, BiomeDictionary.getBiomes(Type.SWAMP));	
				generateDownsetStructure(StructureList.ALTAR_TOTEM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.SWAMP));
				generateDownsetStructure(StructureList.ALTAR_TOTEM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.SWAMP));
				generateDownsetStructure(StructureList.ALTAR_TOTEM_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.SWAMP));
				//Jungle
				generateStructure(StructureList.TREE_HOLE, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateStructure(StructureList.DEAD_JUNGLE_TREE, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateStructure(StructureList.JUNGLE_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateStructure(StructureList.BIG_JUNGLE_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateStructure(StructureList.FALLEN_JUNGLE_TREE, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateStructure(StructureList.OAK_LOG_SHORT, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateBuryStructure(StructureList.MAYA_TEMPLE, world, random, blockX, blockZ, ConfigStructures.spawnchanceMayaTemple, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateDownsetStructure(StructureList.ALTAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateDownsetStructure(StructureList.ALTAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateDownsetStructure(StructureList.ALTAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateDownsetStructure(StructureList.ALTAR_BIG_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateDownsetStructure(StructureList.ALTAR_BIG_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateDownsetStructure(StructureList.JUNGLE_TEMPLE, world, random, blockX, blockZ, ConfigStructures.spawnchanceTemple, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateUndergroundStructure(StructureList.FALL_TRAP, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateUndergroundStructure(StructureList.TOMB, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateUndergroundStructure(StructureList.TOMB_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs + 500, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateStructure(StructureList.MUSHROOM, world, random, blockX, blockZ, ConfigStructures.spawnchanceMushrooms, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateStructure(StructureList.STONE_PILLAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateStructure(StructureList.STONE_PILLAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.JUNGLE));
				generateStructure(StructureList.STONE_PILLAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.JUNGLE));
				//Forest
				generateStructure(StructureList.OAK_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.OAK_LOG_SHORT, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.SPRUCE_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.SPRUCE_LOG_SHORT, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.LOG_BUNDLE, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogBundle, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.DEAD_OAK_TREE, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.BUSH_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.BUSH_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.BUSH_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.BUSH_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.SCARECROW, world, random, blockX, blockZ, ConfigStructures.spawnchanceScarecrow, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.ROCK_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.ROCK_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.ROCK_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.FOREST));
				generateDownsetStructure(StructureList.ROCK_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.ROCK_COBBLE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.ROCK_COBBLE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.ROCK_COBBLE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.FALLEN_OAK_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.FALLEN_OAK_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.FOREST));
				generateDownsetStructure(StructureList.ALTAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.FOREST));
				generateDownsetStructure(StructureList.ALTAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.FOREST));
				generateDownsetStructure(StructureList.ALTAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.FOREST));
				generateDownsetStructure(StructureList.ALTAR_BIG_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.FOREST));
				generateDownsetStructure(StructureList.ALTAR_BIG_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.FOREST));
				generateBuryStructure(StructureList.GRAVE, world, random, blockX, blockZ, ConfigStructures.spawnchanceGrave, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.ILLAGER_HOUSE, world, random, blockX, blockZ, ConfigStructures.spawnchanceIllagerHouses, BiomeDictionary.getBiomes(Type.FOREST));
				generateDownsetStructure(StructureList.NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.VILLAGER_HOUSE, world, random, blockX, blockZ, ConfigStructures.spawnchanceVillagerHouses, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.VILLAGER_HOUSE_SMALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceVillagerHouses, BiomeDictionary.getBiomes(Type.FOREST));
				generateBuryStructure(StructureList.WELL_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceWell, BiomeDictionary.getBiomes(Type.FOREST));
				generateBuryStructure(StructureList.WELL_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceWell, BiomeDictionary.getBiomes(Type.FOREST));
				generateStructure(StructureList.VILLAGER_HOUSE_BROCKEN, world, random, blockX, blockZ, ConfigStructures.spawnchanceVillagerHouses + 500, BiomeDictionary.getBiomes(Type.FOREST));
				generateUndergroundStructure(StructureList.SPIDER_NEST_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpiderNests, BiomeDictionary.getBiomes(Type.FOREST));
				generateUndergroundStructure(StructureList.SPIDER_NEST_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpiderNests, BiomeDictionary.getBiomes(Type.FOREST));
				generateUndergroundStructure(StructureList.SPIDER_NEST_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpiderNests, BiomeDictionary.getBiomes(Type.FOREST));
				generateUndergroundStructure(StructureList.DUNGEON_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, BiomeDictionary.getBiomes(Type.FOREST));				
				generateUndergroundStructure(StructureList.DUNGEON_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, BiomeDictionary.getBiomes(Type.FOREST));				
				generateUndergroundStructure(StructureList.UNDERGROUND_BASE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.FOREST));				
				generateUndergroundStructure(StructureList.UNDERGROUND_VILLAGE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.FOREST));				
				generateUndergroundStructure(StructureList.UNDERGROUND_STOLLEN, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.FOREST));				
				generateUndergroundStructure(StructureList.UNDERGROUND_PRISON, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.FOREST));				
				generateUndergroundStructure(StructureList.SEWAGE_SYSTEM, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.FOREST));				
				generateStructure(StructureList.RUIN, world, random, blockX, blockZ, ConfigStructures.spawnchanceRuins, BiomeDictionary.getBiomes(Type.FOREST));
				generateUndergroundStructure(StructureList.TOMB, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, BiomeDictionary.getBiomes(Type.FOREST));
				generateUndergroundStructure(StructureList.TOMB_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs + 500, BiomeDictionary.getBiomes(Type.FOREST));				
				generateBuryStructure(StructureList.CHEST_TRAP, world, random, blockX, blockZ, ConfigStructures.spawnchanceTraps, BiomeDictionary.getBiomes(Type.FOREST));				
				generateUndergroundStructure(StructureList.UNDERGOUND_NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, BiomeDictionary.getBiomes(Type.FOREST));
				generateDownsetStructure(StructureList.TOWER_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, BiomeDictionary.getBiomes(Type.FOREST));				
				generateDownsetStructure(StructureList.TOWER_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, BiomeDictionary.getBiomes(Type.FOREST));	
				generateStructure(StructureList.MUSHROOM, world, random, blockX, blockZ, ConfigStructures.spawnchanceMushrooms, BiomeDictionary.getBiomes(Type.FOREST));
				generateDownsetStructure(StructureList.ALTAR_TOTEM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.FOREST));
				generateDownsetStructure(StructureList.ALTAR_TOTEM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.FOREST));
				generateDownsetStructure(StructureList.ALTAR_TOTEM_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.FOREST));
				//Plains
				generateStructure(StructureList.ROCK_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.ROCK_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.ROCK_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.PLAINS));
				generateDownsetStructure(StructureList.ROCK_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.PLAINS));
				generateDownsetStructure(StructureList.CAMP, world, random, blockX, blockZ, ConfigStructures.spawnchanceCamps, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.SCARECROW, world, random, blockX, blockZ, ConfigStructures.spawnchanceScarecrow, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.BUSH_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.BUSH_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.BUSH_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.BUSH_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.SCARECROW, world, random, blockX, blockZ, ConfigStructures.spawnchanceScarecrow, BiomeDictionary.getBiomes(Type.PLAINS));
				generateBuryStructure(StructureList.GRAVE, world, random, blockX, blockZ, ConfigStructures.spawnchanceGrave, BiomeDictionary.getBiomes(Type.PLAINS));
				generateBuryStructure(StructureList.MINE_ENTRY, world, random, blockX, blockZ, ConfigStructures.spawnchanceMineEntry, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.OAK_LOG_SHORT, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.STONE_PILLAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.STONE_PILLAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.STONE_PILLAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.PLAINS));
				generateUndergroundStructure(StructureList.TOMB, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.VILLAGER_HOUSE, world, random, blockX, blockZ, ConfigStructures.spawnchanceVillagerHouses, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.VILLAGER_HOUSE_SMALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceVillagerHouses, BiomeDictionary.getBiomes(Type.PLAINS));
				generateBuryStructure(StructureList.WALL_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.WALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, BiomeDictionary.getBiomes(Type.PLAINS));
				generateStructure(StructureList.WHEAT_BALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceWheatBalls, BiomeDictionary.getBiomes(Type.PLAINS));
				generateBuryStructure(StructureList.WELL_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceWell, BiomeDictionary.getBiomes(Type.PLAINS));
				generateBuryStructure(StructureList.WELL_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceWell, BiomeDictionary.getBiomes(Type.PLAINS));
				generateDownsetStructure(StructureList.FARM, world, random, blockX, blockZ, ConfigStructures.spawnchanceFarm, BiomeDictionary.getBiomes(Type.PLAINS));
				generateUndergroundStructure(StructureList.DUNGEON_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, BiomeDictionary.getBiomes(Type.PLAINS));				
				generateUndergroundStructure(StructureList.DUNGEON_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, BiomeDictionary.getBiomes(Type.PLAINS));				
				generateUndergroundStructure(StructureList.UNDERGROUND_BASE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.PLAINS));				
				generateUndergroundStructure(StructureList.TOMB_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs + 500, BiomeDictionary.getBiomes(Type.PLAINS));				
				generateUndergroundStructure(StructureList.UNDERGROUND_VILLAGE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.PLAINS));				
				generateUndergroundStructure(StructureList.UNDERGROUND_STOLLEN, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.PLAINS));				
				generateUndergroundStructure(StructureList.UNDERGROUND_PRISON, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, BiomeDictionary.getBiomes(Type.PLAINS));				
				generateUndergroundStructure(StructureList.SEWAGE_SYSTEM, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.PLAINS));							
				generateStructure(StructureList.RUIN, world, random, blockX, blockZ, ConfigStructures.spawnchanceRuins, BiomeDictionary.getBiomes(Type.PLAINS));
				generateBuryStructure(StructureList.STONE_CIRCLE_RUIN, world, random, blockX, blockZ, ConfigStructures.spawnchanceRuins, BiomeDictionary.getBiomes(Type.PLAINS));
				generateDownsetStructure(StructureList.TOWER_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, BiomeDictionary.getBiomes(Type.PLAINS));				
				generateDownsetStructure(StructureList.TOWER_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, BiomeDictionary.getBiomes(Type.PLAINS));	
				generateStructure(StructureList.MUSHROOM, world, random, blockX, blockZ, ConfigStructures.spawnchanceMushrooms + 5000, BiomeDictionary.getBiomes(Type.PLAINS));
				//Mountain
				generateStructure(StructureList.ROCK_COBBLE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateStructure(StructureList.ROCK_COBBLE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateStructure(StructureList.ROCK_COBBLE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateStructure(StructureList.STONE_PILLAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateStructure(StructureList.STONE_PILLAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateStructure(StructureList.STONE_PILLAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateBuryStructure(StructureList.LAVA_FOUNTAIN, world, random, blockX, blockZ, ConfigStructures.spawnchanceLavaFountain, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateBuryStructure(StructureList.METEOR, world, random, blockX, blockZ, ConfigStructures.spawnchanceMeteor, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateBuryStructure(StructureList.MINE_ENTRY, world, random, blockX, blockZ, ConfigStructures.spawnchanceMineEntry ,BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateUndergroundStructure(StructureList.TOMB, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateBuryStructure(StructureList.FLAG, world, random, blockX, blockZ, ConfigStructures.spawnchanceOthers + 1500, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateUndergroundStructure(StructureList.SPIDER_NEST_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpiderNests, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateUndergroundStructure(StructureList.SPIDER_NEST_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpiderNests, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateUndergroundStructure(StructureList.SPIDER_NEST_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpiderNests, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateUndergroundStructure(StructureList.UNDERGROUND_BASE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.MOUNTAIN));				
				generateUndergroundStructure(StructureList.UNDERGROUND_VILLAGE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.MOUNTAIN));				
				generateUndergroundStructure(StructureList.UNDERGROUND_STOLLEN, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.MOUNTAIN));				
				generateUndergroundStructure(StructureList.UNDERGROUND_PRISON, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.MOUNTAIN));				
				generateUndergroundStructure(StructureList.SEWAGE_SYSTEM, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, BiomeDictionary.getBiomes(Type.MOUNTAIN));							
				generateUndergroundStructure(StructureList.DUNGEON_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, BiomeDictionary.getBiomes(Type.MOUNTAIN));				
				generateUndergroundStructure(StructureList.DUNGEON_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, BiomeDictionary.getBiomes(Type.MOUNTAIN));				
				generateUndergroundStructure(StructureList.TOMB_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs + 500, BiomeDictionary.getBiomes(Type.MOUNTAIN));				
				generateUndergroundStructure(StructureList.UNDERGOUND_NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, BiomeDictionary.getBiomes(Type.MOUNTAIN));
				generateUndergroundStructure(StructureList.FALL_TRAP, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, BiomeDictionary.getBiomes(Type.MOUNTAIN));				
				generateUndergroundStructure(StructureList.SILVERFISH_CLUSTER_SMALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSilverfishCluster, BiomeDictionary.getBiomes(Type.MOUNTAIN));				
				generateUndergroundStructure(StructureList.SILVERFISH_CLUSTER_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceSilverfishCluster, BiomeDictionary.getBiomes(Type.MOUNTAIN));				
				//Mesa
				generateStructure(StructureList.ACACIA_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.MESA));
				generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, BiomeDictionary.getBiomes(Type.MESA));
				generateStructure(StructureList.DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, BiomeDictionary.getBiomes(Type.MESA));
				generateStructure(StructureList.DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, BiomeDictionary.getBiomes(Type.MESA));
				generateStructure(StructureList.DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, BiomeDictionary.getBiomes(Type.MESA));
				generateBuryStructure(StructureList.LAVA_FOUNTAIN, world, random, blockX, blockZ, ConfigStructures.spawnchanceLavaFountain, BiomeDictionary.getBiomes(Type.MESA));
				generateStructure(StructureList.SAND_TOTEM_RED, world, random, blockX, blockZ, ConfigStructures.spawnchanceTotems, BiomeDictionary.getBiomes(Type.MESA));
				generateDownsetStructure(StructureList.SAND_TOTEM_RED_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTotems, BiomeDictionary.getBiomes(Type.MESA));
				generateStructure(StructureList.STONE_PILLAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.MESA));
				generateStructure(StructureList.STONE_PILLAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.MESA));
				generateStructure(StructureList.STONE_PILLAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, BiomeDictionary.getBiomes(Type.MESA));
				//Ocean
				generateDownsetStructure(StructureList.BOAT, world, random, blockX, blockZ, ConfigStructures.spawnchanceBoats, BiomeDictionary.getBiomes(Type.OCEAN));
				generateDownsetStructure(StructureList.RAFT, world, random, blockX, blockZ, ConfigStructures.spawnchanceBoats, BiomeDictionary.getBiomes(Type.OCEAN));
				generateDownsetStructure(StructureList.OAK_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceFlotsam, BiomeDictionary.getBiomes(Type.OCEAN));
				generateDownsetStructure(StructureList.FLOTSAM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFlotsam, BiomeDictionary.getBiomes(Type.OCEAN));
				generateDownsetStructure(StructureList.FLOTSAM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFlotsam, BiomeDictionary.getBiomes(Type.OCEAN));
				generateDownsetStructure(StructureList.FLOTSAM_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceFlotsam, BiomeDictionary.getBiomes(Type.OCEAN));
				//Savanna
				generateStructure(StructureList.ACACIA_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.SAVANNA));
				generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, BiomeDictionary.getBiomes(Type.SAVANNA));
				generateStructure(StructureList.DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, BiomeDictionary.getBiomes(Type.SAVANNA));
				generateStructure(StructureList.DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, BiomeDictionary.getBiomes(Type.SAVANNA));
				generateStructure(StructureList.DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, BiomeDictionary.getBiomes(Type.SAVANNA));
				generateStructure(StructureList.FALLEN_DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.SAVANNA));
				generateStructure(StructureList.FALLEN_DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.SAVANNA));
				generateStructure(StructureList.FALLEN_DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.SAVANNA));
				//Wasteland
				generateStructure(StructureList.ACACIA_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, BiomeDictionary.getBiomes(Type.WASTELAND));
				generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, BiomeDictionary.getBiomes(Type.WASTELAND));
				generateStructure(StructureList.DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, BiomeDictionary.getBiomes(Type.WASTELAND));
				generateStructure(StructureList.DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, BiomeDictionary.getBiomes(Type.WASTELAND));
				generateStructure(StructureList.DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, BiomeDictionary.getBiomes(Type.WASTELAND));
				generateBuryStructure(StructureList.HORCRUX, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpecials, BiomeDictionary.getBiomes(Type.WASTELAND));
				generateStructure(StructureList.FALLEN_DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.WASTELAND));
				generateStructure(StructureList.FALLEN_DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.WASTELAND));
				generateStructure(StructureList.FALLEN_DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, BiomeDictionary.getBiomes(Type.WASTELAND));
				generateUndergroundStructure(StructureList.TOMB_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs + 500, BiomeDictionary.getBiomes(Type.WASTELAND));				
				generateUndergroundStructure(StructureList.UNDERGOUND_NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, BiomeDictionary.getBiomes(Type.WASTELAND));
				generateUndergroundStructure(StructureList.FALL_TRAP, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, BiomeDictionary.getBiomes(Type.WASTELAND));		
				generateDownsetStructure(StructureList.TOWER_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, BiomeDictionary.getBiomes(Type.WASTELAND));				
				generateDownsetStructure(StructureList.TOWER_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, BiomeDictionary.getBiomes(Type.WASTELAND));	
				generateDownsetStructure(StructureList.ALTAR_TOTEM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.WASTELAND));
				generateDownsetStructure(StructureList.ALTAR_TOTEM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.WASTELAND));
				generateDownsetStructure(StructureList.ALTAR_TOTEM_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.WASTELAND));
				//Spooky
				generateUndergroundStructure(StructureList.SILVERFISH_CLUSTER_SMALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSilverfishCluster, BiomeDictionary.getBiomes(Type.SPOOKY));				
				generateUndergroundStructure(StructureList.SILVERFISH_CLUSTER_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceSilverfishCluster, BiomeDictionary.getBiomes(Type.SPOOKY));
				generateUndergroundStructure(StructureList.UNDERGOUND_NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, BiomeDictionary.getBiomes(Type.SPOOKY));
				generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, BiomeDictionary.getBiomes(Type.SPOOKY));
				generateDownsetStructure(StructureList.ALTAR_TOTEM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.SPOOKY));
				generateDownsetStructure(StructureList.ALTAR_TOTEM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.SPOOKY));
				generateDownsetStructure(StructureList.ALTAR_TOTEM_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, BiomeDictionary.getBiomes(Type.SPOOKY));
			    }
			  }
			}
		  }
		}
	}


	
	private void generateStructure(WorldGenerator generator, World world, Random random, int blockX, int blockZ, int chance, Set<Biome> set) {
		int chanceModified = random.nextInt((int) Math.max(ConfigStructures.generationModifier * chance, 1.0f));    
		
		int blockY = StructureGenerator.getGroundFromAbove(world, blockX, blockZ);
		BlockPos pos = new BlockPos(blockX, blockY + 1, blockZ);
		
		Biome biome = world.getChunkFromBlockCoords(pos).getBiome(pos, world.getBiomeProvider());
		
		if(set.contains(biome)) {
			if(chanceModified == 0) {
					generator.generate(world, random, pos);
			}
		}
	}
	
	
	private void generateDownsetStructure(WorldGenerator generator, World world, Random random, int blockX, int blockZ, int chance, Set<Biome> set) {
		int chanceModified = random.nextInt((int) Math.max(ConfigStructures.generationModifier * chance, 1.0f));    

		int blockY = StructureGenerator.getGroundFromAbove(world, blockX, blockZ);
		BlockPos pos = new BlockPos(blockX, blockY , blockZ);
		
		Biome biome = world.getChunkFromBlockCoords(pos).getBiome(pos, world.getBiomeProvider());
		
		if(set.contains(biome)) {
			if(chanceModified == 0) {
					generator.generate(world, random, pos);
			}
		}
	}
	
	
	private void generateBuryStructure(WorldGenerator generator, World world, Random random, int blockX, int blockZ, int chance, Set<Biome> set) {
		int chanceModified = random.nextInt((int) Math.max(ConfigStructures.generationModifier * chance, 1.0f));    

		int blockY = StructureGenerator.getGroundFromAbove(world, blockX, blockZ);
		BlockPos pos = new BlockPos(blockX, blockY - 2, blockZ);
		
		Biome biome = world.getChunkFromBlockCoords(pos).getBiome(pos, world.getBiomeProvider());
		
		if(set.contains(biome)) {
			if(chanceModified == 0) {
					generator.generate(world, random, pos);
			}
		}
	}
	

	private void generateUndergroundStructure(WorldGenerator generator, World world, Random random, int blockX, int blockZ, int chance, Set<Biome> set) {
		int chanceModified = random.nextInt((int) Math.max(ConfigStructures.generationModifier * chance, 1.0f));    
		
		int blockY = StructureGenerator.getGroundFromAbove(world, blockX, blockZ);
		BlockPos pos = new BlockPos(blockX, 	(int)(Math.random() * ((blockY - 20 - 25) + 1)) + 25,	 blockZ);
		
		Biome biome = world.getChunkFromBlockCoords(pos).getBiome(pos, world.getBiomeProvider());
		
		if(set.contains(biome)) {
			if(chanceModified == 0) {		
					generator.generate(world, random, pos);
			}
		}
	}
	
	
	private void generateFlyingStructure(WorldGenerator generator, World world, Random random, int blockX, int blockZ, int chance, Set<Biome> set) {
		int chanceModified = random.nextInt((int) Math.max(ConfigStructures.generationModifier * chance, 1.0f));    
		
		int blockY = StructureGenerator.getGroundFromAbove(world, blockX, blockZ);
		BlockPos pos = new BlockPos(blockX, random.nextInt(230) + blockY + 35, blockZ);
		
		Biome biome = world.getChunkFromBlockCoords(pos).getBiome(pos, world.getBiomeProvider());
		
		if(set.contains(biome)) {
			if(chanceModified == 0) {	
					generator.generate(world, random, pos);
			}
		}
	}
	
	
		
    private static List<?> getBiomeList() {
        ArrayList<Class> biomeClassList = new ArrayList<>();
        for (Biome biome : biomeList) {
            if (biome != null) {
                biomeClassList.add(biome.getBiomeClass());
            }
        }
        return biomeClassList;
    }
}
