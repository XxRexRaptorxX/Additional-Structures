package xxrexraptorxx.additionalstructures.world;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import xxrexraptorxx.additionalstructures.config.ConfigGeneral;
import xxrexraptorxx.additionalstructures.main.AdditionalStructures;
import xxrexraptorxx.additionalstructures.main.Reference;
import xxrexraptorxx.additionalstructures.util.DebugHelper;

/**
 * Generate a structure with a random rotation, and automatically filled loot
 * tabled contains (if set up correctly using data structure blocks)
 * 
 * @author CJMinecraft + and heavy modified by me!
 *
 */
public class StructureGenerator extends WorldGenerator {

	/**
	 * The name of the structure
	 */
	private String structureName;

	/**
	 * Allows the user to generate a structure from the template at the
	 * structure name
	 * 
	 * @param structureName
	 *            The name of the structure to generate
	 */
	public StructureGenerator(String structureName) {
		this.structureName = structureName;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		WorldServer worldServer = (WorldServer) world;
		MinecraftServer minecraftServer = world.getMinecraftServer();
		TemplateManager templateManager = worldServer.getStructureTemplateManager();
		Template template = templateManager.get(minecraftServer, new ResourceLocation(Reference.MODID, this.structureName));
		int variation = 3;

		if (template == null) {
			// The template does not exist
			System.err.println("The structure: " + this.structureName + " did not exist!");
			return false;
		}
		
		if (this.structureName.endsWith("_")) {
			// The template is a bury structure
			variation = 8;
		} else if (this.structureName.startsWith("underground_") || this.structureName.startsWith("flying_") || world.provider.getDimension() == -1) {
			// The template is a underground or flying structure
			variation = 200;
		} else {
			// The template is a "normal" structure
			variation = 3;
		}
		
		if (canSpawnHere(template, worldServer, position, variation)) {
			// The structure can spawn here
			Rotation rotation = Rotation.values()[rand.nextInt(3)];									// WIP (bug)
			PlacementSettings settings = new PlacementSettings().setMirror(Mirror.NONE).setRotation(getRotation()).setIgnoreStructureBlock(false);
			template.addBlocksToWorld(world, position, settings);

			Map<BlockPos, String> dataBlocks = template.getDataBlocks(position, settings);
			// Structure blocks with loottables become replaced with chests
			for (Entry<BlockPos, String> entry : dataBlocks.entrySet()) {
				try {
					String[] data = entry.getValue().split(" ");
					if (data.length < 2)
						continue;
					Block block = Block.getBlockFromName(data[0]);
					IBlockState state = null;
					if (data.length == 3)
						state = block.getStateFromMeta(Integer.parseInt(data[2]));
					else
						state = block.getDefaultState();
					for (Entry<IProperty<?>, Comparable<?>> entry2 : block.getDefaultState().getProperties()
							.entrySet()) {
						if (entry2.getKey().getValueClass().equals(EnumFacing.class)
								&& entry2.getKey().getName().equals("facing")) {
							state = state.withRotation(rotation.add(Rotation.CLOCKWISE_180));
							break;
						}
					}
					world.setBlockState(entry.getKey(), state, 3);
					TileEntity te = world.getTileEntity(entry.getKey());
					if (te == null)
						continue;
					if (te instanceof TileEntityLockableLoot)
						((TileEntityLockableLoot) te).setLootTable(new ResourceLocation(data[1]), rand.nextLong());
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
			
			if (position.getY() > 0) {
				DebugHelper.Logger("Structure (" + this.structureName + ") generated at: "+ position.getX() + " " + position.getY() + " " + position.getZ());
			} else {
				DebugHelper.ErrorLogger("Spawning of structure (" + this.structureName + ") failed.");
			}
			
			// Places foundations under flying structures
			if (!this.structureName.startsWith("underground_") || world.provider.getDimension() != DimensionType.NETHER.getId()){
				final int searchRange = 10;
				int posX = position.getX();
				int posY = position.getY() - 1;   
				int posZ = position.getZ();
	
				for (int x = 0; x < template.getSize().getX(); x++) {
					
					for (int z = 0; z < template.getSize().getZ(); z++) {
	
						for (int y = 0; y < searchRange; y++) {
							
							if (world.getBlockState(new BlockPos(posX, posY, posZ)).getBlock() == Blocks.AIR || world.getBlockState(new BlockPos(posX, posY, posZ)).getBlock() == Blocks.TALLGRASS || 
									world.getBlockState(new BlockPos(posX, posY, posZ)).getBlock() == Blocks.DOUBLE_PLANT || world.getBlockState(new BlockPos(posX, posY, posZ)).getBlock() == Blocks.DEADBUSH) {
								
								if(BiomeDictionary.hasType(world.getBiome(position), Type.SANDY)) {
									world.setBlockState(new BlockPos(posX, posY, posZ), Blocks.SAND.getDefaultState());
								
								} else if(BiomeDictionary.hasType(world.getBiome(position), Type.NETHER)) {
										world.setBlockState(new BlockPos(posX, posY, posZ), Blocks.AIR.getDefaultState());			//!!!!!!!!!!!!!!!!! WIP !!!!!!!!!!!!!!!!!!!
								
								} else if(BiomeDictionary.hasType(world.getBiome(position), Type.END)) {
									world.setBlockState(new BlockPos(posX, posY, posZ), Blocks.END_STONE.getDefaultState());					
	
								} else {
									world.setBlockState(new BlockPos(posX, posY, posZ), Blocks.DIRT.getDefaultState());
								}
								
								if (position.getY() > 0) {
									DebugHelper.Logger("Foundation for " + this.structureName + " generated at: " + posX + " " + posY + " " + posZ + ", with rotation: " + settings.getRotation());
								}
								
								posY = posY - 1;
							}
						}
						posY = position.getY() - 1;
						
						if(settings.getRotation() == rotation.NONE) {
							posZ = posZ + 1;
						} else if (settings.getRotation() == rotation.CLOCKWISE_180) {
							posZ = posZ - 1;
						} else if (settings.getRotation() == rotation.CLOCKWISE_90) {
							posZ = posZ + 1;
						} else if (settings.getRotation() == rotation.COUNTERCLOCKWISE_90) {
							posZ = posZ - 1;
						}
					}
					posZ = position.getZ();
					
					if(settings.getRotation() == rotation.NONE) {
						posX = posX + 1;
					} else if (settings.getRotation() == rotation.CLOCKWISE_180) {
						posX = posX - 1;
					} else if (settings.getRotation() == rotation.CLOCKWISE_90) {
						posX = posX - 1;
					} else if (settings.getRotation() == rotation.COUNTERCLOCKWISE_90) {
						posX = posX + 1;
					}
				}
				posX = position.getX(); //?

			}
			
			
			return true;
		}
		// The structure can't spawn here
		
		DebugHelper.ErrorLogger("Not accepted position for (" + this.structureName + ") at: " + position.getX() + " " + position.getY() + " " + position.getZ());
		return false;
	}

	/**
	 * Checks whether the given template can spawn at the given position in the
	 * world
	 * 
	 * @param template
	 *            The template / structure to check
	 * @param world
	 *            The world which the structure will be spawned in
	 * @param pos
	 *            The position that the structure will be spawned at
	 * @return Whether the given template can spawn at the given position in the
	 *         world
	 */
	public static boolean canSpawnHere(Template template, World world, BlockPos pos, int variation) {
		return isCornerValid(world, pos, variation) && isCornerValid(world, pos.add(template.getSize().getX(), 0, 0), variation)
				&& isCornerValid(world, pos.add(template.getSize().getX(), 0, template.getSize().getZ()), variation)
				&& isCornerValid(world, pos.add(0, 0, template.getSize().getZ()), variation);
	}

	/**
	 * Checks whether the corner is valid (i.e. the position is with the
	 * variation range of the ground level
	 * 
	 * @param world
	 *            The world which contains the position
	 * @param pos
	 *            The position of the corner
	 * @return Whether the corner is valid
	 */
	public static boolean isCornerValid(World world, BlockPos pos, int variation) {
		int groundY = getGroundFromAbove(world, pos.getX(), pos.getZ());
		return groundY > pos.getY() - variation && groundY < pos.getY() + variation;
	}

	/**
	 * Gets the position of the ground going from build height downwards. <br>
	 * 
	 * @param world
	 *            The world to get the blocks from
	 * @param x
	 *            The x position of the block to get the ground y value
	 * @param z
	 *            The z position of the block to get the ground y value
	 * @return The ground y level (or -99 if the ground was not found 
	 * 		   or not accepted
	 */
	public static int getGroundFromAbove(World world, int x, int z) {
		int y = -99;
		
		//Nether Generator
		if(world.provider.getDimension() == DimensionType.NETHER.getId()) {
		/**
			while(world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.NETHERRACK.getDefaultState() && world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.AIR.getDefaultState()) {
				y--;
			}
		**/
			
		// Normal generator
		} else {

			y = world.getActualHeight();
			boolean foundGround = false;
	
			while (!foundGround && y-- > 0) {
				Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
				
				foundGround = !(block == Blocks.AIR || block == Blocks.TALLGRASS || block == Blocks.SNOW_LAYER || block == Blocks.LEAVES || block == Blocks.LEAVES2 ||
						block == Blocks.LOG || block == Blocks.LOG2 || block == Blocks.RED_FLOWER || block == Blocks.YELLOW_FLOWER || block == Blocks.CACTUS || 
						block == Blocks.WATERLILY || block == Blocks.DOUBLE_PLANT);
			}
		}
		
		
		BlockPos pos = new BlockPos(x, y - 1, z);

		//Not accepted positions
		if (world.getBlockState(pos).getBlock() == Blocks.WATER && !BiomeDictionary.hasType(world.getBiome(pos), Type.OCEAN)){	
			y = -99;
		}
		if (world.getBlockState(pos).getBlock() == Blocks.LAVA || world.getBlockState(pos).getBlock() == Blocks.AIR  || world.getBlockState(pos).getBlock() == Blocks.ICE  || world.getBlockState(pos).getBlock() == Blocks.PACKED_ICE){	
			y = -99;
		}
		 
		return y;		
	}
	
	
	/**
	 * Get a rotation. This is a provisionally method to avoid a bug in the 
	 * foundation generator ;(
	 * 
	 * @return A specific random rotation
	 */
	public static Rotation getRotation() {
		Random random = new Random();

			if (random.nextInt(2) == 1) {
				return Rotation.CLOCKWISE_180;
			} else {
				return Rotation.NONE;
			}
	}
	

}