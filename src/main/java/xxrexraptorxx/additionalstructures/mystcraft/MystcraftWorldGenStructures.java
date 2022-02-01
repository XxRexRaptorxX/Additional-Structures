package xxrexraptorxx.additionalstructures.mystcraft;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import xxrexraptorxx.additionalstructures.world.WorldGenStructures;
import com.xcompwiz.mystcraft.Mystcraft;

public class MystcraftWorldGenStructures extends WorldGenStructures {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (!world.provider.getDimensionType().equals(Mystcraft.dimensionType)) {
			super.generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			return;
		}
		
		// TODO Generate features depending on pages
	}
}
