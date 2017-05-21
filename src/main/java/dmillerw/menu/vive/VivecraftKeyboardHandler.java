package dmillerw.menu.vive;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

/**
 * Alternative keyboard handler for Vivecraft.
 */
public class VivecraftKeyboardHandler {

    private static VivecraftKeyboardHandler INSTANCE = new VivecraftKeyboardHandler();

    private final KeyBinding OPEN_RADIAL_MENU = new KeyBinding("key.open_menu", Keyboard.KEY_NONE, "key.categories.misc");

    private VivecraftKeyboardHandler() {

    }

    public static void register() {
        MinecraftForge.EVENT_BUS.register(VivecraftKeyboardHandler.INSTANCE);
    }
}
