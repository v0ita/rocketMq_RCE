package me.gv7.woodpecker.plugin;

import me.gv7.woodpecker.vuldb.RocketMqInfo;

/**
 * @ClassName: WoodpeckerPluginManager
 * @Description: TODO
 * @Author: yz
 * @Date: 2023-06-05
 * @Version: v1.0
 * @Description:
 **/
public class WoodpeckerPluginManager implements IPluginManager{
    public void registerPluginManagerCallbacks(IPluginManagerCallbacks iPluginManagerCallbacks) {
        final RocketMqInfo vulInfo = new RocketMqInfo();

        iPluginManagerCallbacks.registerVulPlugin(vulInfo);
    }
}
