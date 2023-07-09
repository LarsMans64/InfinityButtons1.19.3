package net.larsmans.infinitybuttons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.larsmans.infinitybuttons.advancement.InfinityButtonsTriggers;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.letterbutton.LetterButton;
import net.larsmans.infinitybuttons.block.custom.letterbutton.LetterButtonEnum;
import net.larsmans.infinitybuttons.block.custom.letterbutton.gui.LetterButtonGui;
import net.larsmans.infinitybuttons.item.InfinityButtonsItemGroups;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfinityButtonsInit implements ModInitializer {
	public static final String MOD_ID = "infinitybuttons";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final net.larsmans.infinitybuttons.config.InfinityButtonsConfig CONFIG = net.larsmans.infinitybuttons.config.InfinityButtonsConfig.createAndLoad();

	@Override
	public void onInitialize() {
		ServerPlayNetworking.registerGlobalReceiver(LetterButtonGui.LETTER_BUTTON_PACKET, (server, player, handler, buf, sender) -> {
			BlockPos pos = buf.readBlockPos();
			LetterButtonEnum letterButtonEnum = buf.readEnumConstant(LetterButtonEnum.class);
			World world = player.getWorld();
			world.setBlockState(pos, world.getBlockState(pos).with(LetterButton.CHARACTER, letterButtonEnum));
		});

		InfinityButtonsItems.registerModItems();
		InfinityButtonsBlocks.registerModBlocks();
		InfinityButtonsSounds.registerSounds();
		InfinityButtonsItemGroups.loadItemGroup();
		InfinityButtonsTriggers.register();
	}
}