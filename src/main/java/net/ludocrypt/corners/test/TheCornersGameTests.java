package net.ludocrypt.corners.test;

import net.ludocrypt.corners.block.RadioBlock;
import net.ludocrypt.corners.init.CornerBlocks;
import net.ludocrypt.corners.init.CornerPaintings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameType;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

@GameTestHolder("corners")
public class TheCornersGameTests {

    @GameTest(template = "empty")
    @PrefixGameTestTemplate(false)
    public void testBrokenRadioPlacement(GameTestHelper helper) {
        BlockPos pos = new BlockPos(1, 2, 1);
        helper.setBlock(pos, CornerBlocks.BROKEN_RADIO.get().defaultBlockState().setValue(RadioBlock.FACING, Direction.NORTH));
        helper.assertBlockPresent(CornerBlocks.BROKEN_RADIO.get(), pos);
        helper.succeed();
    }

    @GameTest(template = "empty")
    @PrefixGameTestTemplate(false)
    public void testGoldIngotInsertion(GameTestHelper helper) {
        BlockPos pos = new BlockPos(1, 2, 1);
        helper.setBlock(pos, CornerBlocks.BROKEN_RADIO.get().defaultBlockState().setValue(RadioBlock.FACING, Direction.NORTH));

        Player player = helper.makeMockPlayer(GameType.SURVIVAL);
        player.setItemInHand(net.minecraft.world.InteractionHand.MAIN_HAND, new ItemStack(Items.GOLD_INGOT));
        helper.useBlock(pos, player);

        helper.assertBlockPresent(CornerBlocks.WOODEN_RADIO.get(), pos);
        helper.succeed();
    }
}
