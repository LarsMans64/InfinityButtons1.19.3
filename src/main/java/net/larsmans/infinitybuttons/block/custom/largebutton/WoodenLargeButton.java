package net.larsmans.infinitybuttons.block.custom.largebutton;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.larsmans.infinitybuttons.block.custom.button.WoodenButton;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class WoodenLargeButton extends WoodenButton {

    public final boolean isNetherWood;

    public WoodenLargeButton(FabricBlockSettings settings, boolean isNetherWood) {
        super(settings);
        this.isNetherWood = isNetherWood;
    }

    @Override
    protected SoundEvent getClickSound(boolean powered) {
        if (isNetherWood) {
            return powered ? SoundEvents.BLOCK_NETHER_WOOD_BUTTON_CLICK_ON : SoundEvents.BLOCK_NETHER_WOOD_BUTTON_CLICK_OFF;
        }
        return powered ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return LargeButtonShape.outlineShape(state);
    }
}

