package net.larsmans.infinitybuttons.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.larsmans.infinitybuttons.InfinityButtonsInit;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class InfinityButtonsItems {

    /**
     * Torches
     */

    public static final Item TORCH_BUTTON = InfinityButtonsItems.registerItem("torch_button", new VerticallyAttachableBlockItem(InfinityButtonsBlocks.TORCH_BUTTON, InfinityButtonsBlocks.WALL_TORCH_BUTTON, new FabricItemSettings(), Direction.DOWN));

    public static final Item TORCH_LEVER = InfinityButtonsItems.registerItem("torch_lever", new VerticallyAttachableBlockItem(InfinityButtonsBlocks.TORCH_LEVER, InfinityButtonsBlocks.WALL_TORCH_LEVER, new FabricItemSettings(), Direction.DOWN));

    public static final Item SOUL_TORCH_BUTTON = InfinityButtonsItems.registerItem("soul_torch_button", new VerticallyAttachableBlockItem(InfinityButtonsBlocks.SOUL_TORCH_BUTTON, InfinityButtonsBlocks.SOUL_WALL_TORCH_BUTTON, new FabricItemSettings(), Direction.DOWN));

    public static final Item SOUL_TORCH_LEVER = InfinityButtonsItems.registerItem("soul_torch_lever", new VerticallyAttachableBlockItem(InfinityButtonsBlocks.SOUL_TORCH_LEVER, InfinityButtonsBlocks.SOUL_WALL_TORCH_LEVER, new FabricItemSettings(), Direction.DOWN));

    public static final Item REDSTONE_TORCH_BUTTON = InfinityButtonsItems.registerItem("redstone_torch_button", new VerticallyAttachableBlockItem(InfinityButtonsBlocks.REDSTONE_TORCH_BUTTON, InfinityButtonsBlocks.REDSTONE_WALL_TORCH_BUTTON, new FabricItemSettings(), Direction.DOWN));

    public static final Item REDSTONE_TORCH_LEVER = InfinityButtonsItems.registerItem("redstone_torch_lever", new VerticallyAttachableBlockItem(InfinityButtonsBlocks.REDSTONE_TORCH_LEVER, InfinityButtonsBlocks.REDSTONE_WALL_TORCH_LEVER, new FabricItemSettings(), Direction.DOWN));

    /**
     * Methods
     */

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(InfinityButtonsInit.MOD_ID, name), item);
    }

    public static void registerModItems() {
        InfinityButtonsInit.LOGGER.debug("Registering Mod Items for Infinity Buttons");
    }
}
