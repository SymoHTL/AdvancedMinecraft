package aids.modules.impl.visual;

import aids.modules.Category;
import aids.modules.Module;
import org.lwjgl.input.Keyboard;

public class FullBright extends Module {
    private float previousSetting;

    public FullBright() {
        super("FullBright", "see in the dark", Keyboard.KEY_M, Category.VISUAL);
    }

    @Override
    public void onEnable() {
        previousSetting = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 100;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        mc.gameSettings.gammaSetting = previousSetting;
        super.onDisable();
    }
}
