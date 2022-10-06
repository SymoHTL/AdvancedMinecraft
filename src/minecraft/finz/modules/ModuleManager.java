package finz.modules;

import finz.modules.impl.combat.Aimbot;
import finz.modules.impl.combat.Critical;
import finz.modules.impl.combat.KillAura;
import finz.modules.impl.combat.Velocity;
import finz.modules.impl.misc.PickBlock;
import finz.modules.impl.misc.PickUpItems;
import finz.modules.impl.misc.Timer;
import finz.modules.impl.movement.*;
import finz.modules.impl.player.AutoMine;
import finz.modules.impl.player.FastPlace;
import finz.modules.impl.player.NoFall;
import finz.modules.impl.player.NoHunger;
import finz.modules.impl.ui.HUD;
import finz.modules.impl.visual.Debug;
import finz.modules.impl.visual.ESP.*;
import finz.modules.impl.visual.FullBright;

import java.util.ArrayList;

public class ModuleManager {
    protected ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        init();
    }

    public void init() {
        // COMBAT
        add(new Velocity());
        add(new KillAura());
        add(new Critical());
        add(new Aimbot());
        // MOTION
        add(new Sprint());
        add(new Fly());
        add(new AutoWalk());
        add(new Top());
        add(new JetPack());
        add(new Spider());
        add(new ScaffoldWalk());
        // PLAYER
        add(new FastPlace());
        add(new NoFall());
        add(new AutoMine());
        add(new NoHunger());
        // MISC
        add(new Timer());
        add(new PickBlock());
        add(new PickUpItems());
        // VISUAL
        add(new FullBright());
        add(new BlockESP());
        add(new Debug());

        add(new FindOreESP());
        add(new PlayerESP());
        add(new MobESP());
        add(new AnimalESP());
        // HUD
        add(new HUD());
    }

    public void add(Module module) {
        modules.add(module);
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public Module getModule(String name) {
        return modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Module getEnabledModule(String name) {
        for (Module module : modules) {
            if (module.getName().equalsIgnoreCase(name) && module.isEnabled())
                return module;
        }
        return null;
    }

    public ArrayList<Module> getEnabledModules() {
        ArrayList<Module> enabledModules = new ArrayList<>();
        for (Module module : modules) {
            if (module.isEnabled())
                enabledModules.add(module);
        }
        return enabledModules;
    }
}