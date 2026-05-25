package net.originkirby.mccourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.originkirby.mccourse.MCCourseMod;
import net.originkirby.mccourse.block.ModBlocks;
import net.originkirby.mccourse.block.custom.SoundBlock;
import net.originkirby.mccourse.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .addTag(Tags.Blocks.ORES_NETHERITE_SCRAP)
                .addTag(Tags.Blocks.ORES_IRON)
                .addTag(Tags.Blocks.ORES_COPPER)
                .addTag(Tags.Blocks.ORES_GOLD);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ALEXANDRITE_BLOCK.get(),
                        ModBlocks.RAW_ALEXANDRITE_BLOCK.get(),

                        ModBlocks.ALEXANDRITE_ORE.get(),
                        ModBlocks.NETHER_ALEXANDRITE_ORE.get(),
                        ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                        ModBlocks.END_ALEXANDRITE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE);

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ALEXANDRITE_BLOCK.get(),
                        ModBlocks.RAW_ALEXANDRITE_BLOCK.get(),

                        ModBlocks.ALEXANDRITE_ORE.get()
                        );

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_ALEXANDRITE_ORE.get(),
                        ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                        ModBlocks.END_ALEXANDRITE_ORE.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
