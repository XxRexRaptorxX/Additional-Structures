package xxrexraptorxx.additionalstructures.mystcraft;

import java.util.List;
import java.util.Random;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import xxrexraptorxx.additionalstructures.config.ConfigGeneral;
import xxrexraptorxx.additionalstructures.main.Reference;
import xxrexraptorxx.additionalstructures.world.WorldGenStructures;
import com.xcompwiz.mystcraft.Mystcraft;
import com.xcompwiz.mystcraft.world.WorldProviderMyst;
import com.xcompwiz.mystcraft.world.agedata.AgeData;

/**
 * Mystcraft-enabled version of structure generator.
 * If Mystcraft dimension is detected, it wi
 * 
 * @author v19930312
 *
 */
public class MystcraftWorldGenStructures extends WorldGenStructures {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (!world.provider.getDimensionType().equals(Mystcraft.dimensionType)) {
			super.generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			return;
		}
		
		int dimId = world.provider.getDimension();
		
		try {
			if (world.provider instanceof WorldProviderMyst) {
				if (dimId < 0) {
					// Mystcraft's profiling dimension: use overworld generation
					if (ConfigGeneral.activateOverworldGeneration) {
						generateOverworldFeatures(world, random, chunkX, chunkZ);
					}
					return;
				}
				
				AgeData data = AgeData.getAge(dimId, false);
				List<ResourceLocation> symbolList = data.getSymbols(false);

				if (symbolList.contains(Reference.SYMBOL_NORMAL_STRUCTURE_GENERATION)) {
					// Features are filtered by biome, so call all generators
					int blockX = chunkX * 16 + random.nextInt(16);
					int blockZ = chunkZ * 16 + random.nextInt(16);

					generateNetherFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.NETHER));
					generateOverworldFeatures(world, random, blockX, blockZ);
					generateEndFeatures(world, random, blockX, blockZ, BiomeDictionary.getBiomes(Type.END));
				}

				int blockX = chunkX * 16 + random.nextInt(16);
				int blockZ = chunkZ * 16 + random.nextInt(16);
				
				if (symbolList.contains(Reference.SYMBOL_END_STRUCTURES))
					generateEndFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_NETHER_STRUCTURES))
					generateNetherFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_DESERT_STRUCTURES))
					generateDesertFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_SNOW_STRUCTURES))
					generateSnowFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_JUNGLE_STRUCTURES))
					generateJungleFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_SWAMP_STRUCTURES))
					generateSwampFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_FOREST_STRUCTURES))
					generateForestFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_PLAINS_STRUCTURES))
					generatePlainsFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_MOUNTAIN_STRUCTURES))
					generateMountainFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_MESA_STRUCTURES))
					generateMesaFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_OCEAN_STRUCTURES))
					generateOceanFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_SAVANNA_STRUCTURES))
					generateSavannaFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_WASTELAND_STRUCTURES))
					generateWastelandFeatures(world, random, blockX, blockZ, null);

				if (symbolList.contains(Reference.SYMBOL_SPOOKY_STRUCTURES))
					generateSpookyFeatures(world, random, blockX, blockZ, null);
			}
		} catch (NullPointerException e) {
			System.out.println("NPE in Additional Structure's Mystcraft generator");
			return;
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Dimension ID: " + Integer.toString(dimId));
		}
	}
}
