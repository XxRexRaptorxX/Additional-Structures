package xxrexraptorxx.additionalstructures.world;

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
import xxrexraptorxx.additionalstructures.config.ConfigGeneral;
import xxrexraptorxx.additionalstructures.config.ConfigStructures;

public class WorldGenStructures implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		if (world.getWorldInfo().isMapFeaturesEnabled() && world.getWorldType() != WorldType.FLAT) {
			int blockX = chunkX * 16 + random.nextInt(16); // (chunkZ * 16) + random.nextInt(15) OLD
			int blockZ = chunkZ * 16 + random.nextInt(16);

			if (world.provider.getDimension() == DimensionType.THE_END.getId()) {
				if (ConfigGeneral.activateEndGeneration) {
					generateEndFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.END));
				}
			} else if (world.provider.getDimension() == DimensionType.NETHER.getId()) {
				if (ConfigGeneral.activateNetherGeneration) {
					generateNetherFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.NETHER));
				}
			} else if (ConfigGeneral.additionalDimensions.length > 0) {
				for (int i = 0; i < ConfigGeneral.additionalDimensions.length; i++) {
					int dimension = ConfigGeneral.additionalDimensions[i];

					if (world.provider.getDimension() == dimension) {

						if (ConfigGeneral.activateOverworldGeneration) {
							generateOverworldFeatures(world, random, blockX, blockZ);
						}
					}
				}
			}
		}
	}
	
	protected void generateEndFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateStructure(StructureList.BONE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceBones, set);
		generateStructure(StructureList.BONE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceBones, set);
		generateDownsetStructure(StructureList.END_ALTAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.END_ALTAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.END_HOUSE, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndBuildings, set);
		generateDownsetStructure(StructureList.END_VILLA, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndBuildings, set);
		generateDownsetStructure(StructureList.END_PILLARS, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateDownsetStructure(StructureList.END_TOWER_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndTowers, set);
		generateDownsetStructure(StructureList.END_TOWER_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndTowers, set);
		generateDownsetStructure(StructureList.END_TOWER_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndTowers, set);
		generateDownsetStructure(StructureList.END_TOWER_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndTowers, set);
		generateStructure(StructureList.END_WALL_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, set);
		generateStructure(StructureList.END_WALL_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, set);
		generateStructure(StructureList.END_WALL_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, set);
		generateStructure(StructureList.END_CRYSTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndCrystals, set);
		generateStructure(StructureList.FOSSIL_ENDERDRAGON_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFossils, set);
		generateStructure(StructureList.FOSSIL_ENDERDRAGON_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFossils, set);
		generateDownsetStructure(StructureList.FOSSIL_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFossils, set);
		generateDownsetStructure(StructureList.FOSSIL_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFossils, set);
		generateStructure(StructureList.SKULL_WITHER, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, set);
		generateDownsetStructure(StructureList.OBSIDIAN_PILLAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianPillars, set);
		generateDownsetStructure(StructureList.OBSIDIAN_PILLAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianPillars, set);
		generateDownsetStructure(StructureList.OBSIDIAN_PILLAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianPillars, set);
		generateDownsetStructure(StructureList.OBSIDIAN_PILLAR_BROKEN_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianPillars, set);
		generateDownsetStructure(StructureList.OBSIDIAN_PILLAR_BROKEN_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianPillars, set);
		generateDownsetStructure(StructureList.NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, set);
		generateUndergroundStructure(StructureList.END_DUNGEON, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, set);
		generateDownsetStructure(StructureList.END_RUIN, world, random, blockX, blockZ, ConfigStructures.spawnchanceRuins, set);
		generateDownsetStructure(StructureList.ENDBRICK_PILLAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateDownsetStructure(StructureList.ENDBRICK_PILLAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateBuryStructure(StructureList.OBSIDIAN_SPIKES_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianSpikes, set);
		generateBuryStructure(StructureList.OBSIDIAN_SPIKES_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianSpikes, set);
		generateBuryStructure(StructureList.OBSIDIAN_SPIKES_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceObsidianSpikes, set);
		generateBuryStructure(StructureList.END_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndTrees, set);
		generateBuryStructure(StructureList.END_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceEndTrees, set);
		generateBuryStructure(StructureList.SHULKER_CLUSTER_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceShulkerClusters, set);
		generateBuryStructure(StructureList.SHULKER_CLUSTER_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceShulkerClusters, set);
	}
	
	protected void generateNetherFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		/*
		generateStructure(StructureList.WITHER_ALTAR, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpecials, set);
		generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, set);
		generateDownsetStructure(StructureList.FOSSIL_ENDERDRAGON_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFossils, set);
		generateStructure(StructureList.NETHER_WALL_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, set);
		generateStructure(StructureList.NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, set);
		generateDownsetStructure(StructureList.FOSSIL_1, world, random, blockX, blockZ, Math.round(ConfigStructures.spawnchanceFossils / 4), set);
		generateDownsetStructure(StructureList.FOSSIL_2, world, random, blockX, blockZ, Math.round(ConfigStructures.spawnchanceFossils / 4), set);
		generateDownsetStructure(StructureList.BONE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceBones, set);
		generateDownsetStructure(StructureList.BONE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceBones, set);
		generateStructure(StructureList.NETHER_WALL_1, world, random, blockX, blockZ, 200, set);
		generateStructure(StructureList.NETHER_WALL_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, set);
		generateStructure(StructureList.NETHER_WALL_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, set);
		generateStructure(StructureList.NETHER_DUNGEON_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, set);
		generateStructure(StructureList.NETHER_DUNGEON_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, set);
		generateStructure(StructureList.NETHER_DUNGEON_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, set);
		generateStructure(StructureList.NETHER_BASE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);
		generateStructure(StructureList.NETHER_BUILDING_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherBuildings, set);
		generateStructure(StructureList.NETHER_BUILDING_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherBuildings, set);
		generateStructure(StructureList.NETHER_BUILDING_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherBuildings, set);
		generateStructure(StructureList.NETHER_VILLAGER_HOUSE, world, random, blockX, blockZ, ConfigStructures.spawnchanceVillagerHouses, set);
		*/
	}

	protected void generateOverworldFeatures(World world, Random random, int blockX, int blockZ) {
		generateDesertFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.SANDY));
		generateSnowFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.SNOWY));
		generateJungleFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.JUNGLE));
		generateSwampFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.SWAMP));
		generateForestFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.FOREST));
		generatePlainsFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.PLAINS));
		generateMountainFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.MOUNTAIN));
		generateMesaFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.MESA));
		generateOceanFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.OCEAN));
		generateSavannaFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.SAVANNA));
		generateWastelandFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.WASTELAND));
		generateSpookyFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.SPOOKY));
	}

	protected void generateDesertFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateStructure(StructureList.DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.BIG_CACTUS, world, random, blockX, blockZ, ConfigStructures.spawnchanceBiggerCacti, set);
		generateStructure(StructureList.HUGE_CACTUS, world, random, blockX, blockZ, ConfigStructures.spawnchanceBiggerCacti, set);
		generateStructure(StructureList.SMALL_PYRAMIDE, world, random, blockX, blockZ, ConfigStructures.spawnchancePyramides, set);
		generateStructure(StructureList.PYRAMIDE_TEMPLE, world, random, blockX, blockZ, ConfigStructures.spawnchanceTemple, set);
		generateStructure(StructureList.ACACIA_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, set);
		generateStructure(StructureList.ROCK_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.ROCK_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.ROCK_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateDownsetStructure(StructureList.ROCK_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.SAND_ROCK_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.SAND_ROCK_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.SAND_ROCK_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateDownsetStructure(StructureList.DESERT_PILLARS_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceDesertPillars, set);
		generateDownsetStructure(StructureList.DESERT_PILLARS_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceDesertPillars, set);
		generateDownsetStructure(StructureList.SAND_TOTEM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceTotems, set);
		generateStructure(StructureList.SAND_TOTEM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceTotems, set);
		generateDownsetStructure(StructureList.SAND_TOTEM_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTotems, set);
		generateBuryStructure(StructureList.OASE, world, random, blockX, blockZ, ConfigStructures.spawnchanceOasis, set);
		generateDownsetStructure(StructureList.OASE_SMALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceOasis, set);
		generateStructure(StructureList.PALM_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchancePalms, set);
		generateStructure(StructureList.PALM_SMALL, world, random, blockX, blockZ, ConfigStructures.spawnchancePalms, set);
		generateStructure(StructureList.PALM_1, world, random, blockX, blockZ, ConfigStructures.spawnchancePalms, set);
		generateStructure(StructureList.PALM_2, world, random, blockX, blockZ, ConfigStructures.spawnchancePalms, set);
		generateUndergroundStructure(StructureList.DESERT_TOMB, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, set);
		generateBuryStructure(StructureList.PYRAMIDE_DUNGEON, world, random, blockX, blockZ, ConfigStructures.spawnchancePyramideDungeon, set);
		generateDownsetStructure(StructureList.SPHINX, world, random, blockX, blockZ, ConfigStructures.spawnchanceSphinx, set);
		generateDownsetStructure(StructureList.PYRAMIDE_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchancePyramides, set);
		generateStructure(StructureList.FALLEN_DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateStructure(StructureList.FALLEN_DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateStructure(StructureList.FALLEN_DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateStructure(StructureList.FALLEN_PALM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateStructure(StructureList.FALLEN_PALM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateUndergroundStructure(StructureList.SARCOPHAGUS_ROOM, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, set);
	}
	
	protected void generateSnowFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateStructure(StructureList.SNOWMAN, world, random, blockX, blockZ, ConfigStructures.spawnchanceSnowmen, set);
		generateStructure(StructureList.SNOWMAN_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSnowmen, set);
		generateStructure(StructureList.DEAD_SPRUCE_TREE, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.SPRUCE_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.FALLEN_SPRUCE_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateStructure(StructureList.FALLEN_SPRUCE_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateStructure(StructureList.SNOW_PILE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSnowPiles, set);
		generateStructure(StructureList.SNOW_PILE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSnowPiles, set);
		generateStructure(StructureList.SNOW_PILE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSnowPiles, set);
	}
	
	protected void generateSwampFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateStructure(StructureList.WITCH_BREWING_STAND, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, set);
		generateStructure(StructureList.SCARECROW, world, random, blockX, blockZ, ConfigStructures.spawnchanceScarecrow, set);
		generateStructure(StructureList.ILLAGER_HOUSE, world, random, blockX, blockZ, ConfigStructures.spawnchanceIllagerHouses, set);
		generateDownsetStructure(StructureList.ALTAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_BIG_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_BIG_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, set);
		generateStructure(StructureList.OAK_LOG_SHORT, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.OAK_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateUndergroundStructure(StructureList.TOMB, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, set);
		generateBuryStructure(StructureList.HORCRUX, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpecials, set);
		generateUndergroundStructure(StructureList.TOMB_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs + 500, set);
		generateDownsetStructure(StructureList.TOWER_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, set);				
		generateDownsetStructure(StructureList.TOWER_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, set);	
		generateDownsetStructure(StructureList.ALTAR_TOTEM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_TOTEM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_TOTEM_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
	}
	
	protected void generateJungleFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateStructure(StructureList.TREE_HOLE, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.DEAD_JUNGLE_TREE, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.JUNGLE_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.BIG_JUNGLE_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.FALLEN_JUNGLE_TREE, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateStructure(StructureList.OAK_LOG_SHORT, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateBuryStructure(StructureList.MAYA_TEMPLE, world, random, blockX, blockZ, ConfigStructures.spawnchanceMayaTemple, set);
		generateDownsetStructure(StructureList.ALTAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_BIG_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_BIG_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.JUNGLE_TEMPLE, world, random, blockX, blockZ, ConfigStructures.spawnchanceTemple, set);
		generateUndergroundStructure(StructureList.FALL_TRAP, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, set);
		generateUndergroundStructure(StructureList.TOMB, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, set);
		generateUndergroundStructure(StructureList.TOMB_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs + 500, set);
		generateStructure(StructureList.MUSHROOM, world, random, blockX, blockZ, ConfigStructures.spawnchanceMushrooms, set);
		generateStructure(StructureList.STONE_PILLAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateStructure(StructureList.STONE_PILLAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateStructure(StructureList.STONE_PILLAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
	}
	
	protected void generateForestFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateStructure(StructureList.OAK_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.OAK_LOG_SHORT, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.SPRUCE_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.SPRUCE_LOG_SHORT, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.LOG_BUNDLE, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogBundle, set);
		generateStructure(StructureList.DEAD_OAK_TREE, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.BUSH_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, set);
		generateStructure(StructureList.BUSH_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, set);
		generateStructure(StructureList.BUSH_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, set);
		generateStructure(StructureList.BUSH_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, set);
		generateStructure(StructureList.SCARECROW, world, random, blockX, blockZ, ConfigStructures.spawnchanceScarecrow, set);
		generateStructure(StructureList.ROCK_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.ROCK_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.ROCK_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateDownsetStructure(StructureList.ROCK_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.ROCK_COBBLE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.ROCK_COBBLE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.ROCK_COBBLE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.FALLEN_OAK_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateStructure(StructureList.FALLEN_OAK_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateDownsetStructure(StructureList.ALTAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_BIG_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_BIG_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateBuryStructure(StructureList.GRAVE, world, random, blockX, blockZ, ConfigStructures.spawnchanceGrave, set);
		generateStructure(StructureList.ILLAGER_HOUSE, world, random, blockX, blockZ, ConfigStructures.spawnchanceIllagerHouses, set);
		generateDownsetStructure(StructureList.NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, set);
		generateStructure(StructureList.VILLAGER_HOUSE, world, random, blockX, blockZ, ConfigStructures.spawnchanceVillagerHouses, set);
		generateStructure(StructureList.VILLAGER_HOUSE_SMALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceVillagerHouses, set);
		generateBuryStructure(StructureList.WELL_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceWell, set);
		generateBuryStructure(StructureList.WELL_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceWell, set);
		generateStructure(StructureList.VILLAGER_HOUSE_BROCKEN, world, random, blockX, blockZ, ConfigStructures.spawnchanceVillagerHouses + 500, set);
		generateUndergroundStructure(StructureList.SPIDER_NEST_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpiderNests, set);
		generateUndergroundStructure(StructureList.SPIDER_NEST_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpiderNests, set);
		generateUndergroundStructure(StructureList.SPIDER_NEST_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpiderNests, set);
		generateUndergroundStructure(StructureList.DUNGEON_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, set);
		generateUndergroundStructure(StructureList.DUNGEON_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, set);
		generateUndergroundStructure(StructureList.UNDERGROUND_BASE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);
		generateUndergroundStructure(StructureList.UNDERGROUND_VILLAGE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);
		generateUndergroundStructure(StructureList.UNDERGROUND_STOLLEN, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);
		generateUndergroundStructure(StructureList.UNDERGROUND_PRISON, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);
		generateUndergroundStructure(StructureList.SEWAGE_SYSTEM, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);
		generateStructure(StructureList.RUIN, world, random, blockX, blockZ, ConfigStructures.spawnchanceRuins, set);
		generateUndergroundStructure(StructureList.TOMB, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, set);
		generateUndergroundStructure(StructureList.TOMB_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs + 500, set);
		generateBuryStructure(StructureList.CHEST_TRAP, world, random, blockX, blockZ, ConfigStructures.spawnchanceTraps, set);	
		generateUndergroundStructure(StructureList.UNDERGOUND_NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, set);
		generateDownsetStructure(StructureList.TOWER_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, set);
		generateDownsetStructure(StructureList.TOWER_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, set);
		generateStructure(StructureList.MUSHROOM, world, random, blockX, blockZ, ConfigStructures.spawnchanceMushrooms, set);
		generateDownsetStructure(StructureList.ALTAR_TOTEM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_TOTEM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_TOTEM_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
	}
	
	protected void generatePlainsFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateStructure(StructureList.ROCK_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.ROCK_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.ROCK_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateDownsetStructure(StructureList.ROCK_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateDownsetStructure(StructureList.CAMP, world, random, blockX, blockZ, ConfigStructures.spawnchanceCamps, set);
		generateStructure(StructureList.SCARECROW, world, random, blockX, blockZ, ConfigStructures.spawnchanceScarecrow, set);
		generateStructure(StructureList.BUSH_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, set);
		generateStructure(StructureList.BUSH_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, set);
		generateStructure(StructureList.BUSH_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, set);
		generateStructure(StructureList.BUSH_4, world, random, blockX, blockZ, ConfigStructures.spawnchanceBushes, set);
		generateStructure(StructureList.SCARECROW, world, random, blockX, blockZ, ConfigStructures.spawnchanceScarecrow, set);
		generateBuryStructure(StructureList.GRAVE, world, random, blockX, blockZ, ConfigStructures.spawnchanceGrave, set);
		generateBuryStructure(StructureList.MINE_ENTRY, world, random, blockX, blockZ, ConfigStructures.spawnchanceMineEntry, set);
		generateStructure(StructureList.OAK_LOG_SHORT, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.STONE_PILLAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateStructure(StructureList.STONE_PILLAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateStructure(StructureList.STONE_PILLAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateUndergroundStructure(StructureList.TOMB, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, set);
		generateStructure(StructureList.VILLAGER_HOUSE, world, random, blockX, blockZ, ConfigStructures.spawnchanceVillagerHouses, set);
		generateStructure(StructureList.VILLAGER_HOUSE_SMALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceVillagerHouses, set);
		generateBuryStructure(StructureList.WALL_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, set);
		generateStructure(StructureList.WALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceWallRuins, set);
		generateStructure(StructureList.WHEAT_BALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceWheatBalls, set);
		generateBuryStructure(StructureList.WELL_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceWell, set);
		generateBuryStructure(StructureList.WELL_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceWell, set);
		generateDownsetStructure(StructureList.FARM, world, random, blockX, blockZ, ConfigStructures.spawnchanceFarm, set);
		generateUndergroundStructure(StructureList.DUNGEON_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, set);
		generateUndergroundStructure(StructureList.DUNGEON_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, set);
		generateUndergroundStructure(StructureList.UNDERGROUND_BASE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);
		generateUndergroundStructure(StructureList.TOMB_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs + 500, set);
		generateUndergroundStructure(StructureList.UNDERGROUND_VILLAGE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);
		generateUndergroundStructure(StructureList.UNDERGROUND_STOLLEN, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);
		generateUndergroundStructure(StructureList.UNDERGROUND_PRISON, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, set);
		generateUndergroundStructure(StructureList.SEWAGE_SYSTEM, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);
		generateStructure(StructureList.RUIN, world, random, blockX, blockZ, ConfigStructures.spawnchanceRuins, set);
		generateBuryStructure(StructureList.STONE_CIRCLE_RUIN, world, random, blockX, blockZ, ConfigStructures.spawnchanceRuins, set);
		generateDownsetStructure(StructureList.TOWER_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, set);
		generateDownsetStructure(StructureList.TOWER_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, set);
		generateStructure(StructureList.MUSHROOM, world, random, blockX, blockZ, ConfigStructures.spawnchanceMushrooms + 5000, set);
	}
	
	protected void generateMountainFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateStructure(StructureList.ROCK_COBBLE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.ROCK_COBBLE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.ROCK_COBBLE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceRocks, set);
		generateStructure(StructureList.STONE_PILLAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateStructure(StructureList.STONE_PILLAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateStructure(StructureList.STONE_PILLAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateBuryStructure(StructureList.LAVA_FOUNTAIN, world, random, blockX, blockZ, ConfigStructures.spawnchanceLavaFountain, set);
		generateBuryStructure(StructureList.METEOR, world, random, blockX, blockZ, ConfigStructures.spawnchanceMeteor, set);
		generateBuryStructure(StructureList.MINE_ENTRY, world, random, blockX, blockZ, ConfigStructures.spawnchanceMineEntry ,set);
		generateUndergroundStructure(StructureList.TOMB, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, set);
		generateBuryStructure(StructureList.FLAG, world, random, blockX, blockZ, ConfigStructures.spawnchanceOthers + 1500, set);
		generateUndergroundStructure(StructureList.SPIDER_NEST_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpiderNests, set);
		generateUndergroundStructure(StructureList.SPIDER_NEST_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpiderNests, set);
		generateUndergroundStructure(StructureList.SPIDER_NEST_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpiderNests, set);
		generateUndergroundStructure(StructureList.UNDERGROUND_BASE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);				
		generateUndergroundStructure(StructureList.UNDERGROUND_VILLAGE, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);				
		generateUndergroundStructure(StructureList.UNDERGROUND_STOLLEN, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);				
		generateUndergroundStructure(StructureList.UNDERGROUND_PRISON, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);				
		generateUndergroundStructure(StructureList.SEWAGE_SYSTEM, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundBases, set);							
		generateUndergroundStructure(StructureList.DUNGEON_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, set);				
		generateUndergroundStructure(StructureList.DUNGEON_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceUndergroundDungeons, set);				
		generateUndergroundStructure(StructureList.TOMB_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs + 500, set);				
		generateUndergroundStructure(StructureList.UNDERGOUND_NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, set);
		generateUndergroundStructure(StructureList.FALL_TRAP, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, set);				
		generateUndergroundStructure(StructureList.SILVERFISH_CLUSTER_SMALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSilverfishCluster, set);				
		generateUndergroundStructure(StructureList.SILVERFISH_CLUSTER_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceSilverfishCluster, set);
	}
	
	protected void generateMesaFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateStructure(StructureList.ACACIA_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, set);
		generateStructure(StructureList.DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, set);
		generateStructure(StructureList.DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, set);
		generateStructure(StructureList.DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, set);
		generateBuryStructure(StructureList.LAVA_FOUNTAIN, world, random, blockX, blockZ, ConfigStructures.spawnchanceLavaFountain, set);
		generateStructure(StructureList.SAND_TOTEM_RED, world, random, blockX, blockZ, ConfigStructures.spawnchanceTotems, set);
		generateDownsetStructure(StructureList.SAND_TOTEM_RED_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTotems, set);
		generateStructure(StructureList.STONE_PILLAR_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateStructure(StructureList.STONE_PILLAR_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
		generateStructure(StructureList.STONE_PILLAR_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceStonePillars, set);
	}
	
	protected void generateOceanFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateDownsetStructure(StructureList.BOAT, world, random, blockX, blockZ, ConfigStructures.spawnchanceBoats, set);
		generateDownsetStructure(StructureList.RAFT, world, random, blockX, blockZ, ConfigStructures.spawnchanceBoats, set);
		generateDownsetStructure(StructureList.OAK_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceFlotsam, set);
		generateDownsetStructure(StructureList.FLOTSAM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFlotsam, set);
		generateDownsetStructure(StructureList.FLOTSAM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFlotsam, set);
		generateDownsetStructure(StructureList.FLOTSAM_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceFlotsam, set);
	}
	
	protected void generateSavannaFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateStructure(StructureList.ACACIA_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, set);
		generateStructure(StructureList.DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, set);
		generateStructure(StructureList.DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, set);
		generateStructure(StructureList.DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, set);
		generateStructure(StructureList.FALLEN_DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateStructure(StructureList.FALLEN_DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateStructure(StructureList.FALLEN_DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
	}
	
	protected void generateWastelandFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateStructure(StructureList.ACACIA_LOG, world, random, blockX, blockZ, ConfigStructures.spawnchanceLogs, set);
		generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, set);
		generateStructure(StructureList.DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, set);
		generateStructure(StructureList.DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, set);
		generateStructure(StructureList.DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceDeadTrees, set);
		generateBuryStructure(StructureList.HORCRUX, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpecials, set);
		generateStructure(StructureList.FALLEN_DEAD_TREE_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateStructure(StructureList.FALLEN_DEAD_TREE_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateStructure(StructureList.FALLEN_DEAD_TREE_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceFallenTrees, set);
		generateUndergroundStructure(StructureList.TOMB_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs + 500, set);
		generateUndergroundStructure(StructureList.UNDERGOUND_NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, set);
		generateUndergroundStructure(StructureList.FALL_TRAP, world, random, blockX, blockZ, ConfigStructures.spawnchanceTombs, set);
		generateDownsetStructure(StructureList.TOWER_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, set);
		generateDownsetStructure(StructureList.TOWER_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceTowers, set);
		generateDownsetStructure(StructureList.ALTAR_TOTEM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_TOTEM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_TOTEM_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
	}
	
	protected void generateSpookyFeatures(World world, Random random, int blockX, int blockZ, Set<Biome> set) {
		generateUndergroundStructure(StructureList.SILVERFISH_CLUSTER_SMALL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSilverfishCluster, set);
		generateUndergroundStructure(StructureList.SILVERFISH_CLUSTER_BIG, world, random, blockX, blockZ, ConfigStructures.spawnchanceSilverfishCluster, set);
		generateUndergroundStructure(StructureList.UNDERGOUND_NETHER_PORTAL, world, random, blockX, blockZ, ConfigStructures.spawnchanceNetherPortals, set);
		generateStructure(StructureList.SKULL, world, random, blockX, blockZ, ConfigStructures.spawnchanceSkulls, set);
		generateDownsetStructure(StructureList.ALTAR_TOTEM_1, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_TOTEM_2, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
		generateDownsetStructure(StructureList.ALTAR_TOTEM_3, world, random, blockX, blockZ, ConfigStructures.spawnchanceSpawnAltars, set);
	}
	
	private boolean generationChanceRoll(Random random, int chance) {
		if(chance <= 0) {
			return false;
		}

		return random.nextInt(Math.max((int)(ConfigStructures.generationModifier * chance), 1)) == 0;
	}

	
	private void generateStructure(WorldGenerator generator, World world, Random random, int blockX, int blockZ, int chance, Set<Biome> set) {
		boolean rollPassed = generationChanceRoll(random, chance);
		
		int blockY = StructureGenerator.getGroundFromAbove(world, blockX, blockZ);
		BlockPos pos = new BlockPos(blockX, blockY + 1, blockZ);
		
		Biome biome = world.getChunkFromBlockCoords(pos).getBiome(pos, world.getBiomeProvider());
		
		if(set == null || set.contains(biome)) {
			if(rollPassed) {
					generator.generate(world, random, pos);
			}
		}
	}
	
	
	private void generateDownsetStructure(WorldGenerator generator, World world, Random random, int blockX, int blockZ, int chance, Set<Biome> set) {
		boolean rollPassed = generationChanceRoll(random, chance);

		int blockY = StructureGenerator.getGroundFromAbove(world, blockX, blockZ);
		BlockPos pos = new BlockPos(blockX, blockY , blockZ);
		
		Biome biome = world.getChunkFromBlockCoords(pos).getBiome(pos, world.getBiomeProvider());
		
		if(set == null || set.contains(biome)) {
			if(rollPassed) {
					generator.generate(world, random, pos);
			}
		}
	}
	
	
	private void generateBuryStructure(WorldGenerator generator, World world, Random random, int blockX, int blockZ, int chance, Set<Biome> set) {
		boolean rollPassed = generationChanceRoll(random, chance);

		int blockY = StructureGenerator.getGroundFromAbove(world, blockX, blockZ);
		BlockPos pos = new BlockPos(blockX, blockY - 2, blockZ);
		
		Biome biome = world.getChunkFromBlockCoords(pos).getBiome(pos, world.getBiomeProvider());
		
		if(set == null || set.contains(biome)) {
			if(rollPassed) {
					generator.generate(world, random, pos);
			}
		}
	}
	

	private void generateUndergroundStructure(WorldGenerator generator, World world, Random random, int blockX, int blockZ, int chance, Set<Biome> set) {
		boolean rollPassed = generationChanceRoll(random, chance);
		
		int blockY = StructureGenerator.getGroundFromAbove(world, blockX, blockZ);
		BlockPos pos = new BlockPos(blockX, 	(int)(Math.random() * ((blockY - 20 - 25) + 1)) + 25,	 blockZ);
		
		Biome biome = world.getChunkFromBlockCoords(pos).getBiome(pos, world.getBiomeProvider());
		
		if(set == null || set.contains(biome)) {
			if(rollPassed) {
					generator.generate(world, random, pos);
			}
		}
	}
	
	/*
	private void generateFlyingStructure(WorldGenerator generator, World world, Random random, int blockX, int blockZ, int chance, Set<Biome> set) {
		boolean rollPassed = generationChanceRoll(random, chance);
		
		int blockY = StructureGenerator.getGroundFromAbove(world, blockX, blockZ);
		BlockPos pos = new BlockPos(blockX, random.nextInt(230) + blockY + 35, blockZ);
		
		Biome biome = world.getChunkFromBlockCoords(pos).getBiome(pos, world.getBiomeProvider());
		
		if(set == null || set.contains(biome)) {
			if(rollPassed) {
					generator.generate(world, random, pos);
			}
		}
	}*/
	
	
	/*
    private static List<?> getBiomeList() {
        ArrayList<Class> biomeClassList = new ArrayList<>();
        for (Biome biome : biomeList) {
            if (biome != null) {
                biomeClassList.add(biome.getBiomeClass());
            }
        }
        return biomeClassList;
    }*/
}
