package dmillerw.menu.proxy;

import dmillerw.menu.MineMenu;
import dmillerw.menu.data.json.MenuLoader;
import dmillerw.menu.handler.ClientTickHandler;
import dmillerw.menu.handler.KeyboardHandler;
import dmillerw.menu.handler.LogHandler;
import dmillerw.menu.helper.KeyReflectionHelper;
import dmillerw.menu.vive.VivecraftKeyboardHandler;
import dmillerw.menu.vive.VivecraftReflector;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author dmillerw
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        KeyReflectionHelper.gatherFields();

        if(VivecraftReflector.isInstalled()) {
            VivecraftKeyboardHandler.register();
        } else {
            KeyboardHandler.register();
            ClientTickHandler.register();
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);

        if (!MineMenu.menuFile.exists()) {
            MenuLoader.save(MineMenu.menuFile);
        }
        MenuLoader.load(MineMenu.menuFile);
        if(VivecraftReflector.isInstalled()) {
            LogHandler.info("Vivecraft detected!");
        } else {
            LogHandler.info("Vivecraft not detected.");
        }
    }
}