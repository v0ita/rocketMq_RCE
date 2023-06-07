package me.gv7.woodpecker.vuldb;

import me.gv7.woodpecker.plugin.IExploit;
import me.gv7.woodpecker.plugin.IPluginHelper;
import me.gv7.woodpecker.plugin.IVulPlugin;
import me.gv7.woodpecker.plugin.IVulPluginCallbacks;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: VulPluginInfo
 * @Description: TODO
 * @Author: yz
 * @Date: 2023-06-05
 * @Version: v1.0
 * @Description:
 **/
public class RocketMqInfo implements IVulPlugin {

    public static IVulPluginCallbacks   callbacks;
    public static IPluginHelper         pluginHelper;

    public void VulPluginMain(IVulPluginCallbacks iVulPluginCallbacks) {
        this.callbacks = iVulPluginCallbacks;
        this.pluginHelper = callbacks.getPluginHelper();
        callbacks.setVulPluginName("RocketMQ RCE CVE-2023-33246");
        callbacks.setVulPluginAuthor("yz");
        callbacks.setVulId("CVE-2023-33246");
        callbacks.setVulDescription("Apache RocketMQ是一个分布式消息平台。在其5.1.0版本及以前存在一处命令执行漏洞，攻击者通过向其更新配置相关的功能发送指令即可更新任意配置项，并通过配置项中存在的命令注入功能执行任意命令。");
        callbacks.setVulCVSS(9.8);
        callbacks.setVulName("RocketMQ RCE CVE-2023-33246");
        callbacks.setVulSeverity("high");
        callbacks.setVulProduct("RocketMQ");
        callbacks.setVulScope("Apache RocketMQ <= 5.1.0");


        //  注册 Exploit 模块，Exploit 模块的作用对漏洞发起攻击
        List<IExploit> exploitList = new ArrayList<>();
//        exploitList.add();
    }
}
