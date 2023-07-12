package net.larsmans.infinitybuttons.compat.jade;

import net.larsmans.infinitybuttons.InfinityButtonsInit;
import net.larsmans.infinitybuttons.block.custom.secretbutton.AbstractSecretButton;
import net.larsmans.infinitybuttons.block.custom.torch.RedstoneTorchButton;
import net.larsmans.infinitybuttons.block.custom.torch.TorchButton;
import net.minecraft.util.Identifier;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;
import snownee.jade.api.config.IWailaConfig;

@WailaPlugin
public class InfinityButtonsPlugin implements IWailaPlugin {

    static final Identifier CONFIG_HIDE_SECRET_BUTTONS = new Identifier(InfinityButtonsInit.MOD_ID, "hide_secret_buttons");
    static final Identifier CONFIG_HIDE_TORCH_BUTTONS = new Identifier(InfinityButtonsInit.MOD_ID, "hide_torch_buttons");

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.addConfig(CONFIG_HIDE_SECRET_BUTTONS, true);
        registration.addConfig(CONFIG_HIDE_TORCH_BUTTONS, true);
        registration.addRayTraceCallback((hitResult, accessor, originalAccessor) -> {
            if (accessor instanceof BlockAccessor blockAccessor) {
                if (IWailaConfig.get().getPlugin().get(CONFIG_HIDE_SECRET_BUTTONS) && blockAccessor.getBlock() instanceof AbstractSecretButton) {
                    return registration.blockAccessor().from(blockAccessor).blockState(((AbstractSecretButton) blockAccessor.getBlock()).jadeBlock.getDefaultState()).build();
                }
                if (IWailaConfig.get().getPlugin().get(CONFIG_HIDE_TORCH_BUTTONS) && blockAccessor.getBlock() instanceof TorchButton) {
                    return registration.blockAccessor().from(blockAccessor).blockState(((TorchButton) blockAccessor.getBlock()).jadeBlock.getDefaultState()).build();
                }
                if (IWailaConfig.get().getPlugin().get(CONFIG_HIDE_TORCH_BUTTONS) && blockAccessor.getBlock() instanceof RedstoneTorchButton) {
                    return registration.blockAccessor().from(blockAccessor).blockState(((RedstoneTorchButton) blockAccessor.getBlock()).jadeBlock.getDefaultState()).build();
                }
            }
            return accessor;
        });
    }
}
