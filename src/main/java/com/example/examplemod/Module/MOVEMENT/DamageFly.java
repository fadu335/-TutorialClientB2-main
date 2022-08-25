package com.example.examplemod.Module.MOVEMENT;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import yea.bushroot.clickgui.Setting;

public class DamageFly extends Module {

    public DamageFly() {
        super("DamageFly", Keyboard.KEY_NONE, Category.MOVEMENT);
        ExampleMod.instance.settingsManager.rSetting(new Setting("Vertical", this, 2.0, 1.0, 4.0, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Horizontal", this, 50.0, 1.0, 200.0, false));
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent e) {
        double vertical = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Vertical").getValDouble();
        double horizontal = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Horizontal").getValDouble();
        if (mc.player.hurtTime == mc.player.maxHurtTime && mc.player.maxHurtTime > 0) {
            mc.player.jump();
            mc.player.motionZ *= horizontal;
            mc.player.motionX *= horizontal;
            mc.player.motionY *= vertical;
        }
    }
}
